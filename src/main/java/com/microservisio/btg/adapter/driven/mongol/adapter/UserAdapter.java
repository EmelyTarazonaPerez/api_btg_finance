package com.microservisio.trazabilidad.adapter.driven.mongol.adapter;

import com.microservisio.trazabilidad.adapter.driven.mongol.document.UserEntity;
import com.microservisio.trazabilidad.adapter.driven.mongol.mapper.IUserEntityMapper;
import com.microservisio.trazabilidad.adapter.driven.mongol.repository.IUserRepository;
import com.microservisio.trazabilidad.domain.model.UserModel;
import com.microservisio.trazabilidad.domain.spi.IUserPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    public UserAdapter(IUserRepository userRepository,IUserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public UserModel getUser(String idUser) {
        try {
            System.out.println("***************** get user by id");
            Optional<UserEntity> userEntity = userRepository.findById(idUser);
            if (userEntity.isPresent()) {
                System.out.println("***************** User found: " + userEntity.get());
                return userEntityMapper.toUserModel(userEntity.get());
            } else {
                System.out.println("***************** User not found: ");
                return  null;
            }
        } catch (Exception e) {
            System.out.println("***************** Error NoSQL: STATUS 500");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void updateUser(UserModel userModel) {
        try {
            userRepository.save(userEntityMapper.toUserEntity(userModel));
            System.out.println("***************** usuario actualizado correctamente");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
