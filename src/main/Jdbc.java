package main;
import java.sql.*;

import javax.swing.JOptionPane;
public  class Jdbc {
	static String url="jdbc:mysql://localhost:3306/java?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC";
	static String root="root";
 	static String rootpass="12345";
 	static Connection conn;
 	public static void init(){
 		try {
 			Class.forName("com.mysql.cj.jdbc.Driver");
 			conn=DriverManager.getConnection(url,root,rootpass);
 		}catch(Exception e) {
 			e.printStackTrace();
 		}
 	}
 	public static void connclose() {
 		try {
 			conn.close();
 		}catch(Exception e)
 		{
 			e.printStackTrace();
 		}
 	}
	public static boolean Login(String accounts,String password) {
		try {
		//Connection conn=DriverManager.getConnection("jdbc:mysql://210.30.108.222:3306/u201712109?useSSL=false&useUnicode=true&characterEncoding=UTF8", "u201712109","u201712109");		
		PreparedStatement ps=conn.prepareStatement("select * from admin where accounts=? and password=?");
		ps.setString(1,accounts);
		ps.setString(2,password);                             
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void insert(String sqlstr) throws Exception{
			PreparedStatement ps=conn.prepareStatement(sqlstr);
			ps.execute();
			JOptionPane.showMessageDialog(null,"添加成功！","添加",JOptionPane.INFORMATION_MESSAGE);
	}
	public static void delete(String sqlstr) throws Exception{
			PreparedStatement ps=conn.prepareStatement(sqlstr);//"delete from students where number= ?"
			ps.execute();
			JOptionPane.showMessageDialog(null,"删除成功！","删除",JOptionPane.INFORMATION_MESSAGE);
	}
	public static void update(String sqlstr) throws Exception{
			PreparedStatement ps=conn.prepareStatement(sqlstr);//"delete from students where number= ?"
			ps.execute();
			JOptionPane.showMessageDialog(null,"修改成功！","修改",JOptionPane.INFORMATION_MESSAGE);
	}
	public static ResultSet select(String sqlstr) throws Exception{
			PreparedStatement ps=conn.prepareStatement(sqlstr);//"select from students where name=? and pass=?"
			ResultSet rs=ps.executeQuery();
			return rs;
	}
	
}
