package takeaway_JSPwebsite.models;

public class course {

	private String courseName;
	private String courseType;
	private String courseDescription;
	private String coursePrice;

	public course(String courseName, String courseType,
			String courseDescription, String coursePrice) {
		super();
		this.courseName = courseName;
		this.courseType = courseType;
		this.courseDescription = courseDescription;
		this.coursePrice = coursePrice;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}

}
