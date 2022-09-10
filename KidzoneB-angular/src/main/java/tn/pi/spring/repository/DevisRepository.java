package tn.pi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.pi.spring.entities.Devis;

public interface DevisRepository extends JpaRepository<Devis, Long> {

	
	
	@Query(value="SELECT * FROM devis d,article a WHERE((d.artciles_id_art=a.id_art)AND(a.id_art=:idarticle))", nativeQuery=true)
	List<Devis>getDevisByArticle(@Param("idarticle") long idarticle);
	
	@Query(value="SELECT count(*) FROM devis d,article a WHERE((d.artciles_id_art=a.id_art)AND(a.id_art=:idarticle))", nativeQuery=true)
	long CountDevisByArticle(@Param("idarticle") long idarticle);
	
	@Query(value="SELECT * FROM devis d WHERE(d.confirmer_devis=true)", nativeQuery=true)
	List<Devis> getAllConfirmedDevis();
	
	@Query(value="SELECT * FROM devis d,article a  WHERE((d.artciles_id_art=a.id_art)AND(a.id_art=:idarticle)AND(d.confirmer_devis=true)  )", nativeQuery=true)
	List<Devis> getAllConfirmedDevisByArticle(@Param("idarticle") long idarticle);
	
	@Query(value="SELECT count(*) FROM devis d WHERE(d.confirmer_devis=true)", nativeQuery=true)
	long countConfirmedDevis();
	
	
	
	
	
	


}
