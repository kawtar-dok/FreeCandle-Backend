package com.kali.library.FreeCandleBackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@DiscriminatorValue("adherent")
public class Adherent extends User{

    public Adherent(String username, String password, String firstName, String lastName, String email, String phoneNumber) {
        super(username, password, firstName, lastName, email, phoneNumber);
        this.empruntBook = empruntBook;
    }

    @OneToMany(mappedBy = "adherent")
    private List<Emprunt> empruntBook;

    @Override
    public String toString() {
        return super.toString();
    }
}
