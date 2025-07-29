package lldcasestudies.ticketbookingmanagementsystem.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private User user;
    private String paymentId;
    private ModeOfPayment modeOfPayment;
    private PaymentProvider paymentProvider;
    private double amount;
    private List<ShowSeat> showSeats;

}
