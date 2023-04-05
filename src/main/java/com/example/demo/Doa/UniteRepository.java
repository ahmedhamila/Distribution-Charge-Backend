package com.example.demo.Doa;

import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UniteRepository extends JpaRepository<Unite, Long> {

    @Query("SELECT s FROM Unite s where  s.name=?1")
    Optional<Unite> chargeFindUniteByName(String name);




}