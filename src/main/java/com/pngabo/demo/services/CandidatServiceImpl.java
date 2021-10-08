package com.pngabo.demo.services;

import com.pngabo.demo.dataaccess.entities.Candidat;
import com.pngabo.demo.dataaccess.repositories.CandidatRepository;
import com.pngabo.demo.exceptions.AlreadyExistException;
import com.pngabo.demo.exceptions.ElementNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatServiceImpl implements CrudService<Candidat, Long> {
    private CandidatRepository repository;

    public CandidatServiceImpl(CandidatRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Candidat getByID(Long id) throws ElementNotFoundException {
        if (!repository.existsById(id))
           // throw new NotFoundException("Aucun candidat possède cet ID");
            new ElementNotFoundException();

        return repository.getById(id);
    }

    @Override
    @Transactional
    public List<Candidat> getAll() {
        return repository.findAll();
    }

    @Override
    public void insert(Candidat c) throws AlreadyExistException {
        if (repository.existsById(c.getId_Candidat()))
            throw new AlreadyExistException("Ce candidat existe déjà");

        repository.save(c);
    }

    @Override
    public void update(Candidat c) throws ElementNotFoundException {
        if (!repository.existsById(c.getId_Candidat()))
            throw new ElementNotFoundException();

        repository.save(c);
    }

    @Override
    public void delete(Long id) throws ElementNotFoundException {
        if (!repository.existsById(id))
            throw new ElementNotFoundException();

        repository.deleteById(id);
    }
}