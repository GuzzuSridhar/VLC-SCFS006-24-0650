package com.example.jpapagination.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpapagination.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("select c from Country c where " +
            "lower(c.name) like concat('%', lower(?1) , '%') or " +
            "lower(c.capital) like concat('%', ?1 , '%') or " +
            "cast(c.id as String) like concat('%', ?1 , '%')")
    List<Country> search(String searchString);

}
