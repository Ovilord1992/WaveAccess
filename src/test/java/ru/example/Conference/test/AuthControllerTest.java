package ru.example.Conference.test;

import org.junit.jupiter.api.Test;
import ru.example.Conference.dto.UserDTO;
import ru.example.Conference.entity.ERole;
import ru.example.Conference.entity.Roles;
import ru.example.Conference.entity.UserEntity;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AuthControllerTest {

    @Test
    void authUser() {
        new UserEntity(
                "asdsa",
                "asdas",
                "asdsa",
                Set.of(new Roles(ERole.ROLE_ADMIN))
        );
    }
}