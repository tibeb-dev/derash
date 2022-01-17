package com.webproject.derash;
import javax.persistence.*;


@Entity
@Table(name = "user")
public class LoginPage {
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String email;
     
    @Column(nullable = false, length = 64)
    private String password;
     
//    @Column(name = "user_name", nullable = false, length = 20)
//    private String username;
     
//    @Column(name = "last_name", nullable = false, length = 20)
//    private String lastName;

    
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
//
//    public String getUserName() {
//        return this.username;
//    }
//
//    public void setUserName(String username) {
//        this.username = username;
//    }

//    public String getLastName() {
//        return this.lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
}
