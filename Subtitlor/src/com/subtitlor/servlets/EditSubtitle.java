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
	static //private static final String FILE_NAME = "/WEB-INF/password_presentation.srt";
	
	NomFichier nomfiche = new NomFichier();
    
	private static final String FILE_NAME = nomfiche.getNomdufichier();
	
	
	private static final String CHEMIN_FICHIERS = "/WEB-INF/"+FILE_NAME;
	
    private TraducteurDao traducteurDao;
	private ImplementeurDao implementeurDao;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		System.out.println(context.getRealPath(CHEMIN_FICHIERS));
		SubtitlesHandler subtitles = new SubtitlesHandler(context.getRealPath(CHEMIN_FICHIERS));
		
		TriOriginal  trioriginal = new TriOriginal(subtitles.getSubtitles());
		
		
		
		request.setAttribute("subtitles", subtitles.getSubtitles());
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/edit_subtitle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String[] tabvalues=request.getParameterValues("champCache");
		
		TriTraduction  tritraduction = new TriTraduction(tabvalues);
	
     
        String message = "Commit Done !!!!";
                
        request.setAttribute("message", message);
                
	           
        this.getServletContext().getRequestDispatcher("/WEB-INF/edit_subtitle.jsp").forward(request, response);
        
    }
		
		
		
		
	}


