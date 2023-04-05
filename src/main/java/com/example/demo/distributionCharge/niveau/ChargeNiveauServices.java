package com.example.demo.distributionCharge.niveau;

import com.example.demo.Doa.DiplomeRepository;
import com.example.demo.Doa.NiveauRepository;
import com.example.demo.entities.Diplome;
import com.example.demo.entities.Niveau;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChargeNiveauServices {
    private final NiveauRepository niveauRepository;
    private final DiplomeRepository diplomeRepository;


    public Niveau getNiveau(Long niveauId) {
        Niveau niveau=niveauRepository.findById(niveauId).orElseThrow(()->new IllegalStateException(("Niveau does not exist")));
        return niveau;
    }

    public List<Niveau> getNiveaux() {
        return niveauRepository.findAll();
    }

    public void addNiveau(Niveau niveau,Long diplomeId) {
        Optional<Niveau> niveauOptional= niveauRepository.chargeFindNiveauByName(niveau.getName());
        if(niveauOptional.isPresent()){
            throw new IllegalStateException("Niveau Exists");
        }
        Diplome diplome=diplomeRepository.findById(diplomeId).orElseThrow(()->new IllegalStateException(("Diplome does not exist")));
        niveau.setDiplome(diplome);
        niveauRepository.save(niveau);
    }


    public void deleteNiveau(Long niveauId) {
        boolean exists=niveauRepository.existsById(niveauId);
        if(!exists){
            throw new IllegalStateException("Niveau with id"+niveauId+" does not exists");
        }
        niveauRepository.deleteById(niveauId);

    }

}
