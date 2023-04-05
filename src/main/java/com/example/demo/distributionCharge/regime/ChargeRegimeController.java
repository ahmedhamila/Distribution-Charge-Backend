package com.example.demo.distributionCharge.regime;

import com.example.demo.distributionCharge.regime.ChargeRegimeServices;
import com.example.demo.entities.Regime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/isimm/distributionCharge/regime")

public class ChargeRegimeController {

    private final ChargeRegimeServices regimeService;

    @Autowired
    public ChargeRegimeController(ChargeRegimeServices regimeService){
        this.regimeService=regimeService;
    }

    @GetMapping(path="{regimeId}")
    public Regime getRegime(@PathVariable("regimeId") Long regimeId){
        return regimeService.getRegime(regimeId);

    }
    @GetMapping
    public List<Regime> getRegimes(){
        return regimeService.getRegimes();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void addRegime(@RequestBody Regime regime){
        regimeService.addRegime(regime);
    }

    @DeleteMapping(path="{regimeId}")
    public void deleteRegime(@PathVariable("regimeId") Long regimeId){
        regimeService.deleteRegime(regimeId);
    }


}
