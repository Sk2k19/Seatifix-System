package lldcasestudies.ticketbookingmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Theater extends BaseModel {
    private String name;
    private String address;

    @ManyToOne
    private City city;

    @OneToMany
    private List<Screen> screens;

}
/*
       THEATER   ------    City
          M                   1
          1                   1

          theater  ------ screen
             1                1
             1                M
 */