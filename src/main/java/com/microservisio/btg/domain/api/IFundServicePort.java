package com.microservisio.trazabilidad.domain.api;

import com.microservisio.trazabilidad.domain.model.FundModel;
import com.microservisio.trazabilidad.domain.model.ResponseObject.InfoSubscribeFundModel;
import com.microservisio.trazabilidad.domain.model.ResponseObject.ResponseModel;

import java.util.List;

public interface IFundServicePort {
    List<FundModel> getFunds ();
    ResponseModel subscribeToFund (InfoSubscribeFundModel infoSubscribeFund);
    ResponseModel unsubscribeFund (String transactionId);
}
