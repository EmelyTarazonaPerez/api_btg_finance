package com.microservisio.trazabilidad.domain.spi;

import com.microservisio.trazabilidad.adapter.driven.mongol.document.FundEntity;
import com.microservisio.trazabilidad.domain.model.ResponseObject.InfoSubscribeFundModel;
import com.microservisio.trazabilidad.domain.model.TransactionModel;
import com.microservisio.trazabilidad.utils.Type;

import java.util.List;
import java.util.Optional;

public interface ITransactionPersistencePort {
    void saveTransaction(InfoSubscribeFundModel infoSubscribeFund, FundEntity fund, Type type);
    TransactionModel getTransaction(String id);
    List<TransactionModel> getTransactions();
    void updateTransaction(String transactionId, TransactionModel transactionModel);
    void createTransaction(TransactionModel transactionModel, FundEntity fund);
}
