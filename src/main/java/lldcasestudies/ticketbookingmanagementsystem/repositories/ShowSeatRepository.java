package lldcasestudies.ticketbookingmanagementsystem.repositories;

import lldcasestudies.ticketbookingmanagementsystem.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Override
    List<ShowSeat> findAllById(Iterable<Long> showSeatIds);
    // we are  not using optional here because list will never show null pointer exception;
    ShowSeat save(ShowSeat showSeat);
    // save method will return showseat. save method works -> update+insert => upsert
}
