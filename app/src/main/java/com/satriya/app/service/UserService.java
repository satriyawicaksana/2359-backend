package com.satriya.app.service;

import com.satriya.app.entity.User;
import com.satriya.app.repository.UserRepository;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void userSignUp(User user) {
        user.setRole("USER");
        BasicPasswordEncryptor textEncryptor = new BasicPasswordEncryptor();
        String enryptText = textEncryptor.encryptPassword(user.getPassword());
        user.setPassword(enryptText);
        this.userRepository.save(user);
    }

    public void adminSignup(User user) {
        user.setRole("ADMIN");
        BasicPasswordEncryptor textEncryptor = new BasicPasswordEncryptor();
        String enryptText = textEncryptor.encryptPassword(user.getPassword());
        user.setPassword(enryptText);
        this.userRepository.save(user);
    }

    public void adminDelete(String userId) {
        this.userRepository.deleteById(userId);
    }

    public boolean uniqueUsername(String username) {
        Optional<User> unique = this.userRepository.findUserByUsername(username);
        if(unique.isPresent())
            return true;
        else
            return false;
    }

    public boolean userSignIn(User user) {
        Optional<User> userAvailable = this.userRepository.findUserByUsername(user.getUsername());
        System.out.println(userAvailable);
        if(userAvailable.isPresent()){
            String passTemp = userAvailable.get().getPassword();
            BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
            if(passwordEncryptor.checkPassword(user.getPassword(), passTemp )){
                return true;
            }
            else return false;
        }
        else {
            // false assume that user not found and incorrect password
            return false;
        }
    }
}
