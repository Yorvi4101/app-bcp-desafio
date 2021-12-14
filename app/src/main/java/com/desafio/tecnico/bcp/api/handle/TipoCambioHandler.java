package com.desafio.tecnico.bcp.api.handle;

import com.desafio.tecnico.bcp.api.dto.TipoCambioRequest;
import com.desafio.tecnico.bcp.api.entidad.TipoCambio;
import com.desafio.tecnico.bcp.api.servicio.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Configuration
public class TipoCambioHandler {

    @Autowired
    private TipoCambioService service;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), TipoCambio.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        Mono<TipoCambio> type = request.bodyToMono(TipoCambio.class);

        return type.flatMap(p-> service.save(p))
                .flatMap(flat->ServerResponse.created(URI.create("api/type/".concat(String.valueOf(flat.getId()))))
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(flat)));
    }

    public Mono<ServerResponse> findAllTypeAmount(ServerRequest req){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAllTypeAmount(), TipoCambio.class);
    }

    public Mono<ServerResponse> calculateResult(ServerRequest req){
        Mono<TipoCambioRequest> currency = req.bodyToMono(TipoCambioRequest.class);
        return currency.flatMap(p->service.calculateResult(p))
                .flatMap(m->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(m)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
