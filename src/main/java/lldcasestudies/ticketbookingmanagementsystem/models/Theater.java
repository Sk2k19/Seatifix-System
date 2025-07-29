package lldcasestudies.ticketbookingmanagementsystem.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Theater extends BaseModel {
    private String name;
    private String address;
    private City city;
    private List<Screen> screens;

}
