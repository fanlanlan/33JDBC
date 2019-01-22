package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {

	/**
	 * @throws Exception 
	 * 
	 */
	public static void main(String[] args) throws Exception {
		//加载驱动
		Class.forName("oracle.jdbc.OracleDriver");
		//创建连接
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String name="hr";
		String password="hr";
		Connection conn = DriverManager.getConnection(url, name, password);
		System.out.println(conn);
		//准备sql
		String updatesql="update scores set score=88 where studentid='3'";
		//发送sql
		Statement stm = conn.createStatement();
		stm.executeUpdate(updatesql);
		//处理结果
		
		//关闭资源
		stm.close();
		conn.close();
	}
}