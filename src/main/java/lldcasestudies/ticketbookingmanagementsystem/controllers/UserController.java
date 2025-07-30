package lldcasestudies.ticketbookingmanagementsystem.controllers;

import lldcasestudies.ticketbookingmanagementsystem.dtos.*;
import lldcasestudies.ticketbookingmanagementsystem.exceptions.UserNotFoundException;
import lldcasestudies.ticketbookingmanagementsystem.models.User;
import lldcasestudies.ticketbookingmanagementsystem.services.UserService;
import org.springframework.stereotype.Controller;

@Controller

public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDto SignUp(SignUpRequestDto signUpRequestDto) {
        try {
            User user = userService.SignUp(signUpRequestDto.getName(),signUpRequestDto.getEmail(),signUpRequestDto.getPassword());
            SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
            signUpResponseDto.setStatusDto(responseStatusDto.CONFIRM);
            signUpResponseDto.setUserId(user.getId());
            return signUpResponseDto;
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public LogInResponseDto logIn(LogInRequestDto logInRequestDto){

        return null;

    }
}
