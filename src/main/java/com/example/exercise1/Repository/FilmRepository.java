package com.example.exercise1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exercise1.Model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

}
