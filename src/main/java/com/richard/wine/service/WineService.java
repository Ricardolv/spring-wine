package com.richard.wine.service;

import com.richard.wine.model.Wine;
import com.richard.wine.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineService {

    @Autowired
    private WineRepository repository;

    public Wine save(Wine wine) {
        return repository.save(wine);
    }

    public List<Wine> findAll() {
        return repository.findAll();
    }

    public List<Wine> findByNameContainingIgnoreCase(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Wine findOne(Long code) {
        return repository.findOne(code);
    }

    public void delete(Long code) {
        repository.delete(code);
    }
}
