package com.ksi.tiakktiakk.model;

import lombok.*;


import javax.persistence.*;

//@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
@Embeddable
public class Adresse {
    @Column(name = "telephone1")
    private String telephone1;

    @Column(name = "telephone2")
    private String telephone2;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "ville")
    private String ville;

    @Column(name = "pays")
    private String pays;

    /*@OneToMany(mappedBy = "adresse")
    private List<Chauffeur> chauffeurs;*/

}
