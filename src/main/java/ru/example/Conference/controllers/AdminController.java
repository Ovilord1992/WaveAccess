package ru.example.Conference.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.example.Conference.dto.UserDTO;
import ru.example.Conference.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllUsers(){
      return adminService.getAllUsers();
    }

    @GetMapping("/getOneUser")
    public UserDTO getUserFromIdOrUserName(@RequestParam String username){
        return adminService.getUserFromUserName(username);
    }

    @GetMapping("/userRoleAdd")
    public void userAddRole(@RequestParam Long idUser, @RequestParam String role){
        adminService.userAddRole(idUser, role);
    }

    @GetMapping("/userRoleRemove")
    public void userRemoveRole(@RequestParam Long idUser, @RequestParam String role){
        adminService.userRemoveRole(idUser, role);
    }


}
