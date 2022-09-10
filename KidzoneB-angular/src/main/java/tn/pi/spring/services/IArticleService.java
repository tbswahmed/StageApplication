package tn.pi.spring.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.pi.spring.entities.Article;

public interface IArticleService {

	List<Article> retrieveArticle();
	Article retrieveById(Long id);
	Article addArticle(Article a, MultipartFile file , long categorieId);
	Article updateArticle(Article a);
	void deleteArticle(Long id);
	
	List <Article> getArticleByCategorie(long id);
}
