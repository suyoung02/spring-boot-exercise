package com.example.exercise1.Controller;

import java.security.PublicKey;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.example.exercise1.Exception.AppException;
import com.example.exercise1.Model.Actor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Operation(summary = "Get all film", description = "Get all film in db")
    @GetMapping()
    public ResponseEntity<List<Film>> getAll() {
        return new ResponseEntity<>(filmServices.getAll(), HttpStatus.OK);
    }
    @Operation(summary = "Add one film", description = "Add one film to db")
    @PostMapping()
    public ResponseEntity<Film> createNewFilm(@Valid @RequestBody Film newFilm) {
        return new ResponseEntity<>(filmServices.createNewFilm(newFilm), HttpStatus.OK);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Film not found")})
    @Operation(summary = "Detail film", description = "Detail of film ")
    @GetMapping("/{id}")
    public ResponseEntity<Film> detailFilm(@Parameter( name =  "id",
            description  = "Id of film",
            example = "1",
            required = true) @PathVariable (value = "id") String id ) {
        int filmId;
        try {
            filmId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new AppException(400, HttpStatus.BAD_REQUEST, "id should be integer");
        }

        Film theFilm =filmServices.findById(filmId);
        return ResponseEntity.ok(theFilm);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable (value = "id") String id,@Valid @RequestBody Film theFilm){
        int filmId;
        try {
            filmId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new AppException(400, HttpStatus.BAD_REQUEST, "id should be integer");
        }
        Film dbFilm =filmServices.findById(filmId);
        if(dbFilm!=null){
            theFilm.setFilmId(filmId);
            Film res=filmServices.save(theFilm);
        }


        return ResponseEntity.ok(theFilm);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable (value = "id") String id) {
        int filmId;
        try {
            filmId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new AppException(400, HttpStatus.BAD_REQUEST, "id should be integer");
        }

        Film theFilm =filmServices.findById(filmId);
        if(theFilm==null){
            throw new RuntimeException("Not Found");
        }
        filmServices.deleteById(filmId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
