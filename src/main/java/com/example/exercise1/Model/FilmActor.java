package com.example.exercise1.Model;

import com.example.exercise1.Model.Actor;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "film_actor")
public class FilmActor {
    @Id
    @ManyToOne()
    @JoinColumn(name = "actorId", nullable = false)
    private Actor actor;

    @Id
    @Column(name = "film_id")
    private Integer filmId;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public FilmActor() {

    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
