package lldcasestudies.ticketbookingmanagementsystem;

import lldcasestudies.ticketbookingmanagementsystem.controllers.UserController;
import lldcasestudies.ticketbookingmanagementsystem.dtos.SignUpRequestDto;
import lldcasestudies.ticketbookingmanagementsystem.dtos.SignUpResponseDto;
import lldcasestudies.ticketbookingmanagementsystem.dtos.responseStatusDto;
import lldcasestudies.ticketbookingmanagementsystem.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TicketBookingManagementSystemApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void signUpUseCase(){

        SignUpRequestDto requestDto = new SignUpRequestDto();
        requestDto.setName("Shivam");
        requestDto.setEmail("shivam@gmail.com");
        requestDto.setPassword("shivam@2002");
        UserController userController = new UserController(new UserService());
        SignUpResponseDto responseDto = userController.SignUp(requestDto);
        if(responseDto.getStatusDto() == responseStatusDto.CONFIRM) {
            System.out.println("User created successfully");
        }else{
            throw new RuntimeException("User creation failed");
        }
    }
}
