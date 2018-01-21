package takeaway_JSPwebsite.actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import takeaway_JSPwebsite.dao.newOrder;
import takeaway_JSPwebsite.models.user;

/**
 * Servlet implementation class makeOrder
 */
@WebServlet("/makeOrder")
public class makeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makeOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();   
	    String price = request.getParameter("price"); 
	    String coursename = request.getParameter("courseName");  
	    user User = (user)request.getSession().getAttribute("User");
	    System.out.println("Username:"+User.getUsername());
	    System.out.println("price是："+price);
	    newOrder nO = new newOrder();
	    if(nO.newOrder(User.getUsername(), coursename, price)){
	    	System.out.println("订单添加成功");
	    	response.sendRedirect("chinesecourses.jsp");
	    }else{
	    	response.sendRedirect("index.jsp");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
