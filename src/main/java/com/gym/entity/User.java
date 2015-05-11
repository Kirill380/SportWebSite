package com.gym.entity;

/**
 * Created by Nout on 11/05/2015.
 */
public class User {
    private int id;
    private String email;
    private String pass;
    private String firstName;
    private String lastName;
    private String role;
    private int coach_id;

    public User(int id, String email, String pass, String firstName, String lastName, String role, int coach_id) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.coach_id = coach_id;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }
}
