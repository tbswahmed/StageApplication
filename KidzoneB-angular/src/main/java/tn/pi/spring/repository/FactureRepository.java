package tn.pi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.pi.spring.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

	@Query(value="select * from facture f,article a, devis d where ((f.devis_id_devis =d.id_devis) AND (d.artciles_id_art =a.id_art) AND (a.id_art= ?1))",nativeQuery =true)
	List<Facture> FindFactureByArticle(@Param ("id")  long id);
	
	
	@Query(value="select * from facture f,article a, devis d where ((f.devis_id_devis =d.id_devis) AND (d.artciles_id_art =a.id_art) AND (a.art_description= ?1))",nativeQuery =true)
	List<Facture> FindFactureByArticleDescription(@Param ("id")  String id);
}
