package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.User;

/**
 * Servlet implementation class UserManagerAction
 */
@WebServlet("/users")
public class UserManagerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagerAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("action") != null) {
			if(request.getParameter("action").equals("list")) {
				this.getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
		}else if(request.getParameter("action").startsWith("delete")) {
			String emailASupprimer = request.getParameter("login");
			ArrayList<User> listUsers = (ArrayList<User>) request.getSession().getAttribute("users");
			for(User user : listUsers) {
				if(user.getEmail().equals(emailASupprimer)) listUsers.remove(user);
			}
			request.getSession().setAttribute("users", listUsers);
			response.sendRedirect("/UserManager_correct3/users");
		}
		}else {
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
