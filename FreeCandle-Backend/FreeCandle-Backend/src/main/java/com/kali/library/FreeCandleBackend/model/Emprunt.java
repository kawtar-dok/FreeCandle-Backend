package com.kali.library.FreeCandleBackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Emprut")
public class Emprunt  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", columnDefindateition = "serial")
    @Column(name = "id")
    private Long id;

    //Definit l'etat est ce aue c'est reserver ou retourner
    @Column(name ="status" )
    private String status;

    @Column(name ="price" )
    private Long price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "emprunter_at")
    private LocalDateTime empruntAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "returner_at")
    private LocalDateTime retourAt;

    @PrePersist
    public void onCreate() {
        this.empruntAt = LocalDateTime.now();
    }
    @PreUpdate
    public void onUpdate() {
        this.retourAt = LocalDateTime.now();
    }

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    private Adherent adherent;

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", empruntAt=" + empruntAt +
                ", retourAt=" + retourAt +
                ", book=" + book +
                ", adherent=" + adherent +
                '}';
    }
}
