package com.example.demo.distributionCharge.unite;

import com.example.demo.distributionCharge.unite.ChargeUniteServices;
import com.example.demo.entities.Enseignant;

import com.example.demo.entities.Unite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/unite")

public class ChargeUniteController {

    private final ChargeUniteServices uniteService;

    @Autowired
    public ChargeUniteController(ChargeUniteServices uniteService){
        this.uniteService=uniteService;
    }

    @GetMapping(path="{uniteId}")
    public Unite getunite(@PathVariable("uniteId") Long uniteId){
        return uniteService.getUnite(uniteId);
    }
    @GetMapping
    public List<Unite> getUnite(){
        return uniteService.getUnites();
    }

    @PostMapping
    public void addUnite(@RequestBody Unite unite,
                         @RequestParam(required=false) Long m1,
                         @RequestParam(required=false) Long m2,
                         @RequestParam(required=false) Long m3,
                         @RequestParam(required=false) Long m4){

        uniteService.addUnite(unite,m1,m2,m3,m4);
    }

    @DeleteMapping(path="{uniteId}")
    public void deleteUser(@PathVariable("uniteId") Long uniteId){
        uniteService.deleteUnite(uniteId);
    }


}
