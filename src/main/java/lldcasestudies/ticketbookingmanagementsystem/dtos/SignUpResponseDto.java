package lldcasestudies.ticketbookingmanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class SignUpResponseDto {
    private Long userId;
    private responseStatusDto statusDto;
    private SignUpRequestDto requestDto;
}
