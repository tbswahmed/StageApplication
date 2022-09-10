package tn.pi.spring.services;

import java.util.List;

import tn.pi.spring.entities.Categorie;

public interface ICategorieService {
	List<Categorie> retrieveCategorie();
	Categorie retrieveById(Long id);
	Categorie saveCategorie(Categorie a);
	Categorie updateCategorie(Categorie a);
	void deleteCategorie(Long id);
}
