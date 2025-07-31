package lldcasestudies.ticketbookingmanagementsystem.services;

import lldcasestudies.ticketbookingmanagementsystem.Configuration.Config;
import lldcasestudies.ticketbookingmanagementsystem.exceptions.IncorrectPassowrdException;
import lldcasestudies.ticketbookingmanagementsystem.exceptions.UserNotFoundException;
import lldcasestudies.ticketbookingmanagementsystem.models.User;
import lldcasestudies.ticketbookingmanagementsystem.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
//    Config config;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.config = config;
    }
    public User SignUp(String name, String email,String Password) throws UserNotFoundException {

        /*
         1. check user exist with the above email;
         2 . if user exist then throw an exception user already exist;
         3. if not , then create the user object with the above details;
         4. save the user in db ;
         5. return the user object
         */
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(!optionalUser.isEmpty()){
            throw new UserNotFoundException("User with email " + email + " not found");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(Password));
        return userRepository.save(user);

    }
    public User LogIn(String email, String password) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with email " + email + " not found");
        }
        User user = optionalUser.get();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(password,user.getPassword())) { // if password matches
            return user;
        }
        throw new IncorrectPassowrdException("Incorrect password");
    }

}
