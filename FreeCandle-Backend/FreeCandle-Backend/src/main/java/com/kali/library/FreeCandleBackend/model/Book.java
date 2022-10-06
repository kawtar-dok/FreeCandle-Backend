package com.kali.library.FreeCandleBackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "author", nullable = true)
    private String author;

    @Column(name = "description", nullable = true)
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_publication", nullable = true)
    private LocalDate datePublication;

    @Column(name = "edition", nullable = true)
    private String edition;


   @ManyToOne
    private Section section;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                ", edition='" + edition + '\'' +
                ", section=" + section +
                '}';
    }
}
