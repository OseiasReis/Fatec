package br.edu.etec.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller_Servlet
 */
@WebServlet("/Controller_Servlet")
public class Controller_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>");
		writer.append("<html>");
		writer.append("<head>");
		writer.append("<meta charset='UTF-8'/ >");
		writer.append("<title>Logar-se</title>");
		writer.append("<stylus");
		writer.append("</stylus");
		writer.append("</head>");
		writer.append("<body>");
		writer.append("<form method='Post' action='http://localhost:8080/Aula_1/Controller_Servlet'>");
		writer.append("<fieldset>");
		writer.append("<legend>Logar-se</legend>");
		writer.append("<p> <label for='cLogin'>Login: </label><input type='text' name='tLogin' id='cLogin' size='45' maxlength='35' placeholder= 'Digite o Login'/>");
		writer.append("<p> <label for='cSenha'>Senha: </label><input type='password' name='tSenha' id='cSenha' size='45' maxlength='35' placeholder= 'Digite a Senha'/>");
		writer.append("<br /><br /><input type='submit' name='tEnviar' value='Enviar'/>");
		writer.append("</fieldset>");
		writer.append("</form>");
		writer.append("</body>");
		writer.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getParameter("tLogin");
	}

}
