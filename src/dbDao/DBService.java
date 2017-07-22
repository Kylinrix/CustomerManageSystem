package dbDao;

import java.sql.SQLException;
import java.util.ArrayList;

import customerBean.CustomerBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DBService {
	private DBDao dbconnect = new DBDao();
	
	//添加客户
	public String addCustomer(CustomerBean cust) throws SQLException{
		
		dbconnect.init();
		dbconnect.pst=dbconnect.conn.prepareStatement("insert into customer values(null,?,?,?,?,?,?)");
		dbconnect.pst.setString(1, cust.getName());
		dbconnect.pst.setString(2, cust.getSex());
		dbconnect.pst.setString(3, cust.getPhone());
		dbconnect.pst.setString(4, cust.getEmail());
		dbconnect.pst.setString(5, cust.getDescription());
		dbconnect.pst.setString(6, cust.getUuid());
		int res=dbconnect.pst.executeUpdate();
		dbconnect.close();
		if(res>0)
			return "Add Success!";
		else
			return "Add Fail!";
	}
	
	//编辑更新客户
	public String updateCustomer(CustomerBean cust) throws SQLException{
				
		dbconnect.init();
		dbconnect.pst=dbconnect.conn.prepareStatement("update customer set name=?, sex=?, phone=?, email=? ,description=? where id=?;");
		dbconnect.pst.setString(1, cust.getName());
		dbconnect.pst.setString(2, cust.getSex());
		dbconnect.pst.setString(3, cust.getPhone());
		dbconnect.pst.setString(4, cust.getEmail());
		dbconnect.pst.setString(5, cust.getDescription());
		dbconnect.pst.setString(6, cust.getId());
		int res=dbconnect.pst.executeUpdate();
		dbconnect.close();
		if(res>0)
			return "Update Success!";
		else
			return "Update Fail!";
	}
	
	//删除客户
	public String deleteCustomer(CustomerBean cust) throws SQLException{
		dbconnect.init();
		dbconnect.pst=dbconnect.conn.prepareStatement("delete from customer where id=?");
		dbconnect.pst.setString(1, cust.getId());
		
		int res=dbconnect.pst.executeUpdate();
		dbconnect.close();
		if(res>0)
			return "delete Success!";
		else
			return "delete Fail!";
	}
	
	//显示所有用户
	public ArrayList<CustomerBean> showAllCustomer() throws SQLException{
		dbconnect.init();
		dbconnect.pst=dbconnect.conn.prepareStatement("select * from customer");
		
		dbconnect.ret=dbconnect.pst.executeQuery();
		ArrayList<CustomerBean> custlist=new ArrayList<CustomerBean>();
		while(dbconnect.ret.next()){
			CustomerBean cust=new CustomerBean ();
			cust.setId(dbconnect.ret.getString(1));
			cust.setName(dbconnect.ret.getString(2));
			cust.setSex(dbconnect.ret.getString(3));
			cust.setPhone(dbconnect.ret.getString(4));
			cust.setEmail(dbconnect.ret.getString(5));
			cust.setDescription(dbconnect.ret.getString(6));
			custlist.add(cust);
		}	
			dbconnect.close();
			
			return custlist;
	}
	
	//通过ID查找客户
	public CustomerBean searchCustomerById(CustomerBean customer) throws SQLException{
		dbconnect.init();
		dbconnect.pst=dbconnect.conn.prepareStatement("select * from customer where id=?");
		dbconnect.pst.setString(1, customer.getId());

		dbconnect.ret=dbconnect.pst.executeQuery();
		while(dbconnect.ret.next()){
			customer.setId(dbconnect.ret.getString(1));
			customer.setName(dbconnect.ret.getString(2));
			customer.setSex(dbconnect.ret.getString(3));
			customer.setPhone(dbconnect.ret.getString(4));
			customer.setEmail(dbconnect.ret.getString(5));
			customer.setDescription(dbconnect.ret.getString(6));
		}	
			dbconnect.close();
			
			return customer;
	}
	
	//高级搜索
	public ArrayList<CustomerBean> advancedSearchCustomer(CustomerBean customer) throws SQLException{
		dbconnect.init();
		
		//
		if(
				(customer.getName().isEmpty())&&
				(customer.getPhone().isEmpty())&&
				(customer.getSex().isEmpty())
				
				){
			dbconnect.pst=dbconnect.conn.prepareStatement("select * from customer ");
		}
		else if(!(customer.getName().isEmpty())&&(customer.getPhone().isEmpty())&&(customer.getSex().isEmpty())){
			dbconnect.pst=dbconnect.conn.prepareStatement("select * from customer where name=? ");
			dbconnect.pst.setString(1, customer.getName());
			
		}
		else if((customer.getName().isEmpty())&&!(customer.getPhone().isEmpty())&&(customer.getSex().isEmpty())){
			dbconnect.pst=dbconnect.conn.prepareStatement("select * from customer where phone=? ");
			dbconnect.pst.setString(2, customer.getPhone());
		}
		else if((customer.getName().isEmpty())&&(customer.getPhone().isEmpty())&&!(customer.getSex().isEmpty())){
			dbconnect.pst=dbconnect.conn.prepareStatement("select * from customer where sex=? ");
			dbconnect.pst.setString(1, customer.getSex());
		}
		
		else if(!(customer.getName().isEmpty())&&!(customer.getPhone().isEmpty())&&(customer.getSex().isEmpty())){
			dbconnect.pst=dbconnect.conn.prepareStatement("select * from customer where name=? and phone=? ");
			dbconnect.pst.setString(1, customer.getName());
			dbconnect.pst.setString(1, customer.getPhone());
		}
		else if((customer.getName().isEmpty())&&!(customer.getPhone().isEmpty())&&!(customer.getSex().isEmpty())){
			dbconnect.pst=dbconnect.conn.prepareStatement("select * from customer where phone=? and sex=?");
			dbconnect.pst.setString(1, customer.getPhone());
			dbconnect.pst.setString(2, customer.getSex());
		}
		else if(!(customer.getName().isEmpty())&&(customer.getPhone().isEmpty())&&!(customer.getSex().isEmpty())){
			dbconnect.pst=dbconnect.conn.prepareStatement("select * from customer where name=? and sex=? ");
			dbconnect.pst.setString(1, customer.getPhone());
			dbconnect.pst.setString(2, customer.getSex());
		}
		else if(!(customer.getName().isEmpty())&&!(customer.getPhone().isEmpty())&&!(customer.getSex().isEmpty())){
			dbconnect.pst=dbconnect.conn.prepareStatement("select * from customer where name=? and phone=? and  sex=? ");
			dbconnect.pst.setString(1, customer.getName());
			dbconnect.pst.setString(2, customer.getPhone());
			dbconnect.pst.setString(3, customer.getSex());
		}
		
		dbconnect.ret=dbconnect.pst.executeQuery();
		ArrayList<CustomerBean> custlist=new ArrayList<CustomerBean>();
		while(dbconnect.ret.next()){
			CustomerBean cust=new CustomerBean ();
			cust.setId(dbconnect.ret.getString(1));
			cust.setName(dbconnect.ret.getString(2));
			cust.setSex(dbconnect.ret.getString(3));
			cust.setPhone(dbconnect.ret.getString(4));
			cust.setEmail(dbconnect.ret.getString(5));
			cust.setDescription(dbconnect.ret.getString(6));
			custlist.add(cust);
		}	
			dbconnect.close();
			
			return custlist;
	}
	
	
}
