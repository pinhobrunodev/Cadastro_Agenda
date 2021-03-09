package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/insert", "/main" ,"/delete","/select"})
public class Controller extends HttpServlet {

	JavaBeans jb = new JavaBeans();
	DAO dao = new DAO();

	private static final long serialVersionUID = 1L;

	public Controller() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.processRequest(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String urlPattern = request.getServletPath();
		System.out.println(urlPattern);
		if (urlPattern.equals("/main")) {
			listarRegistros(request, response);
		} else if (urlPattern.equals("/insert")) {
			registrarContato(request, response);
		}
		else if(urlPattern.equals("/delete")) {
			removerContato(request, response);
		}
		else if(urlPattern.equals("/select")) {
			selecionarContato(request, response);
		
		}
		else {
			response.sendRedirect("index.html");
		}

	}

	protected void registrarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		jb.setNome(request.getParameter("nome"));
		jb.setEmail(request.getParameter("email"));
		jb.setFone(request.getParameter("fone"));
		dao.adicionarContato(jb);
		response.sendRedirect("main");

	}

	protected void listarRegistros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<JavaBeans> list = dao.listarcontatos();
		request.setAttribute("registros", list);
		RequestDispatcher rd = request.getRequestDispatcher("registros.jsp");
		rd.forward(request, response);
	}
	
	
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		jb.setID(request.getParameter("id"));
		dao.removerContato(jb);
		response.sendRedirect("main");

	}
	
	
	protected void selecionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		jb.setID(request.getParameter("id"));
		dao.selecionarContato(jb);
		System.out.println(jb.getID());
		System.out.println(jb.getNome());
		System.out.println(jb.getEmail());
		System.out.println(jb.getFone());
		response.sendRedirect("main");
		
	}
	
	

	

}
