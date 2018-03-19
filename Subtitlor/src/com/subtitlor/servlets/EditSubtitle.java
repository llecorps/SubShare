package com.subtitlor.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subtitlor.dao.DaoFactory;
import com.subtitlor.dao.ImplementeurDao;
import com.subtitlor.dao.TraducteurDao;
import com.subtitlor.utilities.*;


@WebServlet("/EditSubtitle")
public class EditSubtitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_NAME = "/WEB-INF/password_presentation.srt";
	
    private TraducteurDao traducteurDao;
	private ImplementeurDao implementeurDao;
    
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.traducteurDao = daoFactory.getTraducteurDao();
        //this.implementeurDao = daoFactory.getImplementeurDao();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		System.out.println(context.getRealPath(FILE_NAME));
		SubtitlesHandler subtitles = new SubtitlesHandler(context.getRealPath(FILE_NAME));
		
		Decoupeur  decoupeur = new Decoupeur(subtitles.getSubtitles());
		
		//table texte original ligneDaoArray
		
		request.setAttribute("subtitles", subtitles.getSubtitles());
		//request.setAttribute("traducteur", traducteurDao.lister());
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/edit_subtitle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Traducteur traducteur = new Traducteur();
		//TranslationImpl listetraduction= new TranslationImpl();
		//String champ;
		
		
		String[] tabvalues=request.getParameterValues("champCache");
	
         
        for(int i=0;i<tabvalues.length;i++)
       {
            //lignedao       
        	traducteur.setTraduction(tabvalues[i]);
        	System.out.println("SERVLET :"+traducteur.getTraduction());
        	traducteurDao.ajouter(traducteur);
        	
                    
       }
     
        String message = "Commit Done !!!!";
                
        request.setAttribute("message", message);
                
	    //request.setAttribute("traducteur", traducteurDao.lister());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/edit_subtitle.jsp").forward(request, response);
        
    }
		
		
		
		
	}


