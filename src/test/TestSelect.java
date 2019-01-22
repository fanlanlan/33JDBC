package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelect {

	
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
				String selectsql="select * from scores where studentid=1";
				//发送sql
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(selectsql);
				//处理结果
				while(rs.next()){
					int studentid = rs.getInt("studentid");
					String studentname = rs.getString("coursename");
					int score = rs.getInt("score");
					System.out.println(studentid+studentname+score);
				}
				//关闭资源
				stm.close();
				conn.close();
	}

}
