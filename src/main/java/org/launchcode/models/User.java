package org.launchcode.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Comparator;

/**
 * Created by adminbackup on 3/27/17.
 */
@Entity
public class User implements Comparable<User> {

    @Id
    @GeneratedValue
    private int Id;

    @NotNull
    @Size(max=15, min=5)
    private String username;
    @Email
    private String email;
    @NotNull
    @Size(min=6)
    private String password;


    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword(){
        if(null!=password && null!=verifyPassword){
            if(!verifyPassword.equals(password)){
                this.verifyPassword = null;
            }
        }
    }

    public int getId() {
        return Id;
    }

    @Override
    public int compareTo(User o) {

        if (this.getId() > (o.getId())){
            return -1;

        }

        return 0;
    }
}
