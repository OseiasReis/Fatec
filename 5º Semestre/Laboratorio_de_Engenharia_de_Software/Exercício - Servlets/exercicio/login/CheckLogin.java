package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.GenericDAOException;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;

@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Erro");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String msg = null;
		try {
			UsuarioDAO userDao = new UsuarioDAOImpl();
			
			String login = userDao.login(
					request.getParameter("txtLogin"), request.getParameter("txtSenha"));
			msg = login;
			
		} catch (GenericDAOException e) {
			e.printStackTrace();
			msg = "Erro ao fazer login";
		}

		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./login.jsp");
	}

}
