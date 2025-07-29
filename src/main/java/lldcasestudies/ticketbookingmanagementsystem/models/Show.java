package lldcasestudies.ticketbookingmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel {
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Movie movie;


    @ManyToOne
    private Screen screen;


    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> features;

}
/*

        Show  ------  Movie
         M               1
         1               1
        Show --------- Theater
          M                1
          1                1

          show --------- screen
            M               1
            1                1
 */