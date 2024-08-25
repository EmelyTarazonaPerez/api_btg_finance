package com.microservisio.trazabilidad.adapter.driving.http.dto.ResponseObject;

import com.microservisio.trazabilidad.domain.model.FundModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseModelDto {
    private Object fundModel;
    private String message;
    private boolean success;

    // Getters y Setters
    public ResponseModelDto(Object fundModel, String message, boolean success) {
        this.fundModel = fundModel;
        this.message = message;
        this.success = success;
    }

}
