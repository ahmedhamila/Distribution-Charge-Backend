package com.example.demo.distributionCharge.section;

import com.example.demo.distributionCharge.section.ChargeSectionServices;
import com.example.demo.entities.Section;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/section")

public class ChargeSectionController {

    private final ChargeSectionServices sectionService;

    @Autowired
    public ChargeSectionController(ChargeSectionServices sectionService){
        this.sectionService=sectionService;
    }

    @GetMapping(path="{sectionId}")
    public Section getSection(@PathVariable("sectionId") Long sectionId){
        return sectionService.getSection(sectionId);

    }
    @GetMapping
    public List<Section> getSections(){
        return sectionService.getSections();
    }

    @PostMapping
    public void addSection(@RequestBody Section section){
        sectionService.addSection(section);
    }

    @DeleteMapping(path="{sectionId}")
    public void deleteSection(@PathVariable("sectionId") Long sectionId){
        sectionService.deleteSection(sectionId);
    }


}
