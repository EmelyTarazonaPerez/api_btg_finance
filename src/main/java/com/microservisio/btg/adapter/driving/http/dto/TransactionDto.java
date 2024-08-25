package com.microservisio.trazabilidad.adapter.driving.http.dto;

import com.microservisio.trazabilidad.utils.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class TransactionDto {
    public String id;
    public String userId;
    public FundDto fund;
    public float amount;
    public Date date;
    public boolean active;
    private Type type;
    public TransactionDto(
            String id,
            String userId,
            FundDto fund,
            float amount,
            Date date,
            boolean active) {
        this.id = id;
        this.userId = userId;
        this.fund = fund;
        this.amount = amount;
        this.date = date;
        this.active = active;
    }
}
