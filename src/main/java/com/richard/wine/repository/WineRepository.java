package com.richard.wine.repository;


import com.richard.wine.model.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Long> {


}
