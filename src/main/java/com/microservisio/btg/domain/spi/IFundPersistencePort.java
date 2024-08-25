package com.microservisio.trazabilidad.domain.spi;

import com.microservisio.trazabilidad.adapter.driven.mongol.document.FundEntity;
import com.microservisio.trazabilidad.domain.model.FundModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface IFundPersistencePort {
    List<FundModel> getFunds ();
    FundModel getFundById (String object);
    FundModel getFundModel(FundEntity fundEntity);
    FundEntity getFundEntity(FundModel fundModel);
}
