package com.microservisio.trazabilidad.adapter.driving.http.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class InfoSubscribeFundRequest {
    public String fundId;
    public float amount;
}
