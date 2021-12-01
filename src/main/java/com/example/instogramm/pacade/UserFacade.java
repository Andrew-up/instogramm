package com.example.instogramm.pacade;


import com.example.instogramm.dto.UserDTO;
import com.example.instogramm.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    public UserDTO userToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setUsername(user.getUsername());
        user.setInfo(user.getInfo());
        return userDTO;
    }
}
