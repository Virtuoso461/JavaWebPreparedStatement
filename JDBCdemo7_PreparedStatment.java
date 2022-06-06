package com.itheima.jdbc;

import org.junit.Test;
import polo.Polo;
import java.sql.*;

public class JDBCdemo7_PreparedStatment {

   @Test
    public void test() throws Exception {

        //建立连接
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSl=false&useServerPrepStmts=true";
        String username = "root";
        String password = "13579";

        Connection con = DriverManager.getConnection(url, username, password);

        int id = 1;
        String name = "张三";

        //SQL语句
        String sql = "select * from account where id = ? and name = ?";

        //预编译
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.setString(2,name);


        //创立结果集
        ResultSet rs = pstmt.executeQuery();

        //获取执行结果
       if (rs.next()) {
           System.out.println("login successful");
       } else {
           System.out.println("login failed");
       }
       //关闭数据流
       rs.close();
       pstmt.close();
       con.close();

   }
}
