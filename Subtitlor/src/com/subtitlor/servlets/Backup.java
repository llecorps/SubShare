package com.subtitlor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subtitlor.dao.DaoFactory;
import com.subtitlor.dao.TraducteurDao;

@WebServlet()
public class Backup extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private TraducteurDao traducteurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.traducteurDao = daoFactory.getTraducteurDao();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Backup() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setAttribute("traductions", traducteurDao.lister());
    	
        this.getServletContext().getRequestDispatcher("/WEB-INF/backup.jsp").forward(request, response);
    }
   
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	
    	traducteurDao.Ecrire();
    	
    	
    	this.getServletContext().getRequestDispatcher("/WEB-INF/backup.jsp").forward(request, response);
    	
    }

}