package com.microservisio.trazabilidad.adapter.driving.http.rest;

import com.microservisio.trazabilidad.adapter.driving.http.dto.FundDto;
import com.microservisio.trazabilidad.adapter.driving.http.dto.InfoSubscribeFundRequest;
import com.microservisio.trazabilidad.adapter.driving.http.dto.ResponseObject.ResponseModelDto;
import com.microservisio.trazabilidad.adapter.driving.http.mapper.IGetFundMapper;
import com.microservisio.trazabilidad.adapter.driving.http.mapper.IInfoSubscribeFundMapper;
import com.microservisio.trazabilidad.adapter.driving.http.mapper.IResponseModelMapper;
import com.microservisio.trazabilidad.domain.api.IFundServicePort;
import com.microservisio.trazabilidad.domain.model.FundModel;
import com.microservisio.trazabilidad.domain.model.ResponseObject.InfoSubscribeFundModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/btg/finance/funds")
@CrossOrigin("http://localhost:4200")
public class FundController {

    private final IFundServicePort servicePort;
    private final IGetFundMapper getFundMapper;
    private final IResponseModelMapper responseModelMapper;
    private final IInfoSubscribeFundMapper infoSubscribeFundMapper;

    public FundController(IFundServicePort servicePort,
                          IGetFundMapper getFundMapper,
                          IResponseModelMapper responseModelMapper,
                          IInfoSubscribeFundMapper infoSubscribeFundMapper) {
        this.servicePort = servicePort;
        this.getFundMapper = getFundMapper;
        this.responseModelMapper = responseModelMapper;
        this.infoSubscribeFundMapper = infoSubscribeFundMapper;
    }

    @GetMapping
    public ResponseEntity<List<FundDto>> listFund() {
        try {
            List<FundModel> fundModels = servicePort.getFunds();
            return new ResponseEntity<>(getFundMapper.toFundDto(fundModels),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/subscribe")
    public ResponseEntity<ResponseModelDto> subscribeToFund(@RequestBody InfoSubscribeFundRequest object) {
        try {
            InfoSubscribeFundModel infoSubscribeFundModel = infoSubscribeFundMapper.toTransactionModel(object);
            return new ResponseEntity<>(responseModelMapper.toResponseModelDto(servicePort.subscribeToFund(infoSubscribeFundModel)),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>( null,
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/unsubscribe/{transactionId}")
    public ResponseEntity<ResponseModelDto> unsubscribeFund(@PathVariable String transactionId) {
        try {
            return new ResponseEntity<>(responseModelMapper.toResponseModelDto(servicePort.unsubscribeFund(transactionId)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( null,
                    HttpStatus.BAD_REQUEST);
        }
    }
}
