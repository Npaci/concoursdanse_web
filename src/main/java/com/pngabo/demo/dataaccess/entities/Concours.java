package com.pngabo.demo.dataaccess.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Concours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Concour;
    @Column(nullable = false)
    private String theme;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Date date;

    @PrePersist
    public void prePersist() {
        this.date = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.date = new Date();
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "juge_par",
            joinColumns = @JoinColumn(name = "id_Concour"),
            inverseJoinColumns = @JoinColumn(name = "id_Jury")
    )
    private List<Jury> juries;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Participe",
            joinColumns = @JoinColumn(name = "id_Concour"),
            inverseJoinColumns = @JoinColumn(name = "id_Candidat")
    )
    private List<Candidat> candidats;

}
