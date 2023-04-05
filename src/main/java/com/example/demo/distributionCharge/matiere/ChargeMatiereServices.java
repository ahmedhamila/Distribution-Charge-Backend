package com.example.demo.distributionCharge.matiere;

import com.example.demo.Doa.MatiereRepository;
import com.example.demo.Doa.RegimeRepository;
import com.example.demo.entities.Matiere;

import com.example.demo.entities.Regime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChargeMatiereServices {
    private final MatiereRepository matiereRepository;
    private final RegimeRepository regimeRepository;


    public Matiere getMatiere(Long userId) {
        Matiere matiere=matiereRepository.findById(userId).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));
        return matiere;
    }

    public List<Matiere> getMatieres() {
        return matiereRepository.findAll();
    }

    public void addMatiere(Matiere matiere,Long RegimeId) {
        Optional<Matiere> matiereOptional= matiereRepository.chargeFindMatiereByName(matiere.getName());
        if(matiereOptional.isPresent()){
            throw new IllegalStateException("Matiere Exists");
        }
        Regime regime2= regimeRepository.findById(RegimeId).orElseThrow(()->new IllegalStateException(("Regime does not exist")));
        System.out.println(regime2.getName());
        matiere.setRegime(regime2);
        matiereRepository.save(matiere);
    }


    public void deleteMatiere(Long matiereId) {
        boolean exists=matiereRepository.existsById(matiereId);
        if(!exists){
            throw new IllegalStateException("Matiere with id"+matiereId+" does not exists");
        }
        matiereRepository.deleteById(matiereId);

    }

}
