package com.desafio.tecnico.bcp.api.dto;

import com.desafio.tecnico.bcp.api.entidad.TipoCambio;
import lombok.Data;

@Data
public class TipoCambioRequest {
    private TipoCambio tipoCambio;
    private Double monto;

}
