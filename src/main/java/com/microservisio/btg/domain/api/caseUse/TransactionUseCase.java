package com.microservisio.trazabilidad.domain.api.caseUse;

import com.microservisio.trazabilidad.domain.api.ITransactionServicePort;
import com.microservisio.trazabilidad.domain.api.IUserServicePort;
import com.microservisio.trazabilidad.domain.model.FundModel;
import com.microservisio.trazabilidad.domain.model.TransactionModel;
import com.microservisio.trazabilidad.domain.model.UserModel;
import com.microservisio.trazabilidad.domain.spi.IFundPersistencePort;
import com.microservisio.trazabilidad.domain.spi.ITransactionPersistencePort;
import com.microservisio.trazabilidad.domain.spi.IUserPersistencePort;
import com.microservisio.trazabilidad.utils.Contants;

import java.util.List;

public class TransactionUseCase implements ITransactionServicePort {
    private final ITransactionPersistencePort transactionPersistencePort;

    public TransactionUseCase(ITransactionPersistencePort transactionPersistencePort) {
        this.transactionPersistencePort = transactionPersistencePort;
    }

    @Override
    public List<TransactionModel> getTransactions() {
        return transactionPersistencePort.getTransactions();
    }
}
