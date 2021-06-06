package Transferir;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Aluno;
import persistencia.IGenericDAO;
import persistencia.JDBCDAO;

/**
 * Servlet implementation class Dados
 */
@WebServlet("/Dados")
public class Dados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Nome = request.getParameter("tNome");
		Aluno a = new Aluno(Nome);
		
		Integer Matricula = Integer.parseInt(request.getParameter("tMatricula"));
		a.setAluno(Nome);
		a.setMatricula(Matricula);
		
		//IGenericDAO dao = new JDBCDAO();
		
		IGenericDAO<Aluno, Integer> jdbcDao = new JDBCDAO<Aluno, Integer>(Aluno.class);
		try {
			jdbcDao.create(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/Apre.jsp?nome="+Nome+"&matricula="+Matricula);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
