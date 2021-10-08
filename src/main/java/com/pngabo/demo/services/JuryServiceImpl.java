package com.pngabo.demo.services;

import com.pngabo.demo.dataaccess.entities.Jury;
import com.pngabo.demo.dataaccess.repositories.JuryRepository;
import com.pngabo.demo.exceptions.AlreadyExistException;
import com.pngabo.demo.exceptions.ElementNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuryServiceImpl implements CrudService<Jury, Long> {
    private JuryRepository repository;

    public JuryServiceImpl(JuryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Jury getByID(Long aLong) throws ElementNotFoundException {
        return repository.getById(aLong);
    }

    @Override
    public List<Jury> getAll() {
        return repository.findAll();
    }

    @Override
    public void insert(Jury e) throws AlreadyExistException {
        if (repository.existsById(e.getId_Jury()))
            throw new AlreadyExistException("Ce jury existe déjà");

        repository.save(e);
    }

    @Override
    public void update(Jury e) throws ElementNotFoundException {
        if (!repository.existsById(e.getId_Jury()))
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
