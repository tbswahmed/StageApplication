package tn.pi.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.spring.entities.Categorie;
import tn.pi.spring.repository.CategorieRepository;

@Service
public class CategorieImp implements ICategorieService{

	@Autowired
	CategorieRepository catRepo;
	
	@Override
	public List<Categorie> retrieveCategorie() {
		return  catRepo.findAll();
	}

	@Override
	public Categorie retrieveById(Long id) {
		return catRepo.findById(id).orElse(null);
	}

	@Override
	public Categorie saveCategorie(Categorie a) {
		return catRepo.save(a);
		
	}

	@Override
	public Categorie updateCategorie(Categorie a) {
		return catRepo.save(a);
	}

	@Override
	public void deleteCategorie(Long id) {
		catRepo.deleteById(id);
		
	}

}
