package com.webproject.derash;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
@Table(name = "user")
public class LoginPage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 8, max = 64, 
    		message = "password must be atleast 8 character long and atmost 64 character")
    @Column(nullable = false, length = 64)
    @NotBlank(message = "password mustnot be empty")
    private String password;
    
    public int getId() {
        return this.id;
    }
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
