package tn.pi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.pi.spring.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	
	
	@Query(value="SELECT * FROM article a,categorie c Where((a.categorie_idcat=c.idcat)AND(c.idcat=:id))",nativeQuery =true)
	List<Article> FindArticlebyCategorie(@Param ("id")long id);
}