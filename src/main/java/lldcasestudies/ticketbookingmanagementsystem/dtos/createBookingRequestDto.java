package lldcasestudies.ticketbookingmanagementsystem.dtos;

import lombok.Data;

import java.util.List;

@Data
public class createBookingRequestDto {
    private Long userId;
    private List<Long> seatShowIds; // <showId, seatId>

}
