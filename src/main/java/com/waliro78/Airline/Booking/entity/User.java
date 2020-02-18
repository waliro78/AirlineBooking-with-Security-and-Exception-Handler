package com.waliro78.Airline.Booking.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 2/12/2020.
 */
@Entity
@Table (name="UsersTableForRole")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    //@NotBlank(message = "This column can not be null")
    private String username;

    //@NotBlank(message = "This column can not be null")
    private String password;

   // @NotBlank(message = "This column can not be null")
    private Integer active;

   // @NotBlank(message = "This column can not be null")
    private String role =" ";

    public User( String username, String password,String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public List<String> getRoleList(){
        if(role.length()>0){
            return Arrays.asList(this.role.split(","));
        }
        else{
            return new ArrayList<>();
        }
    }
}
