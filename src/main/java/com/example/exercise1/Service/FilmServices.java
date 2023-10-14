package com.example.exercise1.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exercise1.Model.Film;
import com.example.exercise1.Repository.FilmRepository;

@Service
public class FilmServices {
    private final FilmRepository filmRepository;

    @Autowired
    FilmServices(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    public Film createNewFilm(Film film) {
        film.setLastUpdate(new Timestamp((new Date()).getTime()));
        return filmRepository.save(film);
    }
}
