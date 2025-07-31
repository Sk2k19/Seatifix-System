package lldcasestudies.ticketbookingmanagementsystem;

import lldcasestudies.ticketbookingmanagementsystem.controllers.UserController;
import lldcasestudies.ticketbookingmanagementsystem.dtos.*;
import lldcasestudies.ticketbookingmanagementsystem.exceptions.UserNotFoundException;
import lldcasestudies.ticketbookingmanagementsystem.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TicketBookingManagementSystemApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    UserController userController;
    @Test
    public void testSignUp() throws UserNotFoundException {
        SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
        signUpRequestDto.setName("Ishan Kanaujiya");
        signUpRequestDto.setEmail("Ishan@123");
        signUpRequestDto.setPassword("Ishan123");
        SignUpResponseDto signUpResponseDto = userController.SignUp(signUpRequestDto);
        if(signUpResponseDto.getStatusDto().equals(responseStatusDto.CONFIRM)){
             System.out.println("SignUp successful");
        }else{
            System.out.println("SignUp failed");
        }
    }
    @Test
    public void testLogIn() throws UserNotFoundException {
        LogInRequestDto logInRequestDto = new LogInRequestDto();
        logInRequestDto.setEmail("jithin@123");
        logInRequestDto.setPassword("jatin123");
        LogInResponseDto logInResponseDto = userController.LogIn(logInRequestDto);
        if(logInResponseDto.getStatusDto().equals(responseStatusDto.CONFIRM)){
            System.out.println("LogIn successful");
        }else{
            System.out.println("LogIn failed");
        }
    }
}
