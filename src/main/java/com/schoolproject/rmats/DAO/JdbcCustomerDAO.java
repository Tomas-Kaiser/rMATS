package com.schoolproject.rmats.DAO;

import com.schoolproject.rmats.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;

public class JdbcCustomerDAO implements CustomerDAO {

    @Override
    public Customer getCustomerByEmail(String email){
        String url = "jdbc:mysql://localhost:3306/sql_rmats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String uname = "root";
        String pass = "password1234";
        Connection con = null;

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, uname, pass);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email = ?");
            ps.setString(1, email);

            Customer customer = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                customer = new Customer(
                        rs.getInt(1),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(4),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                        );
            }

            rs.close();
            ps.close();

            return customer;
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e){}
        }
    }
}
