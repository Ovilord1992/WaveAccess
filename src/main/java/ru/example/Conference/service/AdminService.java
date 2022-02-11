package ru.example.Conference.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.example.Conference.dto.UserDTO;
import ru.example.Conference.entity.ERole;
import ru.example.Conference.entity.Roles;
import ru.example.Conference.entity.UserEntity;
import ru.example.Conference.repo.RoleRepository;
import ru.example.Conference.repo.UserRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    ModelMapper modelMapper;


    public List<UserDTO> getAllUsers(){
        List<UserEntity> user = userRepository.findAll();
        return user
                .stream()
                .map(UserService::modelMapUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserFromUserName(String username){
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User with name "+ username + " not found"));
        return UserService.modelMapUserDTO(user);

    }

    public void userAddRole(@RequestParam Long idUser, @RequestParam String role){
        UserEntity user = userRepository.getById(idUser);
        Set<Roles> roles = user.getRoles();
            if (role.equals("admin")) {
                Roles adminRole = roleRepository
                        .findByName(ERole.ROLE_ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error, Role ADMIN is not found"));
                roles.add(adminRole);
            }else if (role.equals("speaker")) {
                Roles speakerRole = roleRepository
                        .findByName(ERole.ROLE_SPEAKER)
                        .orElseThrow(() -> new RuntimeException("Error, Role SPEAKER is not found"));
                roles.add(speakerRole);
            } else {
                Roles userRole = roleRepository
                        .findByName(ERole.ROLE_LISTENER)
                        .orElseThrow(() -> new RuntimeException("Error, Role LISTENER is not found"));
                roles.add(userRole);
            }
            user.setRoles(roles);
            userRepository.save(user);
        };

    @GetMapping("/userRoleRemove")
    public void userRemoveRole(@RequestParam Long idUser, @RequestParam String role){
        UserEntity user = userRepository.getById(idUser);
        Set<Roles> roles = user.getRoles();
        if (role.equals("admin")) {
            Roles adminRole = roleRepository
                    .findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error, Role ADMIN is not found"));
            roles.remove(adminRole);
        }else if (role.equals("speaker")) {
            Roles speakerRole = roleRepository
                    .findByName(ERole.ROLE_SPEAKER)
                    .orElseThrow(() -> new RuntimeException("Error, Role SPEAKER is not found"));
            roles.remove(speakerRole);
        } else {
            Roles userRole = roleRepository
                    .findByName(ERole.ROLE_LISTENER)
                    .orElseThrow(() -> new RuntimeException("Error, Role LISTENER is not found"));
            roles.remove(userRole);
        }
        user.setRoles(roles);
        userRepository.save(user);
    }

}
