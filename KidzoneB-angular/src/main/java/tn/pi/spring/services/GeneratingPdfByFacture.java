package tn.pi.spring.services;

import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.stream.Stream;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



import tn.pi.spring.entities.Article;
import tn.pi.spring.entities.Facture;

@Service
public class GeneratingPdfByFacture {

	public static ByteArrayInputStream subscribePDFReport(Facture subscribes)
	{
		
		
		
				String DateFact;
				Facture fact = new Facture();
				DateFact = fact.getDateFact().toString();
				long Qte = fact.getQuantité();
			 String qtee = Long.toString(Qte);
			 long nfact = fact.getNumFact();
			 String numfact = Long.toString(nfact);
			 float totalttcc = fact.getTotalTTC();
			 String ttc = Float.toString(totalttcc);
			
			 
			 
		Article Art = new Article();
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(document, out);
			document.open();
			com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER,14, BaseColor.BLACK);
			Paragraph para = new Paragraph("Facture", font);
			para.setAlignment(Element.ALIGN_CENTER);
			
			document.add(para);
			Paragraph ptel;
	        ptel = new Paragraph("Teléphone");
	        ptel.setAlignment(Element.ALIGN_RIGHT);
	        document.add(ptel);
	        ptel = new Paragraph(Art.getArtReference());
	        ptel.setAlignment(Element.ALIGN_RIGHT);
	        document.add(ptel);
	        ptel.setAlignment(Element.ALIGN_RIGHT);
	        document.add(ptel);
	        ptel = new Paragraph("mail" + "" + "swds@gamil.com");
	        ptel.setAlignment(Element.ALIGN_RIGHT);
	        document.add(ptel);
			
			//bech najouti 7aja fel pdf kima text mithhel
			//na3tih size lktiba w couler ( w jw athaka)
		 	//com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER,14, BaseColor.BLACK);
		 	
		 	para.setAlignment(Element.ALIGN_CENTER);
		 	document.add(para);
		 	document.add(Chunk.NEWLINE);
		 	PdfPTable table = new PdfPTable(2);
		 	
		 	//bech nrilg l contenue tw
		 	Stream.of("test","test").forEach(headerTitle ->{
		 		PdfPCell header = new PdfPCell();
			 	com.itextpdf.text.Font headfont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 	header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			 	header.setHorizontalAlignment(Element.ALIGN_CENTER);
			 	header.setBorderWidth(1);
			 	header.setPhrase(new Phrase(headerTitle, headfont));
			 	table.addCell(header);
			 	
		 	});
		 	document.add(table);
		 	

		 	PdfPTable tabinfo = new PdfPTable(4);
		 	table.setWidthPercentage(100);
		 	Stream.of("Description","Quantité","Prix Unitaire","total").forEach(headerTitle ->{
		 		PdfPCell header = new PdfPCell();
			 	com.itextpdf.text.Font headfont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 	header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			 	header.setHorizontalAlignment(Element.ALIGN_CENTER);
			 	header.setBorderWidth(1);
			 	header.setPhrase(new Phrase(headerTitle, headfont));
			 	tabinfo.addCell(header);
		 	});
		 	
			PdfPCell Desc = new PdfPCell( new Phrase(subscribes.getDateFact().toString()));
			Desc.setPaddingLeft(1);
			Desc.setVerticalAlignment(Element.ALIGN_MIDDLE);
			Desc.setHorizontalAlignment(Element.ALIGN_LEFT);
			tabinfo.addCell(Desc);

			PdfPCell qte = new PdfPCell( new Phrase(qtee));
			qte.setPaddingLeft(1);
			qte.setVerticalAlignment(Element.ALIGN_MIDDLE);
			qte.setHorizontalAlignment(Element.ALIGN_LEFT);
			tabinfo.addCell(qte);

			PdfPCell prix = new PdfPCell( new Phrase(ttc));
			prix.setPaddingLeft(1);
			prix.setVerticalAlignment(Element.ALIGN_MIDDLE);
			prix.setHorizontalAlignment(Element.ALIGN_LEFT);
			tabinfo.addCell(prix);

			PdfPCell total = new PdfPCell( new Phrase(numfact));
			total.setPaddingLeft(1);
			total.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 		total.setHorizontalAlignment(Element.ALIGN_LEFT);
			tabinfo.addCell(total);
			/////////////////////////////////////
			document.add(tabinfo);
		 	document.close();
		 	
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return new ByteArrayInputStream(out.toByteArray());
		
		
		
		
		
		
		
		
		
	}
		
}
