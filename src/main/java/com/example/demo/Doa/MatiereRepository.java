package com.example.demo.Doa;

import com.example.demo.entities.Matiere;
import com.example.demo.entities.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {

//    @Query("select m from Matiere m where m.name like :x")
//    public List<Matiere> findByName(@Param("x")String mc);


    @Query("SELECT s FROM Matiere s where  s.name=?1")
    Optional<Matiere> chargeFindMatiereByName(String name);


}