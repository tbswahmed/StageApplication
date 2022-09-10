package tn.pi.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.entities.Article;
import tn.pi.spring.entities.Devis;
import tn.pi.spring.repository.ArticleRepository;
import tn.pi.spring.repository.DevisRepository;

@Service
@Slf4j
public class DevisImp implements IDevisService{

	@Autowired
	DevisRepository dRepo;
	@Autowired
	ArticleRepository artrep;
	
	@Override
	public List<Devis> retrieveDevis() {
		
		return dRepo.findAll();
	}

	@Override
	public Devis retrieveById(Long id) {
		return dRepo.findById(id).orElse(null);
	}

	@Override
	public Devis addDevis(Devis a, long article) {
		Article art =  artrep.findById(article).orElse(null);
		//a.setArtciles(art);
		return dRepo.save(a);
	}

	@Override
	public Devis updateArticle(Devis a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteArticle(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Devis> retrieveDevisByArticle(long id) {
		return dRepo.getDevisByArticle(id);
	}

	@Override
	public long countDevisByArticle(long id) {
		long nbr = dRepo.CountDevisByArticle(id);
		return nbr;
	}

	@Override
	public List<Devis> Devisconfirmer() {
		return dRepo.getAllConfirmedDevis();
	}

	@Override
	public List<Devis> devisConfirmerParArticle(long id) {
		return dRepo.getAllConfirmedDevisByArticle(id);
	}

	@Override
	public long countAllConfirmedDevis() {
		
		return dRepo.countConfirmedDevis();
	}

}
