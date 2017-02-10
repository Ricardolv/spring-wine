package com.richard.wine.repository;


import com.richard.wine.model.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Long> {

    List<Wine> findByNameContainingIgnoreCase(String name);

}
