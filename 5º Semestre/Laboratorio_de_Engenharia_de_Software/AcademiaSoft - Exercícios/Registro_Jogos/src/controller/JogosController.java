package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GenericDAOException;
import dao.JogosDAO;
import dao.JogosDAOImpl;
import model.Jogos;
@WebServlet("/JogosController")
public class JogosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JogosController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter()
		.append("Para acessar utilize a pagina de <a href=\"./jogos.jsp\">Jogos</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String msg = null;
		HttpSession session = request.getSession();
		try {
			JogosDAO jogosDao = new JogosDAOImpl();
			if ("adicionar".equals(cmd)) {
				Jogos jogos = new Jogos();
				jogos.setNome(request.getParameter("txtNome"));
				jogos.setDif(request.getParameter("txtDif"));
				jogosDao.adicionar( jogos );
				msg = "Jogo " + request.getParameter("txtNome") + " foi adicionado com sucesso";
			} else if ("pesquisar".equals(cmd)) {
				List<Jogos> lista = jogosDao.presquisarPorNome(
						request.getParameter("txtNome"));
				session.setAttribute("LISTA", lista);
				msg = "Foram encontrados " + lista.size() + " jogos";
			}
		} catch (GenericDAOException e) {
			e.printStackTrace();
			msg = "Erro ao adicionar este jogo";
		}

		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./jogos.jsp");
	}

}
