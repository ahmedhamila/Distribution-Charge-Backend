package com.example.demo.Doa;

import com.example.demo.entities.Matiere;
import com.example.demo.entities.Regime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegimeRepository extends JpaRepository<Regime, Long> {


    @Query("SELECT s FROM Regime s where  s.name=?1")
    Optional<Regime> chargeFindRegimeByName(String name);


}