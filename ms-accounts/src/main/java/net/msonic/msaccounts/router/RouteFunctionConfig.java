package net.msonic.msaccounts.router;

import net.msonic.msaccounts.handler.AccountHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@Configuration
public class RouteFunctionConfig {
    @Bean
    public RouterFunction<ServerResponse> routes(AccountHandler handler){
        return route(GET("/accounts"),handler::findAll)
                .andRoute(GET("/accounts/{accountId}/transactions"),handler::findAllTransactions);

    }
}
