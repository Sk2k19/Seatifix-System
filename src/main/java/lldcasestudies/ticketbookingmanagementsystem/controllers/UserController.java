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

    public SignUpResponseDto SignUp(SignUpRequestDto signUpRequestDto) throws UserNotFoundException {
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try {
            User user = userService.SignUp(signUpRequestDto.getName(),signUpRequestDto.getEmail(),signUpRequestDto.getPassword());

            signUpResponseDto.setStatusDto(responseStatusDto.CONFIRM);
            signUpResponseDto.setUserId(user.getId());

        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("There is already  User with email " + signUpRequestDto.getEmail() + " exists. Please try with different email or try to login");
        }
        return signUpResponseDto;
    }
    public LogInResponseDto LogIn(LogInRequestDto logInRequestDto) throws UserNotFoundException {

        LogInResponseDto logInResponseDto = new LogInResponseDto();

        try {
            User user = userService.LogIn(logInRequestDto.getEmail(),logInRequestDto.getPassword());
            logInResponseDto.setStatusDto(responseStatusDto.CONFIRM);

        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }

        return logInResponseDto;

    }
}
