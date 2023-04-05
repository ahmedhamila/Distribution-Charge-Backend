package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Semestre implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_semestre", nullable = false)
    private Long idSemestre;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private int numUnite;

    @ManyToOne //(mappedBy = "semestre",fetch=FetchType.LAZY)
    //@JsonManagedReference
    private Section sections;

    //@JsonBackReference
    @ManyToOne//(fetch = FetchType.LAZY)
    //@JoinColumn(name="id_niveau")
    private Niveau niveau;

    @ManyToOne
    private Unite unit1;
    @ManyToOne
    private Unite unit2;
    @ManyToOne
    private Unite unit3;
    @ManyToOne
    private Unite unit4;
    @ManyToOne
    private Unite unit5;
    @ManyToOne
    private Unite unit6;

    public Semestre(String name, int numUnite, Section sections, Niveau niveau, Unite unit1, Unite unit2, Unite unit3, Unite unit4, Unite unit5, Unite unit6) {
        this.name = name;
        this.numUnite = numUnite;
        this.sections = sections;
        this.niveau = niveau;
        this.unit1 = unit1;
        this.unit2 = unit2;
        this.unit3 = unit3;
        this.unit4 = unit4;
        this.unit5 = unit5;
        this.unit6 = unit6;
    }




    public Semestre(Long idSemestre, String name, int numUnite, Section sections, Niveau niveau, Unite unit1, Unite unit2, Unite unit3, Unite unit4, Unite unit5, Unite unit6) {
        this.idSemestre = idSemestre;
        this.name = name;
        this.numUnite = numUnite;
        this.sections = sections;
        this.niveau = niveau;
        this.unit1 = unit1;
        this.unit2 = unit2;
        this.unit3 = unit3;
        this.unit4 = unit4;
        this.unit5 = unit5;
        this.unit6 = unit6;
    }

    public Semestre() {

    }

    public Semestre(String name, Niveau niveau ) {
        this.name = name;
        this.sections = sections;
        this.niveau = niveau;
        //this.unitesSemstre = new HashSet<>();
    }


    public Semestre(String name, Section sections, Niveau niveau, Set<Unite> unitesSems) {
        this.name = name;
        this.sections = sections;
        this.niveau = niveau;
        //this.unitesSemstre = unitesSems;
    }

    public Semestre(String name, Niveau niveau, Set<Unite> unites) {
        this.name = name;
        this.niveau = niveau;
        //this.unitesSemstre = unites;
    }


    //public void addUnite(Unite unite) {
        //this.unitesSemstre.add(unite);
    //}
    //public void addSections(Section section) {
        //this.sections.add(section);
    //}
}

