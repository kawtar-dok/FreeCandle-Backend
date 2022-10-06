package com.kali.library.FreeCandleBackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@NoArgsConstructor
@Setter
@Getter
@Entity
@DiscriminatorValue("admin")
public class Admin extends User{

    public Admin(String username, String password, String firstName, String lastName, String email, String phoneNumber) {
        super(username, password, firstName, lastName, email, phoneNumber);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
