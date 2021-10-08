package com.pngabo.demo.model;

import com.pngabo.demo.dataaccess.entities.Candidat;
import com.pngabo.demo.dataaccess.entities.Concours;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidatCreateForm {
    private long id_candidat;
    private String nom;
    private int age;

    public Candidat mapToCandicat() {
        Candidat c = new Candidat();
        c.setId_Candidat(0L);
        c.setNom(nom);
        c.setAge(age);
        return c;
    }

//    public Candidat mapToConcoursEdit(long id) {
//    }
}
