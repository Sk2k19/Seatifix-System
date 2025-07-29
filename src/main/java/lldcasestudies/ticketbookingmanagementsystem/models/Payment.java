package lldcasestudies.ticketbookingmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private String referenceNumber ;
    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private ModeOfPayment modeOfPayment;

    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;


}
/*
     user ------- payment
     1              M
     1               1


     Payment ------ showSeat
        1                1
        1                M
 */