package tn.pi.spring.services;

import java.util.List;

import tn.pi.spring.entities.Devis;

public interface IDevisService {
	List<Devis> retrieveDevis();
	Devis retrieveById(Long id);
	Devis addDevis(Devis a, long article);
	Devis updateArticle(Devis a);
	void deleteArticle(Long id);
	List<Devis> retrieveDevisByArticle(long id);
	long countDevisByArticle(long id);
	List<Devis> Devisconfirmer();
	List<Devis> devisConfirmerParArticle(long id);
	
long countAllConfirmedDevis();
	
}

