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
@DiscriminatorValue("bibliothecaire")
public class Bibliothecaire extends User{




    public Bibliothecaire(String username, String password, String firstName, String lastName, String email, String phoneNumber, List<Section> sections) {
        super(username, password, firstName, lastName, email, phoneNumber);
        this.sections = sections;
    }
    @OneToMany(mappedBy = "bibliothecaire")
    private List<Section> sections;

    @Override
    public String toString() {
        return super.toString();
    }
}
