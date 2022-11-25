package com.indusnet.pdf;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.indusnet.entity.User_Details;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class SingleUserPdf {

	public void exportSinglePdf(HttpServletResponse response, User_Details user) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        Paragraph paragraph = new Paragraph("User Details", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("ID : "+user.getId(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
         
        Paragraph paragraph3 = new Paragraph("User Id : "+user.getUser().getUser_id(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph paragraph4 = new Paragraph("Name : "+user.getName(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph paragraph5 = new Paragraph("Phone : "+user.getMobile(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph paragraph6 = new Paragraph("Email : "+user.getEmail(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph paragraph7 = new Paragraph("LinkedIn : "+user.getLinkedIn(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph paragraph8 = new Paragraph("Created_at : "+user.getCreated_date(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        
        Paragraph paragraph9 = new Paragraph("Updated_at : "+user.getUpdated_date(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);


        document.add(paragraph);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph5);
        document.add(paragraph6);
        document.add(paragraph7);
        document.add(paragraph8);
        document.add(paragraph9);
        
        document.close();
    }
}
