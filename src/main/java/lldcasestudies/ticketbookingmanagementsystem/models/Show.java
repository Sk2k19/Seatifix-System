package lldcasestudies.ticketbookingmanagementsystem.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel {
    private Date startTime;
    private Date endTime;
    private Movie movie;
    private Theater theater;
    private Screen screen;
    private List<Features> features;


}
