package com.microservisio.trazabilidad.adapter.driving.http.rest;

import com.microservisio.trazabilidad.adapter.driving.http.dto.FundDto;
import com.microservisio.trazabilidad.adapter.driving.http.dto.TransactionDto;
import com.microservisio.trazabilidad.adapter.driving.http.dto.UserDto;
import com.microservisio.trazabilidad.adapter.driving.http.mapper.IGetFundMapper;
import com.microservisio.trazabilidad.adapter.driving.http.mapper.ITransactionMapper;
import com.microservisio.trazabilidad.adapter.driving.http.mapper.IUserMapper;
import com.microservisio.trazabilidad.domain.api.IFundServicePort;
import com.microservisio.trazabilidad.domain.api.ITransactionServicePort;
import com.microservisio.trazabilidad.domain.api.IUserServicePort;
import com.microservisio.trazabilidad.domain.model.FundModel;
import com.microservisio.trazabilidad.domain.model.TransactionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/btg/finance/transactions")
@CrossOrigin("http://localhost:4200")
public class TransactionController {
    private final ITransactionServicePort transactionServicePort;
    private final ITransactionMapper transactionMapper;

    public TransactionController(ITransactionServicePort transactionServicePort, ITransactionMapper transactionMapper) {
        this.transactionServicePort = transactionServicePort;
        this.transactionMapper = transactionMapper;
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> list() {
        try {
            List<TransactionModel> transactionModels = transactionServicePort.getTransactions();
            return new ResponseEntity<>(transactionMapper.toListTransactionsDto(transactionModels),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
