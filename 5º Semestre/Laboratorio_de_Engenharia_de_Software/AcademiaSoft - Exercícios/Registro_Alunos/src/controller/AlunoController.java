package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;

/**
 * Servlet implementation class AlunoController
 */
@WebServlet("/AlunoController")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void	init() {
    	List<Aluno> aluno = null;
    	getServletContext().setAttribute("ALUNOS", aluno);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("cmd") == "Adicionar") {
			
			Aluno aluno = new Aluno();
			aluno.setId(Integer.parseInt(request.getParameter("id")));
			aluno.setRa(request.getParameter("id"));
			aluno.setNome(request.getParameter("nome"));
			aluno.setIdade(Integer.parseInt(request.getParameter("id")));
			aluno.setSexo(request.getParameter("id"));
			
			request.getServletContext().setAttribute("ALUNOS", aluno);
		}
	}

}
