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

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" }) // REQUESIcES DO SERVLET "caminhos em formularios, links,
														// botoes..."
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		}else if(action.equals("/insert")) {
			novoContato(request, response);
		}else {
			response.sendRedirect("index.html");
		}

	}

	// LISTAR CONTATOS
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um obj que ira receber os dados javabeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		//Encaminhar a lista ao documento agenda.jsp
		request.setAttribute("contatos",lista);
		RequestDispatcher rd = request.getRequestDispatcher("Agenda.jsp");
		rd.forward(request, response);
	}
	// NOVO CONTATO
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));
		//settar as variaveis javabeans
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		//invocar o método inserirContato passando o obj contato
		dao.inserirContato(contato);
		//redirecionar para agenda.jsp
		response.sendRedirect("main");
	}

}

