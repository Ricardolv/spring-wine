package com.richard.wine.service;

import com.richard.wine.model.Wine;
import com.richard.wine.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineService {

    @Autowired
    private WineRepository repository;

    public Wine save(Wine wine) {
        return repository.save(wine);
    }
    
}
