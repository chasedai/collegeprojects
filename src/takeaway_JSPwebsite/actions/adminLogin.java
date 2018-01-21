package takeaway_JSPwebsite.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import takeaway_JSPwebsite.models.admin;

/**
 * Servlet implementation class adminLogin
 */
@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminName = request.getParameter("admin_name");
		String adminPwd = request.getParameter("admin_pwd");
		admin Admin = new admin(adminName, adminPwd);
		if(adminName.equals("admin")&&adminPwd.equals("admin")){
			request.getSession().setAttribute("Admin", Admin);
			response.sendRedirect("admin/admin_index.jsp");
		}else{
			System.out.println("Admin login failed");
			response.sendRedirect("index.jsp");
		}
	}

}
