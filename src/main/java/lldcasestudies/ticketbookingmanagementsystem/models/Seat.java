package lldcasestudies.ticketbookingmanagementsystem.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private int row;
    private int col;
    private SeatType seattype;
}
