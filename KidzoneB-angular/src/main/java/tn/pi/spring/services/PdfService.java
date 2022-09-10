package tn.pi.spring.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

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

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.entities.Facture;

@Service
@Slf4j
public class PdfService {
	
	public static ByteArrayInputStream subscribePDFReport(Facture subscribes)
	{String DateFact;
		Facture fact = new Facture();
		DateFact = fact.getDateFact().toString();
		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(document, out);
			document.open();
			//bech najouti 7aja fel pdf kima text mithhel
			//na3tih size lktiba w couler ( w jw athaka)
		 	com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER,14, BaseColor.BLACK);
		 	document.add(Chunk.NEWLINE);
		 	float col =280f;
		 	float colwidth []= {col,col};
		 	PdfPTable table = new PdfPTable(colwidth);
		 
		 	
		 	 	
		 	 	
		 		PdfPCell col1 = new PdfPCell( new Phrase("Facture\n Facture n .."));
		 		col1.setPaddingLeft(1);
		 		col1.setVerticalAlignment(Element.ALIGN_CENTER);
		 		col1.setHorizontalAlignment(Element.ALIGN_CENTER);
		 		col1.setBackgroundColor(BaseColor.LIGHT_GRAY);
		 		table.addCell(col1); 
		 		PdfPCell col2 = new PdfPCell( new Phrase("Société...\n Télephone ....\n Adresse ... "));
		 		col2.setPaddingLeft(1);
		 		col2.setVerticalAlignment(Element.ALIGN_RIGHT);
		 		col2.setHorizontalAlignment(Element.ALIGN_RIGHT);
		 		col2.setBackgroundColor(BaseColor.LIGHT_GRAY);
		 		table.addCell(col2);
		 		
		 		
		 		
		 		
		 		float colWidth []= {80, 300, 100, 80};
		 		PdfPTable client= new PdfPTable(colWidth);
		 		PdfPCell info = new PdfPCell(new Phrase("customer info"));
		 		client.addCell(info);
		 		info.setBorder(0);
		 		info.setRowspan(0);
		 		info.setColspan(4);
		 		PdfPCell clientnom = new PdfPCell(new Phrase("customer name\n \n NumFature \n \n DateFacutre" +""+ DateFact ));
		 		clientnom.setBorder(0);
		 		client.addCell(clientnom);
		 		PdfPCell DateFacte = new PdfPCell(new Phrase());
		 		DateFacte.setBorder(0);
		 		client.addCell(DateFacte);
		 		PdfPCell numFact = new PdfPCell(new Phrase());
		 		numFact.setBorder(0);
		 		client.addCell(numFact);
		 		PdfPCell numFacct = new PdfPCell(new Phrase());
		 		numFacct.setBorder(0);
		 		client.addCell(numFact);
		 	document.add(table);
		 	Paragraph p = new Paragraph("\n \n \n"); document.add(p);
		 	document.add(client);
		 	document.close();
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return new ByteArrayInputStream(out.toByteArray());
		
		
		
		
		
		
		
		
		
	}
}