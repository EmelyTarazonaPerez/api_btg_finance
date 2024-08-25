package com.microservisio.trazabilidad.domain.api.caseUse;

import com.microservisio.trazabilidad.adapter.driven.mongol.document.TransactionEntity;
import com.microservisio.trazabilidad.domain.api.IFundServicePort;
import com.microservisio.trazabilidad.domain.model.FundModel;
import com.microservisio.trazabilidad.domain.model.ResponseObject.InfoSubscribeFundModel;
import com.microservisio.trazabilidad.domain.model.ResponseObject.ResponseModel;
import com.microservisio.trazabilidad.domain.model.TransactionModel;
import com.microservisio.trazabilidad.domain.model.UserModel;
import com.microservisio.trazabilidad.domain.spi.IFundPersistencePort;
import com.microservisio.trazabilidad.domain.spi.ITransactionPersistencePort;
import com.microservisio.trazabilidad.domain.spi.IUserPersistencePort;
import com.microservisio.trazabilidad.utils.Contants;
import com.microservisio.trazabilidad.utils.Type;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class FundUseCase implements IFundServicePort {
    private final IFundPersistencePort fundPersistencePort;
    private final IUserPersistencePort userRepository;
    private final ITransactionPersistencePort transactionPersistencePort;

    public FundUseCase(IFundPersistencePort fundPersistencePort,
                       IUserPersistencePort userRepository,
                       ITransactionPersistencePort transactionPersistencePort) {
        this.fundPersistencePort = fundPersistencePort;
        this.userRepository = userRepository;
        this.transactionPersistencePort = transactionPersistencePort;
    }

    @Override
    public List<FundModel> getFunds() {
        return fundPersistencePort.getFunds();
    }

    @Override
    public ResponseModel subscribeToFund(InfoSubscribeFundModel infoSubscribeFund) {
        String userId = Contants.ADMIN_PORTAL;
        UserModel userModel = userRepository.getUser(userId);
        FundModel fundModelFound = fundPersistencePort.getFundById(infoSubscribeFund.getFundId());

        if (userModel != null) {
            float minAmount = fundModelFound.getMin_amount();
            float availableCash =  userModel.availableCash;

            if (availableCash < minAmount) return new ResponseModel(null, Contants.NO_ENOUGH_BALANCE, false );
            if (infoSubscribeFund.getAmount() < minAmount) return new ResponseModel(null, Contants.NO_SUBSCRITO_MIN_AMOUNT, false );
            if (infoSubscribeFund.getAmount() > availableCash) return new ResponseModel(null, Contants.AMOUNT_GREATER_THAN_BALANCE, false );

            transactionPersistencePort.saveTransaction(infoSubscribeFund, fundPersistencePort.getFundEntity(fundModelFound), Type.OPEN);
            userModel.setAvailableCash(availableCash - infoSubscribeFund.getAmount());
            userRepository.updateUser(userModel);

            return new ResponseModel(fundModelFound, Contants.MESSAGE_SUBSCRIBE_FUND, true );
        }

        return new ResponseModel(null, Contants.ErrorDomain + fundModelFound.getName(), false );
    }

    @Override
    public ResponseModel unsubscribeFund(String transactionId) {
        String userId = Contants.ADMIN_PORTAL;
        UserModel userModel = userRepository.getUser(userId);
        TransactionModel transaction = transactionPersistencePort.getTransaction(transactionId);

        transaction.setActive(false);
        transactionPersistencePort.updateTransaction(transactionId, transaction);

        TransactionModel transactionModel = transaction;
        transactionModel.setType(Type.CLOSE);
        transactionPersistencePort.createTransaction(transactionModel, fundPersistencePort.getFundEntity(transactionModel.fund));

        userModel.setAvailableCash(userModel.availableCash + transaction.amount);
        userRepository.updateUser(userModel);

        return new ResponseModel(userModel, Contants.MESSAGE_UNSUBSCRIBE_FUND, true );
    }
}
