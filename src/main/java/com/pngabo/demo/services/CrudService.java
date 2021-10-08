package com.pngabo.demo.services;

import com.pngabo.demo.exceptions.AlreadyExistException;
import com.pngabo.demo.exceptions.ElementNotFoundException;

import java.util.List;

public interface CrudService<ENTITY, ID>{
    ENTITY getByID(ID id) throws ElementNotFoundException;
    List<ENTITY> getAll();
    void insert(ENTITY e) throws AlreadyExistException;
    void update(ENTITY e) throws ElementNotFoundException;
    void delete(ID id) throws ElementNotFoundException;
}
