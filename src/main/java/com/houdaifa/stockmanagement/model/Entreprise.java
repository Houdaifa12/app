package com.houdaifa.stockmanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "entreprise")
public class Entreprise extends AbstractEntity{

@Column(name = "nom")
private String nom;

@Column(name="description")
private String description;


@Embedded
private Adresse adresse;

@Column(name="codefiscal")
private String codeFiscal;

@Column(name="photo")
private String photo;

@Column(name="email")
private String email;
@Column(name = "steweb")
private String steweb;

@Column(name = "numtel")
private String numTel;
@OneToMany(mappedBy = "entreprise")
private List<Utilisateur>utilisateurs;
}
