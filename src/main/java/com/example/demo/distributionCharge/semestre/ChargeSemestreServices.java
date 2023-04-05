package com.example.demo.distributionCharge.semestre;

import com.example.demo.Doa.NiveauRepository;
import com.example.demo.Doa.SectionRepository;
import com.example.demo.Doa.SemestreRepository;
import com.example.demo.Doa.UniteRepository;
import com.example.demo.entities.*;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChargeSemestreServices {
    private final SemestreRepository semestreRepository;
    private final NiveauRepository niveauRepository;
    private final SectionRepository sectionRepository;
    private final UniteRepository uniteRepository;


    public Semestre getSemestre(Long semestreId) {
        Semestre semestre=semestreRepository.findById(semestreId).orElseThrow(()->new IllegalStateException(("Semestre does not exist")));
        return semestre;
    }

    public List<Semestre> getSemestres() {
        return semestreRepository.findAll();
    }

    public void addSemestre(Semestre semestre,Long sectionId,Long niveauId,Long unit1,Long unit2,Long unit3,Long unit4,Long unit5,Long unit6) {
        Optional<Semestre> semestreOptional= semestreRepository.chargeFindSemestreByName(semestre.getName());
        if(semestreOptional.isPresent()){
            throw new IllegalStateException("Semestre Exists");
        }

        Section section= sectionRepository.findById(sectionId).orElseThrow(()->new IllegalStateException(("Section does not exist")));
        semestre.setSections(section);

        Niveau niveau= niveauRepository.findById(niveauId).orElseThrow(()->new IllegalStateException(("Niveau does not exist")));
        semestre.setNiveau(niveau);

        int numUnite=semestre.getNumUnite();

        if (numUnite==4)
        {
            Unite unite1= uniteRepository.findById(unit1).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite2= uniteRepository.findById(unit2).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite3= uniteRepository.findById(unit3).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite4= uniteRepository.findById(unit4).orElseThrow(()->new IllegalStateException(("Unite does not exist")));

            semestre.setUnit1(unite1);
            semestre.setUnit2(unite2);
            semestre.setUnit3(unite3);
            semestre.setUnit4(unite4);

        }
        else if (numUnite==5)
        {
            Unite unite1= uniteRepository.findById(unit1).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite2= uniteRepository.findById(unit2).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite3= uniteRepository.findById(unit3).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite4= uniteRepository.findById(unit4).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite5= uniteRepository.findById(unit5).orElseThrow(()->new IllegalStateException(("Unite does not exist")));

            semestre.setUnit1(unite1);
            semestre.setUnit2(unite2);
            semestre.setUnit3(unite3);
            semestre.setUnit4(unite4);
            semestre.setUnit5(unite5);
        }
        else if (numUnite==6)
        {
            Unite unite1= uniteRepository.findById(unit1).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite2= uniteRepository.findById(unit2).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite3= uniteRepository.findById(unit3).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite4= uniteRepository.findById(unit4).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite5= uniteRepository.findById(unit5).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite6= uniteRepository.findById(unit6).orElseThrow(()->new IllegalStateException(("Unite does not exist")));

            semestre.setUnit1(unite1);
            semestre.setUnit2(unite2);
            semestre.setUnit3(unite3);
            semestre.setUnit4(unite4);
            semestre.setUnit5(unite5);
            semestre.setUnit6(unite6);

        }
        else if (numUnite==2)
        {
            Unite unite1= uniteRepository.findById(unit1).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
            Unite unite2= uniteRepository.findById(unit2).orElseThrow(()->new IllegalStateException(("Unite does not exist")));

            semestre.setUnit1(unite1);
            semestre.setUnit2(unite2);
        }


        semestreRepository.save(semestre);
    }


    public void deleteMatiere(Long semestreId) {
        boolean exists=semestreRepository.existsById(semestreId);
        if(!exists){
            throw new IllegalStateException("Semestre with id"+semestreId+" does not exists");
        }
        semestreRepository.deleteById(semestreId);

    }

}
