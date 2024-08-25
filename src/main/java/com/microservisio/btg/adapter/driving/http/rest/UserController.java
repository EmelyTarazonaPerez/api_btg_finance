package com.microservisio.trazabilidad.adapter.driving.http.rest;

import com.microservisio.trazabilidad.adapter.driven.mongol.mapper.IUserEntityMapper;
import com.microservisio.trazabilidad.adapter.driving.http.dto.UserDto;
import com.microservisio.trazabilidad.adapter.driving.http.mapper.IUserMapper;
import com.microservisio.trazabilidad.domain.api.IUserServicePort;
import com.microservisio.trazabilidad.domain.model.FundModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/btg/finance/users")
@CrossOrigin("http://localhost:4200")
public class UserController {

    private final IUserServicePort userServicePort;
    private final IUserMapper userEntityMapper;

    public UserController(IUserServicePort userServicePort, IUserMapper userEntityMapper) {
        this.userServicePort = userServicePort;
        this.userEntityMapper = userEntityMapper;
    }

    @GetMapping("/demo")
    public ResponseEntity<UserDto> getUser() {
        try {
            return new ResponseEntity<>( userEntityMapper.toUserDto(this.userServicePort.getDemoUser()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,
                    HttpStatus.BAD_REQUEST);
        }
    }
}
