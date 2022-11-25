package com.indusnet.pdf;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.indusnet.entity.User_Details;
import com.indusnet.reposetry.UserDao;
import com.indusnet.reposetry.UserDetailsRepository;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
@Component
public class UserPDFExporter {
	
	@Autowired
	private UserDetailsRepository userDetailDao;
	
	@Autowired
	private UserDao uDao;
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.cyan);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.DARK_GRAY);
         
        cell.setPhrase(new Phrase("ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("USER ID", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("MOBILE", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("EMAIL", font));
        table.addCell(cell);  
        
        cell.setPhrase(new Phrase("LINKEDIN", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("CREATED DATE", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("UPDATED DATE", font));
        table.addCell(cell); 
    }
     
    private void writeTableData(PdfPTable table) {
    	List<User_Details> listUsers = userDetailDao.findAll();
        for (User_Details user : listUsers) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(String.valueOf(user.getUser().getUser_id()));
            table.addCell(user.getName());
            table.addCell(user.getMobile());            
            table.addCell(user.getEmail());       
            table.addCell(user.getLinkedIn());
            table.addCell(""+user.getCreated_date());
            table.addCell(""+user.getUpdated_date());
        }
   }
     
    public void export(HttpServletResponse response ) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Users Details", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100f);
        //table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
           
            writeTableHeader(table);
            writeTableData(table);
             
            document.add(table);
             
            document.close();
        
    }
}
