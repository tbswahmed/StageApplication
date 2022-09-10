package tn.pi.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.pi.spring.entities.Devis;
import tn.pi.spring.services.DevisImp;

@RestController  
@RequestMapping("devisController")
public class DevisController {
	@Autowired
	DevisImp devImp;
	
	@GetMapping("/afficherDevis")
	@ResponseBody 
	List<Devis> afficherAllDevis(){
	return devImp.retrieveDevis();
	}
	
	@GetMapping("/afficherDevisById/{id}")
	@ResponseBody 
	Devis afficherDevis(@PathVariable("id")Long id) {
	return devImp.retrieveById(id);
	}
	
	@RequestMapping(value="/addDevis/{idarticle}", method =RequestMethod.POST, produces= {"application/json"})
	@ResponseBody
		
	    public Devis saveArticle( @RequestBody Devis p,/*@RequestParam("file") MultipartFile file*/@PathVariable("idarticle") Long idarticle)
	    		
	    {  
	    	return devImp.addDevis(p, idarticle);
	    }
	
	
	@GetMapping("/afficherDevisByArticle/{id}")
	@ResponseBody 
	List <Devis> afficherDevisParArticle(@PathVariable("id")Long id) {
	return devImp.retrieveDevisByArticle(id);
	}
	
	@GetMapping("/afficherDevisConfirmerByArticle/{id}")
	@ResponseBody 
	List <Devis> afficherDevisConfimerParArticle(@PathVariable("id")Long id) {
	return devImp.devisConfirmerParArticle(id);
	}
	
	@GetMapping("/afficherDevisconfirmed")
	@ResponseBody 
	List<Devis> afficherAllDevisConfirmed(){
	return devImp.Devisconfirmer();
	}
	
	@GetMapping("/countDevisByArticle/{id}")
	@ResponseBody 
	long countDevisByArticle(@PathVariable("id")Long id) {
	return devImp.countDevisByArticle(id);
	}
	
	
	@GetMapping("/countDevisconfirmer")
	@ResponseBody 
	long countDevisConfirmer() {
	return devImp.countAllConfirmedDevis();
	}
	
	
	
	
	
	
	
	

}

