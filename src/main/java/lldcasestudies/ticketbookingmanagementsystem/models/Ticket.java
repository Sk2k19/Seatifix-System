package lldcasestudies.ticketbookingmanagementsystem.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private User user;
    private Show show;
    private Payment payment;
    private List<ShowSeat> showSeats;
    private int amount;
    private PaymentStatus paymentStatus;
    private String ticketId;
    private String qrCode;
    private int seatCount;

}
