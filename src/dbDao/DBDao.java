package dbDao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBDao {
	public static final String url = "jdbc:mysql://127.0.0.1/datamanage?useUnicode=true&characterEncoding=utf-8&useSSL=false";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "darin";  
    public static final String password = "qwertyuiop";  
    
    public ResultSet ret=null;
    public Connection conn = null;  
    public PreparedStatement pst = null;  
	public void init(){
		try {  
			Class.forName(name);//指定连接类型  
			conn = DriverManager.getConnection(url, user, password);//获取连接  
		} 	catch (Exception e) 	{  
			e.printStackTrace();  
    	}  
	}
	
	public void close(){
		 try {  
	            this.conn.close();  
	            this.pst.close();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	}
}
