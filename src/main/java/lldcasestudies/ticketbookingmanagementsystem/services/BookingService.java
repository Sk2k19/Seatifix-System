package lldcasestudies.ticketbookingmanagementsystem.services;

import lldcasestudies.ticketbookingmanagementsystem.dtos.createBookingResponseDto;
import lldcasestudies.ticketbookingmanagementsystem.exceptions.ShowSeatNotAvailableException;
import lldcasestudies.ticketbookingmanagementsystem.exceptions.UserNotFoundException;
import lldcasestudies.ticketbookingmanagementsystem.models.*;
import lldcasestudies.ticketbookingmanagementsystem.repositories.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingService {
    UserRepository userRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;
    BookingRepository bookingRepository;
    ShowSeatTypeRepository showSeatTypeRepository;
    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          BookingRepository bookingRepository,
                          ShowSeatTypeRepository showSeatTypeRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public Booking createBooking(Long userId, List<Long> seatShowIds,Long showId) throws UserNotFoundException {

        /*
         1. get the user details by userId .
         2. get the show details by showId .
         3. get the showSeat details by seatShowId .
         ------ Acquire the lock on the showSeat -----
         4. check the showSeat status .
         5 if all the showSeats status is available then update the showSeat status to blocked
         6. if any showSeat status is booked/unavailable then throw exception .
         --------release the lock on the showSeat ------
         7. create the booking object with status pending .
         8. return the booking object.
         9. if payment done mark the booking status as confirmed.
         10. else , user get back to the page or time out or cancel the booking then mark showseat status available .

         */
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with id " + userId + " not found");
        }
        User user = optionalUser.get();
        Optional<Show> optionalShow = showRepository.findById(showId);
         if(optionalShow.isEmpty()){
            throw new UserNotFoundException("Show with id " + showId + " not found");
        }
        Show show = optionalShow.get();
        List<ShowSeat> showSeats = showSeatRepository.findAllById(seatShowIds);

        for(ShowSeat showSeat : showSeats){// check the showSeat status if not available then throw exception
            if(showSeat.getShowSeatStatus() != ShowSeatStatus.AVAILABLE){
                throw new ShowSeatNotAvailableException("ShowSeat with id " + showSeat.getId() + " is not available");
            }
        }
        for(ShowSeat showSeat : showSeats){// update the showSeat status to blocked
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);// saving the changes in db also.
        }
        Booking booking  = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setShowSeats(showSeats);
        booking.setPayment(new ArrayList<>());

       booking.setAmount(new PriceCalculator(showSeatTypeRepository).calculatePrice(showSeats,show));

        booking.setPaymentStatus(PaymentStatus.PENDING);
        return bookingRepository.save(booking);
    }
}
