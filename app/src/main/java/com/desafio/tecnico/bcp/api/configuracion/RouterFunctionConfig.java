package com.desafio.tecnico.bcp.api.configuracion;

import com.desafio.tecnico.bcp.api.handle.TipoCambioHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction <ServerResponse> routes(TipoCambioHandler handler){
        return RouterFunctions.
                route(RequestPredicates.GET("/api/moneda"),handler::findAll)
                .andRoute(RequestPredicates.GET("/api/tipoCambio"),handler::findAllTypeAmount)
                .andRoute(RequestPredicates.POST("/api/calcularResultado"),handler::calculateResult)
                .andRoute(RequestPredicates.POST("/api/moneda"),handler::save);

    }
}
