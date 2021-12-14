package com.desafio.tecnico.bcp.api.servicio.implementacion;


import com.desafio.tecnico.bcp.api.dto.TipoCambioRequest;
import com.desafio.tecnico.bcp.api.dto.TipoCambioResponse;
import com.desafio.tecnico.bcp.api.entidad.TipoCambio;
import com.desafio.tecnico.bcp.api.repositorio.TipoCambioRepository;
import com.desafio.tecnico.bcp.api.servicio.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {
    @Autowired
    private TipoCambioRepository repository;
    @Override
    public Flux<TipoCambio> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<TipoCambio> save(TipoCambio obj) {
        return repository.save(obj);
    }

    @Override
    public Flux<TipoCambio> findAllTypeAmount() {
        return repository.findAllTypeAmount();
    }

    @Override
    public Mono<TipoCambioResponse> calculateResult(TipoCambioRequest request) {
        return repository.calculateResult(request.getTipoCambio().getMonedaOrigen(),request.getTipoCambio().getMonedaDestino())
                .flatMap(p->{
                    TipoCambioResponse resp = new TipoCambioResponse();
                    resp.setTipoCambio(p);
                    resp.setMonto(request.getMonto());
                    resp.setMontoCambiado(request.getMonto()*p.getTipoCambio());
                    return Mono.just(resp); });
    }


}
