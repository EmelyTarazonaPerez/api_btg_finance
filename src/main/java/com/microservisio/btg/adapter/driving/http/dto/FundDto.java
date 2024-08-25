package com.microservisio.trazabilidad.adapter.driving.http.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class FundDto {
    private String id;
    private String name;
    private String code;
    private float min_amount;
    private String category;
}
