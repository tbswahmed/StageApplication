package tn.pi.spring.Controller;

import java.util.List;
import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import tn.pi.spring.entities.Facture;
import tn.pi.spring.repository.FactureRepository;
import tn.pi.spring.services.ExportFactureService;
import tn.pi.spring.services.FactureImp;
import tn.pi.spring.services.GeneratingPdfByFacture;
import tn.pi.spring.services.PdfService;

@RestController  
@RequestMapping("factureController")
public class FactureController {
	@Autowired
	FactureImp factimp;
	@Autowired
	FactureRepository repo;
	@Autowired
	ExportFactureService service;
	@Autowired
	GeneratingPdfByFacture gfservice;
	@Autowired
	PdfService fservice;
	
	
	
	
	
	
	
	
	
	@GetMapping("/afficherFactureS")
	@ResponseBody 
	List<Facture> afficherAllFacture(){
	return factimp.retrieveFacture();
	}
	
	@GetMapping("/afficherFactureById/{id}")
	@ResponseBody 
	Facture afficherFactureById(@PathVariable("id")Long id) {
	return factimp.retrieveById(id);
	}


	@RequestMapping(value="/addFacture/{iddevis}", method =RequestMethod.POST, produces= {"application/json"})
	@ResponseBody
		
	    public Facture saveFacture( @RequestBody Facture p,/*@RequestParam("file") MultipartFile file*/@PathVariable("iddevis") Long iddevis)
	    		
	    {  
	    	return factimp.addFacture(p,iddevis);
	    }
	
	
	
	
	@PutMapping("/updateFacture")
	@ResponseBody
	Facture updateFacture(@RequestBody Facture c) { 
	return factimp.updateFacture(c);
	}
	
	
	
	@DeleteMapping("/deletecat/{id}")
	@ResponseBody
	void supprimerFacture(@PathVariable("id") Long id) {
		factimp.deleteFacture(id);
	}
	@GetMapping("/afficherFactureSArticles/{id}")
	@ResponseBody 
	List<Facture> afficherAllFactureByArticle(@PathVariable("id")Long id){
	return factimp.retrieveFactureByArticle(id);
	}
	
	@GetMapping("/afficherFactureSArticlesDesc/{name}")
	@ResponseBody 
	List<Facture> afficherAllFactureByArticleDesc(@PathVariable("name")String name){
	return factimp.retrieveFactureByArticleDesc(name);
	}
	
	
	@GetMapping("/exportpdf")
	public ResponseEntity<InputStreamResource> exportTermsPdf()
	{
		List<Facture> subscribes = (List<Facture>) repo.findAll();
		ByteArrayInputStream byt = service.subscribePDFReport(subscribes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content Disposition", "inline; filename=subscribes.pdf");
		return ResponseEntity.ok().headers(headers).contentType(org.springframework.http.MediaType.APPLICATION_PDF).body(new InputStreamResource(byt));
	}
	
	@GetMapping("/exportpdfacture/{id}")
	public ResponseEntity<InputStreamResource> exporteTermsPdf(@PathVariable("id") long id)
	{
		Facture subscribes = repo.findById(id).orElse(null);
		ByteArrayInputStream byt = gfservice.subscribePDFReport(subscribes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content Disposition", "inline; filename=subscribes.pdf");
		return ResponseEntity.ok().headers(headers).contentType(org.springframework.http.MediaType.APPLICATION_PDF).body(new InputStreamResource(byt));
	}
	
	
	@GetMapping("/exportpdfacture74/{id}")
	public ResponseEntity<InputStreamResource> exportPdf(@PathVariable("id") long id)
	{	//Facture subscribes = new Facture();
		Facture subscribes = repo.findById(id).orElse(null);
		ByteArrayInputStream byt = fservice.subscribePDFReport(subscribes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content Disposition", "inline; filename=subscribes.pdf");
		return ResponseEntity.ok().headers(headers).contentType(org.springframework.http.MediaType.APPLICATION_PDF).body(new InputStreamResource(byt));
	}
	
	
	@RequestMapping(value="/addFactureDevis/{iddevis}", method =RequestMethod.POST, produces= {"application/json"})
	@ResponseBody
		
	    public Facture saveFactureWhenDevisConfirmed( @RequestBody Facture p,/*@RequestParam("file") MultipartFile file*/@PathVariable("iddevis") Long iddevis)
	    		
	    {  
	    	return factimp.addFacture(p,iddevis);
	    }
	
	

}
