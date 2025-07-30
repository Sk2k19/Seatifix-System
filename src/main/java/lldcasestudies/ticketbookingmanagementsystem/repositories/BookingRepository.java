package lldcasestudies.ticketbookingmanagementsystem.repositories;

import lldcasestudies.ticketbookingmanagementsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Override
    Booking save(Booking booking);

}
