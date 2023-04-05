package com.example.demo.distributionCharge.unite;
import com.example.demo.Doa.MatiereRepository;
import com.example.demo.Doa.UniteRepository;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Regime;
import com.example.demo.entities.Unite;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChargeUniteServices {


    private final UniteRepository uniteRepository;
    private final MatiereRepository matiereRepository;


    public Unite getUnite(Long userId) {
        Unite unite=uniteRepository.findById(userId).orElseThrow(()->new IllegalStateException(("unite does not exist")));
        return unite;
    }

    public List<Unite> getUnites() {
        return uniteRepository.findAll();
    }

    public void addUnite(Unite unite,Long m1,Long m2,Long m3,Long m4) {
        Optional<Unite> uniteOptional= uniteRepository.chargeFindUniteByName(unite.getName());
        if(uniteOptional.isPresent()){
            throw new IllegalStateException("Unite Exists");
        }
        int numMat=unite.getNumMat();
        if (numMat==1)
        {
            Matiere matiere1= matiereRepository.findById(m1).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));
            unite.setM1(matiere1);
        }
        else if (numMat==2)
        {
            Matiere matiere1= matiereRepository.findById(m1).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));
            Matiere matiere2= matiereRepository.findById(m2).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));
            unite.setM1(matiere1);
            unite.setM2(matiere2);
        }
        else if (numMat==3)
        {
            Matiere matiere1= matiereRepository.findById(m1).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));
            Matiere matiere2= matiereRepository.findById(m2).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));
            Matiere matiere3= matiereRepository.findById(m3).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));
            unite.setM1(matiere1);
            unite.setM2(matiere2);
            unite.setM3(matiere3);
        }
        else if (numMat==4)
        {
            Matiere matiere1= matiereRepository.findById(m1).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));
            Matiere matiere2= matiereRepository.findById(m2).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));
            Matiere matiere3= matiereRepository.findById(m3).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));
            Matiere matiere4= matiereRepository.findById(m4).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));
            unite.setM1(matiere1);
            unite.setM2(matiere2);
            unite.setM3(matiere3);
            unite.setM4(matiere4);

        }

        uniteRepository.save(unite);
    }


    public void deleteUnite(Long uniteId) {
        boolean exists=uniteRepository.existsById(uniteId);
        if(!exists){
            throw new IllegalStateException("Unite with id"+uniteId+" does not exists");
        }
        uniteRepository.deleteById(uniteId);

    }


}

