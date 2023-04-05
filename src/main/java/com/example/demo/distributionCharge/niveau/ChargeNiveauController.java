package com.example.demo.distributionCharge.niveau;

import com.example.demo.distributionCharge.niveau.ChargeNiveauServices;
import com.example.demo.entities.Niveau;

import com.example.demo.entities.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/niveau")

public class ChargeNiveauController {

    private final ChargeNiveauServices niveauService;

    @Autowired
    public ChargeNiveauController(ChargeNiveauServices niveauService){
        this.niveauService=niveauService;
    }

    @GetMapping(path="{niveauId}")
    public Niveau getNiveau(@PathVariable("niveauId") Long niveauId){
        return niveauService.getNiveau(niveauId);

    }
    @GetMapping
    public List<Niveau> getNiveaux(){return niveauService.getNiveaux();}

    @PostMapping
    public void addNiveau(@RequestParam(required=false) Long diplomeId,@RequestBody Niveau niveau){
        niveauService.addNiveau(niveau,diplomeId);
    }

    @DeleteMapping(path="{niveauId}")
    public void deleteNiveau(@PathVariable("niveauId") Long niveauId){
        niveauService.deleteNiveau(niveauId);
    }


}
