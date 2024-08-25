package com.microservisio.trazabilidad.adapter.driven.mongol.adapter;

import com.microservisio.trazabilidad.adapter.driven.mongol.document.FundEntity;
import com.microservisio.trazabilidad.adapter.driven.mongol.document.TransactionEntity;
import com.microservisio.trazabilidad.adapter.driven.mongol.mapper.IFundEntityMapper;
import com.microservisio.trazabilidad.adapter.driven.mongol.mapper.ITransactionEntityMapper;
import com.microservisio.trazabilidad.adapter.driven.mongol.repository.ITransactionRepository;
import com.microservisio.trazabilidad.domain.model.FundModel;
import com.microservisio.trazabilidad.domain.model.ResponseObject.InfoSubscribeFundModel;
import com.microservisio.trazabilidad.domain.model.TransactionModel;
import com.microservisio.trazabilidad.domain.spi.IFundPersistencePort;
import com.microservisio.trazabilidad.domain.spi.ITransactionPersistencePort;
import com.microservisio.trazabilidad.utils.Contants;
import com.microservisio.trazabilidad.utils.Type;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionAdapter implements ITransactionPersistencePort {

    private final ITransactionRepository transactionRepository;
    private final IFundPersistencePort fundPersistencePort;
    private final ITransactionEntityMapper transactionEntityMapper;

    public TransactionAdapter(ITransactionRepository transactionRepository, IFundPersistencePort fundPersistencePort, ITransactionEntityMapper transactionEntityMapper) {
        this.transactionRepository = transactionRepository;
        this.fundPersistencePort = fundPersistencePort;
        this.transactionEntityMapper = transactionEntityMapper;
    }

    @Override
    public void saveTransaction(InfoSubscribeFundModel infoSubscribeFund, FundEntity fund, Type type) {
        TransactionEntity transactionEntity = new TransactionEntity();
        ObjectId objectFundId = new ObjectId(infoSubscribeFund.fundId);

        transactionEntity.setUserId(Contants.ADMIN_PORTAL);
        transactionEntity.setFund(fund);
        transactionEntity.setDate(new Date());
        transactionEntity.setAmount(infoSubscribeFund.getAmount());
        transactionEntity.setActive(true);
        transactionEntity.setType(type);

        transactionRepository.save(transactionEntity);
    }

    @Override
    public void createTransaction(TransactionModel transactionModel, FundEntity fund) {
        TransactionEntity transactionEntity = new TransactionEntity();

        transactionEntity.setUserId(transactionModel.userId);
        transactionEntity.setFund(fund);
        transactionEntity.setDate(new Date());
        transactionEntity.setAmount(transactionModel.amount);
        transactionEntity.setActive(transactionModel.active);
        transactionEntity.setType(transactionModel.type);

        transactionRepository.save(transactionEntity);
    }

    @Override
    public TransactionModel getTransaction(String id) {
        try {
            Optional<TransactionEntity> transactionEntity = transactionRepository.findById(id);

            if (transactionEntity.isPresent()) {
                TransactionEntity transaction = transactionEntity.get();

                return new TransactionModel(
                        transaction.getId(),
                        transaction.userId,
                        fundPersistencePort.getFundModel(transaction.fund),
                        transaction.amount,
                        transaction.date,
                        transaction.active,
                        transaction.getType());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void updateTransaction(String transactionId, TransactionModel transactionModel) {
        try {
            TransactionEntity transactionEntity = new TransactionEntity();

            transactionEntity.setId(transactionId);
            transactionEntity.setUserId(transactionModel.userId);
            transactionEntity.setFund(fundPersistencePort.getFundEntity(transactionModel.fund));
            transactionEntity.setAmount(transactionModel.amount);
            transactionEntity.setDate(transactionModel.getDate());
            transactionEntity.setActive(transactionModel.active);
            transactionEntity.setType(transactionModel.type);

            transactionRepository.save(transactionEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TransactionModel> getTransactions() {
        try {
            return transactionEntityMapper.toListTransactionModel(transactionRepository.findAll(Sort.by(Sort.Direction.DESC, "date")));
        } catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}
