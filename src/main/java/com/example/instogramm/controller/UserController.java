package com.example.instogramm.controller;

import com.example.instogramm.dto.UserDTO;
import com.example.instogramm.entity.User;
import com.example.instogramm.pacade.UserFacade;
import com.example.instogramm.service.UserService;
import com.example.instogramm.validators.ResponseErrorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserFacade userFacade;
    @Autowired
    private UserService userService;
    @Autowired
    private ResponseErrorValidator responseErrorValidator;

    @GetMapping("/")
    public ResponseEntity<UserDTO> getCurrentUser(Principal principal) {
        User user = userService.getCurrentUser(principal);
        UserDTO userDTO = userFacade.userToUserDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable("userId") String userId) {
        User user = userService.getUserById(Long.parseLong(userId));
        UserDTO userDTO = userFacade.userToUserDTO(user);



        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserDTO userDTO,
                                             BindingResult bindingResult, Principal principal) {

        ResponseEntity<Object> listErrors = responseErrorValidator.mappedValidatorService(bindingResult);

        if (!ObjectUtils.isEmpty(listErrors)) return listErrors;
        User user = userService.updateUser(userDTO,principal);
        UserDTO userUpdated = userFacade.userToUserDTO(user);

        return new ResponseEntity<>(userUpdated,HttpStatus.OK);



    }

}
