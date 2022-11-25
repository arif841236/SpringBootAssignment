package com.indusnet.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.indusnet.entity.UserLoginDetails;
import com.indusnet.entity.User_Details;
import com.indusnet.exeption.ResponceException;
import com.indusnet.pdf.SingleUserPdf;
import com.indusnet.pdf.UserPDFExporter;
import com.indusnet.reposetry.UserDao;
import com.indusnet.reposetry.UserLoginRepository;
import com.indusnet.service.UserDetailService;

@RestController
public class PdfController {

	@Autowired
	private UserDetailService userDetailsService;
	
	@Autowired
	SingleUserPdf singlePdf;
	
	private UserPDFExporter userPdfService;
	
	@Autowired
	private UserDao uDao;
	
	@Autowired
	private UserLoginRepository uLogin;
	
	@Autowired
	public PdfController(UserPDFExporter userPdfService) {
		super();
		this.userPdfService = userPdfService;
	}

	
	@GetMapping("/allUserDetailspdf")
    public void generatePDF(HttpServletResponse response) throws IOException {
        
        response.setContentType("application/pdf");
        
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
       
        String headerKey = "Content-Disposition";
        
        String headerValue = "attachment; filename="+ currentDateTime + ".pdf";
        
        response.setHeader(headerKey, headerValue);


        userPdfService.export(response );
        
    }
	
	
	@GetMapping("/pdf")
    public void generatePDFfor(HttpServletRequest http,HttpServletResponse response) throws IOException {
		
		String token = http.getHeader("Authorization");
		token = token.replaceAll("Bearer ", "");
		UserLoginDetails userLogin=uLogin.findByToken(token);
		
		if(userLogin!=null) {
			User_Details user_detail = userDetailsService.getUserDetailsByUserId(userLogin.getUser().getUser_id());
	        
	        response.setContentType("application/pdf");
	        
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        
	        String username = uDao.getUsernameById(user_detail.getUser().getUser_id());
	        String headerKey = "Content-Disposition";
	       
	        String headerValue = "attachment; filename=" +username+"_"+ currentDateTime + ".pdf";
	        
	        response.setHeader(headerKey, headerValue);


	        singlePdf.exportSinglePdf(response, user_detail);
		}
		
		else {
			throw new ResponceException("");
		}
        
    }
}
