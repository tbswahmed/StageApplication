package tn.pi.spring.services;

import java.util.List;

import tn.pi.spring.entities.Facture;

public interface IFactureService {
	List<Facture> retrieveFacture();
	Facture retrieveById(Long id);
	Facture addFacture(Facture a, long devisId);
	Facture updateFacture(Facture a);
	void deleteFacture(Long id);
	
	List<Facture> retrieveFactureByArticle( long id);
	List<Facture> retrieveFactureByArticleDesc( String name);
	

	Facture addFactureByConfirmedDevis(Facture a, long devisId);
}

