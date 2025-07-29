package lldcasestudies.ticketbookingmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @OneToMany
    private List<Payment> payment;

    @ManyToMany
    private List<ShowSeat> showSeats;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;


}
/*
       M          1
     Booking ----- user
        1           1

        bookings ----- show
        M                 1
        1                 1  ==> M:1

       Booking ----- Payment
         1               1
         1                1
         show -- X, Y, Z
         Seat -- A1,A2,A3...
         showseat -- XA1
         bookings ----- showSeats
            1              1
 */