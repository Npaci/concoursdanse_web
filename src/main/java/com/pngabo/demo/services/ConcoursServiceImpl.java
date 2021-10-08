package com.pngabo.demo.services;

import com.pngabo.demo.dataaccess.entities.Concours;
import com.pngabo.demo.dataaccess.entities.Jury;
import com.pngabo.demo.dataaccess.repositories.ConcoursRepository;
import com.pngabo.demo.dataaccess.repositories.JuryRepository;
import com.pngabo.demo.exceptions.AlreadyExistException;
import com.pngabo.demo.exceptions.ElementNotFoundException;
import com.pngabo.demo.model.ConcoursCreateForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcoursServiceImpl implements CrudService<Concours, Long> {
    private final ConcoursRepository repository;
    private final JuryRepository repositoryJ;

    public ConcoursServiceImpl(ConcoursRepository repository, JuryRepository repositoryJ) {
        this.repository = repository;
        this.repositoryJ = repositoryJ;
    }


    public void insert(ConcoursCreateForm cf ) throws AlreadyExistException {
        Concours c = cf.mapToConcours();

        c.setJuries(cf.getJuries());

        if (repository.existsById(c.getId_Concour()))
            throw new AlreadyExistException("Ce concours existe déjà");

        repository.save(c);
    }

    @Override
    public Concours getByID(Long aLong) throws ElementNotFoundException {
        return repository.findById(aLong).get();
    }

    @Override
    public List<Concours> getAll() {
        return repository.findAll();
    }

    @Override
    public void insert(Concours c) throws AlreadyExistException {
        if (repository.existsById(c.getId_Concour()))
            throw new AlreadyExistException("Ce concours existe déjà");

        repository.save(c);
    }

    @Override
    public void update(Concours e) throws ElementNotFoundException {
        if (!repository.existsById(e.getId_Concour()))
            throw new ElementNotFoundException();

        repository.save(e);
    }

    @Override
    public void delete(Long id) throws ElementNotFoundException {
        if (!repository.existsById(id))
            throw new ElementNotFoundException();

        repository.deleteById(id);
    }
}