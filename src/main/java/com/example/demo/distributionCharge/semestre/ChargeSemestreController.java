package com.example.demo.distributionCharge.semestre;

import com.example.demo.distributionCharge.semestre.ChargeSemestreServices;
import com.example.demo.entities.Semestre;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/semestre")

public class ChargeSemestreController {

    private final ChargeSemestreServices semestreService;

    @Autowired
    public ChargeSemestreController(ChargeSemestreServices semestreService){
        this.semestreService=semestreService;
    }

    @GetMapping(path="{semestreId}")
    public Semestre getSemestre(@PathVariable("semestreId") Long semestreId){
        return semestreService.getSemestre(semestreId);

    }

    @GetMapping
    public List<Semestre> getSemestres(){return semestreService.getSemestres();}

    @PostMapping
    public void addSemestre(@RequestBody Semestre semestre,
                            @RequestParam(required=false) Long sectionId,
                            @RequestParam(required=false) Long niveauId,
                            @RequestParam(required=false) Long unit1,
                            @RequestParam(required=false) Long unit2,
                            @RequestParam(required=false) Long unit3,
                            @RequestParam(required=false) Long unit4,
                            @RequestParam(required=false) Long unit5,
                            @RequestParam(required=false) Long unit6){
        semestreService.addSemestre(semestre,sectionId,niveauId,unit1,unit2,unit3,unit4,unit5,unit6);
    }

    @DeleteMapping(path="{semestreId}")
    public void deleteSemestre(@PathVariable("semestreId") Long semestreId) {semestreService.deleteMatiere(semestreId);}


}
