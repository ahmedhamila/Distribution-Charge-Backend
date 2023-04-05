package com.example.demo.distributionCharge.diplome;

import com.example.demo.distributionCharge.diplome.ChargeDiplomeServices;
import com.example.demo.entities.Diplome;


import com.example.demo.entities.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/diplome")

public class ChargeDiplomeController {

    private final ChargeDiplomeServices diplomeService;

    @Autowired
    public ChargeDiplomeController(ChargeDiplomeServices diplomeService){
        this.diplomeService=diplomeService;
    }

    @GetMapping(path="{diplomeId}")
    public Diplome getDiplome(@PathVariable("diplomeId") Long diplomeId){
        return diplomeService.getDiplome(diplomeId);

    }
    @GetMapping
    public List<Diplome> getDiplomes(){
        return diplomeService.getDiplomes();
    }

    @PostMapping
    public void addDiplome(@RequestBody Diplome diplome){
        diplomeService.addDiplome(diplome);
    }

    @DeleteMapping(path="{diplomeId}")
    public void deleteDiplome(@PathVariable("diplomeId") Long diplomeId){
        diplomeService.deleteDiplome(diplomeId);
    }


}
