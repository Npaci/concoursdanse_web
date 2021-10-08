package com.pngabo.demo.controller;

import com.pngabo.demo.dataaccess.entities.Candidat;
import com.pngabo.demo.dataaccess.entities.Concours;
import com.pngabo.demo.dataaccess.entities.Jury;
import com.pngabo.demo.exceptions.AlreadyExistException;
import com.pngabo.demo.exceptions.ElementNotFoundException;
import com.pngabo.demo.model.CandidatCreateForm;
import com.pngabo.demo.model.ConcoursCreateForm;
import com.pngabo.demo.model.JuryCreateForm;
import com.pngabo.demo.services.CandidatServiceImpl;
import com.pngabo.demo.services.ConcoursServiceImpl;
import com.pngabo.demo.services.JuryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = {"/concours"})
@Controller
public class ConcoursController {
    ConcoursServiceImpl service;
    JuryServiceImpl serviceJ;
    CandidatServiceImpl serviceC;

    public ConcoursController(ConcoursServiceImpl service, JuryServiceImpl serviceJ, CandidatServiceImpl serviceC) {
        this.service = service;
        this.serviceJ = serviceJ;
        this.serviceC = serviceC;
    }

    @GetMapping(path = {"", "/list"}, name = "concours_list")
    public String listAction(Model view) {
        view.addAttribute("concours", service.getAll());
        return "concours/list";
    }

    @GetMapping(path = {"/register", "/create"}, name = "concours_create")
    //Acces au formulaire de creation
    public String createAction(Model view) {
        view.addAttribute("juries", serviceJ.getAll());
        view.addAttribute("candidats", serviceC.getAll());

        return "concours/create";
    }

    @PostMapping(path = {"/register", "/create"}, name = "user_create_post")
    //Traitement du formulaire
    public String createAction(Model view, ConcoursCreateForm form) {

        try {
            service.insert(form);
        } catch (AlreadyExistException e) {
            e.printStackTrace();
        }


//        Concours c = form.mapToConcours();
//        Jury j = Jury.builder()
//                .id_Jury(1)
//                .nom("Jack")
//                .expertise("Pro")
//                .build();
//        Candidat candidat = Candidat.builder()
//                .id_Candidat(1)
//                .age(15)
//                .nom("Pierre").build();
//
//        try {
////            serviceC.insert(candidat);
////            serviceJ.insert(j);
//            c.setCandidats(List.of(candidat));
//            c.setJuries(List.of(j));
//            service.insert(c);
//        } catch (AlreadyExistException e) {
//            e.printStackTrace();
//        }

        return "redirect:/concours/list";
    }

    @GetMapping(path = {"/delete/{id}"})
    //Acces à la suppression
    public String deleteAction(@PathVariable("id") long id) {
        try {
            System.out.println("on va supprimer l'element: "+id);
            service.delete(id);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

        return "redirect:/concours/list";
    }

    @PostMapping(path = {"/edit/{id}"})
    //Traitement du formulaire d'édition
    public String editAction(Model view, @PathVariable("id") long id, ConcoursCreateForm form) {
        Concours updated = form.mapToConcoursEdit(id);
        try {
            service.update(updated);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/concours/list";
    }


}
