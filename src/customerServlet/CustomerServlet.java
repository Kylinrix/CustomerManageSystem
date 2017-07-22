package customerServlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
		
		
		setUTF8Code(request,response);
		
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
			try {
				sendCustomerToEdit(request,response);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		else if(request.getParameter("submitType").equals("advancedSearchCustomer")){
			try {
				advancedSearchCustomer(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
				System.out.println("submitType error");
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
		
	}
	
	//设置浏览器请求与回应处理为UTF-8编码，适应中文输入输出。
	public void setUTF8Code(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
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
	
	
	//此处将 管理页面编辑链接数据 传给 编辑页面。
	public void sendCustomerToEdit(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException, SQLException{
		CustomerBean customerindex = CommonUtils.toBean(request.getParameterMap(), CustomerBean.class);
		DBService dbsv=new DBService();
		CustomerBean customer=dbsv.searchCustomerById(customerindex);
		 request.setAttribute("customerEdit", customer);
		 request.getRequestDispatcher("CustomerEdit.jsp").forward(request, response);
	}
	
	public void advancedSearchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		if((request.getParameter("name").equals(""))&&(request.getParameter("sex").equals(""))&&(request.getParameter("phone").equals(""))){
			request.setAttribute("advancedSearchErrorMessage", "搜索条件为空！");
			request.getRequestDispatcher("advancedSearchCustomer.jsp").forward(request, response);
		}
		
		CustomerBean customersearch = CommonUtils.toBean(request.getParameterMap(), CustomerBean.class);
		DBService dbsv=new DBService();
		
		ArrayList<CustomerBean> custlist=dbsv.advancedSearchCustomer(customersearch);
		
		if(custlist.isEmpty()){
			request.setAttribute("advancedSearchErrorMessage", "搜索结果为空！");
		}
		 JSONArray advancedSearchCustomerJson=JSONArray.fromObject(custlist);
		 
		 request.setAttribute("advancedSearchCustomerJson", advancedSearchCustomerJson);
		 request.getRequestDispatcher("advancedSearchCustomer.jsp").forward(request, response);
	}
	
}
