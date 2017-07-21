package dbDao;

import java.sql.SQLException;
import java.util.ArrayList;

import customerBean.CustomerBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DBService {
	private DBDao dbconnect = new DBDao();
	
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
	
	
}
