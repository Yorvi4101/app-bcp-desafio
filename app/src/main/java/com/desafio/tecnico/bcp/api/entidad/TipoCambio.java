package com.desafio.tecnico.bcp.api.entidad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("tipoCambio")
public class TipoCambio {
    @Id
    private Integer id;

    @Column("moneda_origen")
    @JsonProperty("moneda_origen")
    private String monedaOrigen;

    @Column("moneda_destino")
    @JsonProperty("moneda_destino")
    private String monedaDestino;

    @Column("tipo_cambio")
    @JsonProperty("tipo_cambio")
    private Double tipoCambio;
}
