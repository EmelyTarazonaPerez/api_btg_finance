package com.microservisio.trazabilidad.domain.api;

import com.microservisio.trazabilidad.domain.model.TransactionModel;

import java.util.List;

public interface ITransactionServicePort {
    List<TransactionModel> getTransactions();
}
