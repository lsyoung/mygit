package com.yedam.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.emp.EmployeeVO;

/**
 * Servlet implementation class GetJsonServlet
 */
@WebServlet("/GetJsonServlet")
public class GetJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetJsonServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmployees();

		Gson gson = new GsonBuilder().create();

		System.out.println(gson.toJson(list).toString());// 콘솔
		// System.out.println(sb.toString());// 콘솔 출력
		response.getWriter().print(gson.toJson(list).toString());// 웹출력
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");

		String empId = request.getParameter("empId");
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String email = request.getParameter("mail");
		String hireDate = request.getParameter("hDate");
		String jobId = request.getParameter("job");
		String salary = request.getParameter("sal");

		System.out.println("fname: " + firstName);
		System.out.println("lname: " + lastName);
		System.out.println("empId: " + empId);

		EmpDAO dao = new EmpDAO();

		EmployeeVO vo = new EmployeeVO();
		vo.setEmployeeId(Integer.parseInt(empId));
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		vo.setEmail(email);
		vo.setJobId(jobId);
		vo.setHireDate(hireDate);
		if (!cmd.equals("delete"))
			vo.setSalary(Integer.parseInt(salary));

		if (cmd.equals("insert")) {

			// 처리결과 페이지에 출력
			if (dao.insertEmp(vo)) {

				JSONObject innerObj = new JSONObject();
				innerObj.put("employeeId", vo.getEmployeeId());
				innerObj.put("firstName", vo.getFirstName());
				innerObj.put("lastName", vo.getLastName());
				innerObj.put("email", vo.getEmail());
				innerObj.put("hireDate", vo.getHireDate());
				innerObj.put("salary", vo.getSalary());

				JSONObject obj = new JSONObject();
				obj.put("retCode", "Success");
				obj.put("retVal", innerObj);

				response.getWriter().println(obj);

				// response.getWriter().print("{\"retCode\":\"Success\"}");
			} else {

				JSONObject err = new JSONObject();
				err.put("retCode", "fail");
				err.put("retVal", "처리중 에러발생");

				response.getWriter().println(err);
				// response.getWriter().print("{\"retCode\":\"Fail\"}");
			}
		} else if (cmd.equals("update")) {

			if (dao.updateEmployee(vo) != null) {
				JSONObject innerObj = new JSONObject();
				innerObj.put("employeeId", vo.getEmployeeId());
				innerObj.put("firstName", vo.getFirstName());
				innerObj.put("lastName", vo.getLastName());
				innerObj.put("email", vo.getEmail());
				innerObj.put("hireDate", vo.getHireDate());
				innerObj.put("salary", vo.getSalary());

				JSONObject obj = new JSONObject();
				obj.put("retCode", "Success");
				obj.put("retVal", innerObj);

				response.getWriter().println(obj);

				// response.getWriter().print("{\"retCode\":\"Success\"}");
			} else {

				JSONObject err = new JSONObject();
				err.put("retCode", "fail");
				err.put("retVal", "처리중 에러발생");

				response.getWriter().println(err);
				//response.getWriter().print("{\"retCode\":\"Fail\"}");
			}

		} else if (cmd.equals("delete")) {
			if (dao.deleteEmployee(empId)) {
				response.getWriter().print("{\"retCode\":\"Success\"}");
			} else {
				response.getWriter().print("{\"retCode\":\"Fail\"}");
			}

		}

	}

}
