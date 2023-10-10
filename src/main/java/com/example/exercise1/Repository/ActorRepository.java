package com.example.exercise1.Repository;

import com.example.exercise1.Model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    Actor findByActorId(Integer id);
}
