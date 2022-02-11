package ru.example.Conference.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import ru.example.Conference.dto.UserDTO;
import ru.example.Conference.entity.Talk;
import ru.example.Conference.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    public static UserDTO modelMapUserDTO(UserEntity user){
        List<String> role = user.getRoles().stream()
                .map(roles -> (roles.getName().name()))
                .collect(Collectors.toList());
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                role
        );
    }

}
