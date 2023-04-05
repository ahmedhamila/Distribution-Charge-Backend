package com.example.demo.distributionCharge.matiere;

import com.example.demo.distributionCharge.matiere.ChargeMatiereServices;
import com.example.demo.entities.Enseignant;

import com.example.demo.entities.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/matiere")

public class ChargeMatiereController {

    private final ChargeMatiereServices matiereService;

    @Autowired
    public ChargeMatiereController(ChargeMatiereServices matiereService){
        this.matiereService=matiereService;
    }

    @GetMapping(path="{matiereId}")
    public Matiere getMatiere(@PathVariable("matiereId") Long matiereId){
        return matiereService.getMatiere(matiereId);

    }
    @GetMapping
    public List<Matiere> getMatieres(){
        return matiereService.getMatieres();
    }

    @PostMapping(path="{RegimeId}")
    public void addMatiere(@PathVariable("RegimeId") Long RegimeId,@RequestBody Matiere matiere){
        matiereService.addMatiere(matiere,RegimeId);
    }

    @DeleteMapping(path="{matiereId}")
    public void deleteMatiere(@PathVariable("matiereId") Long matiereId){
        matiereService.deleteMatiere(matiereId);
    }


}
