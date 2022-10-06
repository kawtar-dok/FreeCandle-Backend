package com.kali.library.FreeCandleBackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "sections")
public class Section {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "theme", nullable = false)
    private String theme;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "description", nullable = false)
    private String description;

    List<Section> sections;

    @OneToMany(mappedBy = "section")
    private List<Book> books;

    @ManyToOne
    private Bibliothecaire bibliothecaire;

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", theme='" + theme + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", sections=" + sections +
                ", books=" + books +
                ", bibliothecaire=" + bibliothecaire +
                '}';
    }
}
