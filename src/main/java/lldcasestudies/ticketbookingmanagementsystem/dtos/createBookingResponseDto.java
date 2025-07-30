package lldcasestudies.ticketbookingmanagementsystem.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class createBookingResponseDto {
    private Long bookingId;
    private responseStatusDto statusDto;
}
