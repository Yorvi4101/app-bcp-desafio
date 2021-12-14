package com.desafio.tecnico.bcp.api.servicio;

import com.desafio.tecnico.bcp.api.dto.TipoCambioRequest;
import com.desafio.tecnico.bcp.api.dto.TipoCambioResponse;
import com.desafio.tecnico.bcp.api.entidad.TipoCambio;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TipoCambioService {
    Flux<TipoCambio> findAll();
    Mono<TipoCambio> save(TipoCambio obj);
    Flux<TipoCambio> findAllTypeAmount();


    Mono<TipoCambioResponse> calculateResult(TipoCambioRequest request);


}
