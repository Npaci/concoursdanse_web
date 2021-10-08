package com.pngabo.demo.model;

import com.pngabo.demo.dataaccess.entities.Candidat;
import com.pngabo.demo.dataaccess.entities.Concours;
import com.pngabo.demo.dataaccess.entities.Jury;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ConcoursCreateForm {
    private long id_Concour;
    private String theme;
    private String description;
    private List<Jury> juries;
    private List<Candidat> listC;

    public Concours mapToConcours() {
        Concours c = new Concours();
        c.setId_Concour(0L);
        c.setTheme(theme);
        c.setDescription(description);
        return c;
    }

    public Concours mapToConcoursEdit(long id) {
        Concours c = new Concours();
        c.setId_Concour(id);
        c.setTheme(theme);
        c.setDescription(description);
        return c;
    }
}
