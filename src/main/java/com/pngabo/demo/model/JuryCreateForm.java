package com.pngabo.demo.model;

import com.pngabo.demo.dataaccess.entities.Concours;
import com.pngabo.demo.dataaccess.entities.Jury;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JuryCreateForm {
    private long id_jury;
    private String expertise;
    private String nom;

    public Jury mapToJury() {
        Jury j = new Jury();
        j.setId_Jury(0);
        j.setExpertise(expertise);
        j.setNom(nom);
        return j;
    }

//    public Jury mapToConcoursEdit(long id) {
//    }
}
