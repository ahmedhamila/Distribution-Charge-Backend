package com.example.demo.Doa;

import com.example.demo.entities.Diplome;
import com.example.demo.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Long> {


    @Query("SELECT s FROM Diplome s where  s.nom=?1")
    Optional<Diplome> chargeFindDiplomeByName(String name);


}