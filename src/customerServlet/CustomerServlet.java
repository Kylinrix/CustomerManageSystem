package customerServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import dbDao.DBService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import customerBean.CustomerBean;

//@WebServlet(name="CustomerServlet", urlPatterns={"/*"})  
public class CustomerServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		
		
		if(request.getParameter("submitType").equals("addCustomer")){
			try {
				addCustomer(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(request.getParameter("submitType").equals("deleteCustomer")){
			try {
				deleteCustomer(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(request.getParameter("submitType").equals("updateCustomer")){
			try {
				updateCustomer(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(request.getParameter("submitType").equals("showAllCustomer")){
			try {
				showAllCustomer(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(request.getParameter("submitType").equals("sendCustomerToEdit"))
			sendCustomerToEdit(request,response);
		else {
				System.out.println("submitType error");
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
		
	}
	
	public void addCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		 
		CustomerBean customer = CommonUtils.toBean(request.getParameterMap(), CustomerBean.class);
		 customer.setName(request.getParameter("name"));
		 System.out.println(customer.getName());
		 customer.setUuid(CommonUtils.uuid());
		 DBService dbsv=new DBService();
		 String msg=dbsv.addCustomer(customer);
		 
		 request.setAttribute("msg", msg);
		 request.getRequestDispatcher("CustomerManage.jsp").forward(request, response);
	}
	
	public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		CustomerBean customer = CommonUtils.toBean(request.getParameterMap(), CustomerBean.class);
		 DBService dbsv=new DBService();
		 String msg=dbsv.deleteCustomer(customer);
		 
		 request.setAttribute("msg", msg);
		 request.getRequestDispatcher("CustomerManage.jsp").forward(request, response);
	}
	
	
	public void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		CustomerBean customer = CommonUtils.toBean(request.getParameterMap(), CustomerBean.class);
		DBService dbsv=new DBService();
		 String msg=dbsv.updateCustomer(customer);
		 System.out.println(customer.getId()+" "+customer.getName()+" "+customer.getSex()+" "+customer.getPhone()+" "+" "+customer.getEmail()+" "+customer.getDescription());
		 request.setAttribute("msg", msg);
		 request.getRequestDispatcher("CustomerManage.jsp").forward(request, response);
	}
	
	public void showAllCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		DBService dbsv=new DBService();
		ArrayList<CustomerBean> custlist=dbsv.showAllCustomer();
		 JSONArray custJson=JSONArray.fromObject(custlist);
		 
		 request.setAttribute("custJson", custJson);
		 request.getRequestDispatcher("CustomerManage.jsp").forward(request, response);
	}
	
public void sendCustomerToEdit(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
		
		CustomerBean customer = CommonUtils.toBean(request.getParameterMap(), CustomerBean.class);
		 request.setAttribute("customer", customer);
		 request.getRequestDispatcher("CustomerEdit.jsp").forward(request, response);
	}
	
}
