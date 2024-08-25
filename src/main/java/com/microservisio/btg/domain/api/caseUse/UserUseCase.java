package com.microservisio.trazabilidad.domain.api.caseUse;

import com.microservisio.trazabilidad.domain.api.IUserServicePort;
import com.microservisio.trazabilidad.domain.model.UserModel;
import com.microservisio.trazabilidad.domain.spi.IUserPersistencePort;
import com.microservisio.trazabilidad.utils.Contants;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userRepository;

    public UserUseCase(IUserPersistencePort userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel getDemoUser() {
        String idUser = Contants.ADMIN_PORTAL;

        return userRepository.getUser(idUser);
    }
}
