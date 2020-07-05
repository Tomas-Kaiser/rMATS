package com.schoolproject.rmats.DB.Dao;


import java.sql.*;

public class JdbcDaoImpl {
    public Alian getAlian(int id){
        String url = "jdbc:mysql://localhost:3306/aliens?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String uname = "root";
        String pass = "password1234";
        Connection con = null;

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, uname, pass);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE userId = ?");
            ps.setInt(1, id);

            Alian alian = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alian = new Alian(rs.getInt(1), rs.getString(2));
            }

            rs.close();
            ps.close();

            return alian;
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e){}
        }
    }
}
