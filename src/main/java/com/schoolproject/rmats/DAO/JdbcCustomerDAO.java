package com.schoolproject.rmats.DAO;
import com.schoolproject.rmats.model.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcCustomerDAO implements CustomerDAO {
    private String url = "jdbc:mysql://localhost:3306/sql_rmats?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String uname = "root";
    private String pass = "password1234";
    private Connection con = null;
    private String driver = "com.mysql.cj.jdbc.Driver";

    @Override
    public Customer getCustomerByEmail(String email){
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, uname, pass);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email = ?");
            ps.setString(1, email);

            Customer customer = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int addressId = rs.getInt("address_id");
                Address address = getAddress(addressId);
                int customerId = rs.getInt("user_id");
                List<Ticket> ticketList = getTickets(customerId);

                customer = new Customer(
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("company_name"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getString("user_password"),
                        rs.getInt("enabled"),
                        address,
                        ticketList
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

    private Address getAddress(int addressId) {
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, uname, pass);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM addresses WHERE address_id = ?");
            ps.setInt(1, addressId);

            Address address = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                address = new Address(
                        addressId,
                        rs.getString("street"),
                        rs.getString("zip_code"),
                        rs.getString("city"),
                        rs.getString("country")
                );
            }

            rs.close();
            ps.close();

            return address;

        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e){}
        }
    }

    private List<Ticket> getTickets(int customerId){
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, uname, pass);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tickets WHERE user_id = ?");
            ps.setInt(1, customerId);

            FaultyUnit faultyUnit = null;
            ReplacementUnit replacementUnit = null;
            List<Ticket> ticketList = new ArrayList<>();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                faultyUnit = getFaultyUnit(rs.getInt("faulty_id"));
                replacementUnit = getReplacementUnit(rs.getInt("replacement_id"));
                Ticket ticket;
                ticket = new Ticket(
                        rs.getInt("ticket_id"),
                        rs.getDate("raise_date"),
                        rs.getString("cust_comment"),
                        faultyUnit,
                        replacementUnit
                );
                ticketList.add(ticket);
            }

            rs.close();
            ps.close();

            return ticketList;

        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e){}
        }
    }

    private FaultyUnit getFaultyUnit(int faultyId) {
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, uname, pass);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM faulties WHERE faulty_id = ?");
            ps.setInt(1, faultyId);

            FaultyUnit faultyUnit = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                faultyUnit = new FaultyUnit(
                        faultyId,
                        rs.getString("model"),
                        rs.getString("serial_number")
                );
            }

            rs.close();
            ps.close();

            return faultyUnit;

        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e){}
        }
    }

    private ReplacementUnit getReplacementUnit(int replacementId){
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, uname, pass);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM replacements WHERE replacement_id = ?");
            ps.setInt(1, replacementId);

            ReplacementUnit replacementUnit = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                replacementUnit = new ReplacementUnit(
                        replacementId,
                        rs.getInt("isProcessed"),
                        rs.getString("current_status"),
                        rs.getString("carrier"),
                        rs.getString("tracking_number"),
                        rs.getString("model"),
                        rs.getString("new_serial_number"),
                        rs.getString("shipper_comment")
                );
            }

            rs.close();
            ps.close();

            return replacementUnit;

        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e){}
        }
    }
}
