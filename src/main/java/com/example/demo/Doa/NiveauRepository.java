package com.example.demo.Doa;

import com.example.demo.entities.Matiere;
import com.example.demo.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {


    @Query("SELECT s FROM Niveau s where  s.name=?1")
    Optional<Niveau> chargeFindNiveauByName(String name);


}