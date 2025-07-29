package lldcasestudies.ticketbookingmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.EnumType.ORDINAL;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private int X;// row
    private int Y;// column

   @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
