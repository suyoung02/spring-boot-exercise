package com.example.exercise1.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.exercise1.Exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Film findById(Integer theId){
        Optional<Film> res=filmRepository.findById(theId);
        Film theFilm=null;
        if(res.isPresent()){
            theFilm=res.get();
        }else{
            throw new AppException(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "Film is Not Found");
        }
        return theFilm;
    }
    public Film save(Film theFilm){
        theFilm.setLastUpdate(new Timestamp((new Date()).getTime()));
        return filmRepository.save(theFilm);
    }
    public void deleteById(Integer theId){
        filmRepository.deleteById(theId);
    }
}
