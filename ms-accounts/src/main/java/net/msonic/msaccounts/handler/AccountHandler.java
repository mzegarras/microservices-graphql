package net.msonic.msaccounts.handler;


import lombok.AllArgsConstructor;
import net.msonic.msaccounts.dto.Account;
import net.msonic.msaccounts.dto.DocumentType;
import net.msonic.msaccounts.dto.Transaction;
import net.msonic.msaccounts.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class AccountHandler {

    private final AccountService accountService;

    public Mono<ServerResponse> findAll(ServerRequest rq){

        String type = rq.queryParam("type").orElse("");
        String number = rq.queryParam("number").orElse("");

        DocumentType documentType = DocumentType.builder()
                .documentType(type)
                .documentNumber(number)
                .build();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(accountService.findAll(documentType), Account.class);

    }

    public Mono<ServerResponse> findAllTransactions(ServerRequest rq){

        String accountId = rq.pathVariable("accountId");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(accountService.findAllTransactions(accountId), Transaction.class);

    }


}
