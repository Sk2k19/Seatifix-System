package lldcasestudies.ticketbookingmanagementsystem.services;

import lldcasestudies.ticketbookingmanagementsystem.Configuration.Config;
import lldcasestudies.ticketbookingmanagementsystem.exceptions.UserNotFoundException;
import lldcasestudies.ticketbookingmanagementsystem.models.User;
import lldcasestudies.ticketbookingmanagementsystem.repositories.UserRepository;
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
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with email " + email + " not found");
        }
        User user = optionalUser.get();
        user.setName(name);
        user.setEmail(email);
//        Config config = new Config();
////        BcryptPasswordEncoder passwordEncoder = config.getBcryptPasswordEncoder();
//        BcryptPasswordEncoder passwordEncoder = new BcryptPasswordEncoder();
//        user.setPassword(passwordEncoder.encode(Password));

        return userRepository.save(user);

    }
}
