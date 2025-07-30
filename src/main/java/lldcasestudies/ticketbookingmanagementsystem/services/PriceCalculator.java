package lldcasestudies.ticketbookingmanagementsystem.services;


import lldcasestudies.ticketbookingmanagementsystem.models.Show;
import lldcasestudies.ticketbookingmanagementsystem.models.ShowSeat;
import lldcasestudies.ticketbookingmanagementsystem.models.ShowSeatType;
import lldcasestudies.ticketbookingmanagementsystem.repositories.ShowSeatRepository;
import lldcasestudies.ticketbookingmanagementsystem.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculator {
    ShowSeatTypeRepository showSeatTypeRepository;
    PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(List<ShowSeat> showSeats, Show show) {
        int amount =0;
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        for(ShowSeat showSeat : showSeats) {
            for(ShowSeatType showSeatType : showSeatTypes) {
                if(showSeatType.getSeatType().equals(showSeat.getSeat().getSeatType())) {
                    amount += showSeatType.getPrice();
                }
            }
        }

        return amount;
    }

}
