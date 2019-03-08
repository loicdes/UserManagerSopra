package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ERR_MSG_MDP_INCORRECT = "Mots de passe incorrects";
	private static final String ERR_MSG_PARAM_VIDE = "Ce champ est obligatoire";
	public static HashMap <String,String> map_errors = new HashMap<>();
	public static HashMap <String,String> map_params = new HashMap<>();
	private static final String ERR_MDP = "err_mdp";
	private static final String ERR_EMAIL = "err_mail";
	private static final String ERR_NAME = "err_name";
	private static final String ATT_NAME = "i_name";
	private static final String ATT_MAIL = "i_mail";
	private static final String ATT_MDP = "i_pwd";
	private static final String ATT_MDP1 = "i_pwd1";
    private static HttpSession session;
    public static ArrayList<User> listUsers;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/register.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		map_errors = new HashMap<>();
		map_params = new HashMap<>();
		map_params.put(ATT_MDP, (String) request.getParameter(ATT_MDP));
		map_params.put(ATT_MAIL, (String) request.getParameter(ATT_MAIL));
		map_params.put(ATT_MDP1, (String) request.getParameter(ATT_MDP1));
		map_params.put(ATT_NAME, (String) request.getParameter(ATT_NAME));
		validateEmail(map_params.get(ATT_MAIL));
		validatePwd(map_params.get(ATT_MDP),map_params.get(ATT_MDP1));
		validateName(map_params.get(ATT_NAME));
		if(map_errors.size() > 0) {
			request.setAttribute("actionMessage", "Echec de l'inscription");
			request.setAttribute("map_errors", map_errors);
			request.setAttribute("map_params", map_params);
		}else {
			request.setAttribute("actionMessage", "Inscription réussie");
			User user = new User();
			user.setEmail(map_params.get(ATT_MAIL));
			user.setNom(map_params.get(ATT_NAME));
			user.setMdp(map_params.get(ATT_MDP));
			request.setAttribute("newUser",user);
			session = request.getSession();
			listUsers = ( ArrayList<User>) session.getAttribute("users");
			if(listUsers == null) listUsers = new ArrayList<>();
			listUsers.add(user);
			session.setAttribute("users", listUsers);
		}
		doGet(request,response);
		
	}

	private void validateEmail( String email ){ 
		if(email.length() == 0) {
			map_errors.put(ERR_EMAIL, ERR_MSG_PARAM_VIDE);
			}
		}
	
	private void validatePwd(String pwd1, String pwd2){ 
		if(pwd1.length() > 0 && pwd2.length() > 0) { 
				if(pwd1.equals(pwd2)) { //Test si les chaines de caractères sont identiques
					
				}else { //Les chaines de caractères n'ont pas le bon format
					map_errors.put(ERR_MDP, ERR_MSG_MDP_INCORRECT);
				}
			}else {
				map_errors.put(ERR_MDP, ERR_MSG_PARAM_VIDE);
			}
		}
	
	private void validateName(String name){ 
		if(name.length() == 0) {
			map_errors.put(ERR_NAME, ERR_MSG_PARAM_VIDE);
			}
		}

}
