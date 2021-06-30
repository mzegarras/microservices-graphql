package net.msonic.customers.handler;

import lombok.AllArgsConstructor;
import net.msonic.customers.dto.Customer;
import net.msonic.customers.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
@AllArgsConstructor
public class CustomerHandler {

    private final CustomerService customerService;

    public Mono<ServerResponse> findAll(ServerRequest rq){

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerService.findAll(), Customer.class);

    }

    public Mono<ServerResponse> getById(ServerRequest rq) {

        String type = rq.pathVariable("type");
        String number = rq.pathVariable("number");

        return customerService.findByDocument(type,number)
                .flatMap(p -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue(p))
        ).switchIfEmpty(ServerResponse.notFound().build());


    }


    public Mono<ServerResponse> create(ServerRequest rq) {

        Mono<Customer> mono = rq.bodyToMono(Customer.class);

        return mono.flatMap(p-> customerService.save(p)
                .flatMap(pdb -> ServerResponse
                        .created(URI.create("/customers/" + pdb.getId()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(pdb))));

    }

}
