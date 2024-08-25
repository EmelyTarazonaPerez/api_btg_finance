package com.microservisio.trazabilidad.domain.spi;

import com.microservisio.trazabilidad.domain.model.UserModel;

public interface IUserPersistencePort {
    UserModel getUser(String idUser);
    void updateUser(UserModel userModel);
}
