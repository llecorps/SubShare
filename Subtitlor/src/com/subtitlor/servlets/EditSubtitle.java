package com.subtitlor.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subtitlor.utilities.*;


@WebServlet("/EditSubtitle")
public class EditSubtitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_NAME = "/WEB-INF/password_presentation.srt";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		System.out.println(context.getRealPath(FILE_NAME));
		SubtitlesHandler subtitles = new SubtitlesHandler(context.getRealPath(FILE_NAME));
		
		request.setAttribute("subtitles", subtitles.getSubtitles());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/edit_subtitle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Traduction traduction = new Traduction();
		TranslationImpl listetraduction= new TranslationImpl();
		String champ;
		//tradchamp.setLigne(request.getParameter("line"${ status.index }));
		
		//ServletResponse res = null;
		//PrintWriter pw=res.getWriter();
        //res.setContentType("text/html");
 
        //ServletRequest req = null;
		String[] tabvalues=request.getParameterValues("champCache");
	
        //pw.println("Selected Values...");    
        for(int i=0;i<tabvalues.length;i++)
       {
           //pw.println("<li>"+values[i]+"</li>");
           traduction.setChamp(tabvalues[i]); 
           champ = traduction.getChamp();
         System.out.println(champ);
          listetraduction.addlisteTraduction(champ);
          
           
       }
       //pw.close();  
        
        request.setAttribute("liste",listetraduction.getlisteTraduction());
        this.getServletContext().getRequestDispatcher("/WEB-INF/edit_subtitle.jsp").forward(request, response);
        
    }
		
		
		//traduction.setLigne(request.getParameter("value"));
		
	}


