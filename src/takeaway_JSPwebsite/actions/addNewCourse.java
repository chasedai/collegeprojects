package takeaway_JSPwebsite.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import takeaway_JSPwebsite.dao.addCoursetoDB;
import takeaway_JSPwebsite.models.course;

/**
 * Servlet implementation class addNewCourse
 */
@WebServlet("/addNewCourse")
public class addNewCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNewCourse() {
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
		String courseName = request.getParameter("courseName");
		String courseType = request.getParameter("courseType");
		String courseDescription = request.getParameter("courseDescription");
		String coursePrice = request.getParameter("coursePrice");
		addCoursetoDB aCDB = new addCoursetoDB();
		if(aCDB.newCourse(courseName, courseType, courseDescription, coursePrice)){
			System.out.println("successfully add new course");
			response.sendRedirect("admin/admin_index.jsp");
		}else{
			System.out.println("not successfully add new course");
		}
	}

}
