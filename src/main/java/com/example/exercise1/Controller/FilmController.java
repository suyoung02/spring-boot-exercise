package com.example.exercise1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exercise1.Model.Film;
import com.example.exercise1.Service.FilmServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/films")
public class FilmController {
    private final FilmServices filmServices;

    @Autowired
    FilmController(FilmServices filmServices) {
        this.filmServices = filmServices;
    }

    @PostMapping("/get-all")
    public ResponseEntity<List<Film>> getAll() {
        return new ResponseEntity<>(filmServices.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create-new")
    public ResponseEntity<Film> createNewFilm(@Valid @RequestBody Film newFilm) {
        return new ResponseEntity<>(filmServices.createNewFilm(newFilm), HttpStatus.OK);
    }
}
