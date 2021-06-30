package net.msonic.customers.router;

import net.msonic.customers.handler.CustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@Configuration
public class RouteFunctionConfig {
    @Bean
    public RouterFunction<ServerResponse> routes(CustomerHandler handler){
        return route(GET("/customers"),handler::findAll)
                .and(route(GET("/customers/{type}/{number}"),handler::getById))
                .andRoute(POST("/customers"),handler::create);

    }
}
