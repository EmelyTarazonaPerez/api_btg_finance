package com.microservisio.trazabilidad.adapter.driven.mongol.adapter;

import com.microservisio.trazabilidad.adapter.driven.mongol.document.FundEntity;
import com.microservisio.trazabilidad.adapter.driven.mongol.mapper.IFundEntityMapper;
import com.microservisio.trazabilidad.adapter.driven.mongol.repository.IFundRepository;
import com.microservisio.trazabilidad.domain.model.FundModel;
import com.microservisio.trazabilidad.domain.spi.IFundPersistencePort;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class fundAdapter implements IFundPersistencePort {

    private final IFundRepository fundRepository;
    private final IFundEntityMapper fundEntityMapper;

    public fundAdapter(IFundRepository fundRepository, IFundEntityMapper fundEntityMapper) {
        this.fundRepository = fundRepository;
        this.fundEntityMapper = fundEntityMapper;
    }

    @Override
    public List<FundModel> getFunds() {
        try {
            System.out.println("***************** adapter getFound");
            return fundEntityMapper.toListFundModel(fundRepository.findAll());
        } catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public FundModel getFundById(String fundId) {
        try {
            System.out.println("***************** adapter fund");
            System.out.println("***************** process found fundById " + fundId );

            Optional<FundEntity> optionalFundEntity = fundRepository.findById(fundId);

            if (optionalFundEntity.isPresent()) {
                System.out.println("***************** fund concentrate STATUS 200 OK");
                return this.getFundModel(optionalFundEntity.get());
            } else {
                System.out.println("***************** Fund not found after save STATUS 404");
                return null;
            }
        } catch (Exception e) {
            System.out.println("***************** ERROR FUND NoSQL STATUS 500");
            System.out.println(e.getMessage());
            return null;  // O lanzar una excepción si es necesario
        }
    }

    @Override
    public FundModel getFundModel(FundEntity fundEntity) {
        return fundEntityMapper.toFundModel(fundEntity);
    }

    @Override
    public FundEntity getFundEntity(FundModel fundModel) {
        return fundEntityMapper.toFundEntity(fundModel);
    }
}
