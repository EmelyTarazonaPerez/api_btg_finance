package com.microservisio.trazabilidad.config;

import com.microservisio.trazabilidad.adapter.driven.mongol.adapter.TransactionAdapter;
import com.microservisio.trazabilidad.adapter.driven.mongol.adapter.UserAdapter;
import com.microservisio.trazabilidad.adapter.driven.mongol.adapter.fundAdapter;
import com.microservisio.trazabilidad.adapter.driven.mongol.mapper.IFundEntityMapper;
import com.microservisio.trazabilidad.adapter.driven.mongol.mapper.ITransactionEntityMapper;
import com.microservisio.trazabilidad.adapter.driven.mongol.mapper.IUserEntityMapper;
import com.microservisio.trazabilidad.adapter.driven.mongol.repository.IFundRepository;
import com.microservisio.trazabilidad.adapter.driven.mongol.repository.ITransactionRepository;
import com.microservisio.trazabilidad.adapter.driven.mongol.repository.IUserRepository;
import com.microservisio.trazabilidad.domain.api.IFundServicePort;
import com.microservisio.trazabilidad.domain.api.ITransactionServicePort;
import com.microservisio.trazabilidad.domain.api.IUserServicePort;
import com.microservisio.trazabilidad.domain.api.caseUse.FundUseCase;
import com.microservisio.trazabilidad.domain.api.caseUse.TransactionUseCase;
import com.microservisio.trazabilidad.domain.api.caseUse.UserUseCase;
import com.microservisio.trazabilidad.domain.spi.IFundPersistencePort;
import com.microservisio.trazabilidad.domain.spi.ITransactionPersistencePort;
import com.microservisio.trazabilidad.domain.spi.IUserPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final IFundRepository fundRepository;
    private final IFundEntityMapper fundEntityMapper;

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    private final ITransactionEntityMapper transactionEntityMapper;
    private final ITransactionRepository transactionRepository;

    public BeanConfiguration(IFundRepository fundRepository,
                             IFundEntityMapper fundEntityMapper,
                             IUserRepository userRepository,
                             IUserEntityMapper userEntityMapper,
                             ITransactionRepository transactionRepository,
                             ITransactionEntityMapper transactionEntityMapper
                             ) {
        this.fundRepository = fundRepository;
        this.fundEntityMapper = fundEntityMapper;
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.transactionRepository = transactionRepository;
        this.transactionEntityMapper = transactionEntityMapper;
    }

    @Bean
    public IFundPersistencePort fundPersistencePort(){
        return new fundAdapter(fundRepository, fundEntityMapper);
    }

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public ITransactionPersistencePort transactionPersistencePort(){
        return new TransactionAdapter(transactionRepository, fundPersistencePort(), transactionEntityMapper);
    }

    @Bean
    public IFundServicePort fundServicePort(){
        return new FundUseCase(fundPersistencePort(), userPersistencePort(), transactionPersistencePort());
    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public ITransactionServicePort transactionServicePort(){
        return new TransactionUseCase(transactionPersistencePort());
    }
}
