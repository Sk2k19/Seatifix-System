package lldcasestudies.ticketbookingmanagementsystem.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Screen extends BaseModel {
    private int screenId;
    private List<Features> features;
    private List<Show> shows;
    private List<Seat> seats;

}
