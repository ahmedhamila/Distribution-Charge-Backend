package com.example.demo.distributionCharge.section;

import com.example.demo.Doa.SectionRepository;
import com.example.demo.entities.Section;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChargeSectionServices {
    private final SectionRepository sectionRepository;


    public Section getSection(Long sectionId) {
        Section section=sectionRepository.findById(sectionId).orElseThrow(()->new IllegalStateException(("Section does not exist")));
        return section;
    }

    public List<Section> getSections() {
        return sectionRepository.findAll();
    }

    public void addSection(Section section) {
        Optional<Section> sectionOptional= sectionRepository.chargeFindSectionByName(section.getName());
        if(sectionOptional.isPresent()){
            throw new IllegalStateException("Section Exists");
        }
        sectionRepository.save(section);
    }


    public void deleteSection(Long sectionId) {
        boolean exists=sectionRepository.existsById(sectionId);
        if(!exists){
            throw new IllegalStateException("Section with id"+sectionId+" does not exists");
        }
        sectionRepository.deleteById(sectionId);

    }

}
