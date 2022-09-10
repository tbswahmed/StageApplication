package tn.pi.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.pi.spring.entities.Article;
import tn.pi.spring.services.ArticleImp;

@RestController  
@RequestMapping("articleController")
public class ArticleController {
	@Autowired
	ArticleImp articleimp;
	
	
	
	@GetMapping("/afficherarticleS")
	@ResponseBody 
	List<Article> afficherAllArticle(){
	return articleimp.retrieveArticle();
	}
	
	@GetMapping("/afficherarticleById/{id}")
	@ResponseBody 
	Article afficherArticleById(@PathVariable("id")Long id) {
	return articleimp.retrieveById(id);
	}


	@RequestMapping(value="/addarticle/{idCategorie}", method =RequestMethod.POST, produces= {"application/json"}, consumes = {"multipart/form-data"})
	@ResponseBody
	    public Article saveArticle( @RequestBody Article p,@RequestParam("file") MultipartFile file,@PathVariable("idCategorie") Long idCategorie)	
	    {  
	    	return articleimp.addArticle(p,file,idCategorie);
	    }
	
	
	
	@PutMapping("/updatecat")
	@ResponseBody
	Article updateArticle(@RequestBody Article c) { 
	return articleimp.updateArticle(c);
	}
	
	
	
	@DeleteMapping("/deletecat/{id}")
	@ResponseBody
	void supprimerArticle(@PathVariable("id") Long id) {
		articleimp.deleteArticle(id);
	}
	
	
	
	@GetMapping("/afficherarticleByCategories/{id}")
	@ResponseBody 
	List<Article> afficherArticleByCategories(@PathVariable("id")Long id) {
	return articleimp.getArticleByCategorie(id);
	}
	











}