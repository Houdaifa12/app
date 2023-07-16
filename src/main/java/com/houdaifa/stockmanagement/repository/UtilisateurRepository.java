package com.houdaifa.stockmanagement.repository;

import com.houdaifa.stockmanagement.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository< Utilisateur,Integer> {
}
