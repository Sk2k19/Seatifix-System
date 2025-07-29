package lldcasestudies.ticketbookingmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Screen extends BaseModel {
    private String name ;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> features;


    @OneToMany
    private List<Seat> seats;

}
/*
       SCREEN  -------    SHOW
          1                  1
          1                  M

          Screen -------- seat
          1                 M
          1                  1
 */