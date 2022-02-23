/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DTO.DriverDTO;
import db.DatabaseConn;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ushi
 */
public class DriverManager extends DatabaseConn
{

    String driverEmail;
    String name = "";
    int driverID = 0;

    private HttpServletRequest request;

    public DriverManager(HttpServletRequest request)
    {
        this.request = request;
    }

    public boolean registerDriver(DriverDTO driver)
    {
        boolean registerOK = false;
        try
        {
            Connection conn = DatabaseConn.getConnection();

            PreparedStatement stmtCheck = conn.prepareStatement("SELECT EMAIL FROM DRIVERS WHERE EMAIL =?");
            stmtCheck.setString(1, driver.getEmail());
            ResultSet rs = stmtCheck.executeQuery();
            if (!rs.next())
            {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO DRIVERS (NAME, EMAIL, ADDRESS, POSTCODE, PASSWORD)"
                        + "VALUES (?, ?, ?, ?, ?)");
                stmt.setString(1, driver.getName());
                stmt.setString(2, driver.getEmail());
                stmt.setString(3, driver.getAddress());
                stmt.setString(4, driver.getPostcode());
                stmt.setString(5, driver.getPassword());
                int rows = stmt.executeUpdate();

                registerOK = rows == 1;
                stmt.close();
            }
            else
            {

            }
            stmtCheck.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
        return registerOK;
    }

    public boolean loginDriver(DriverDTO driver)
    {
        String password = "";
        try
        {
            Connection conn = DatabaseConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM DRIVERS WHERE EMAIL =?");
            stmt.setString(1, driver.getEmail());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                password = rs.getString("PASSWORD");
                name = rs.getString("NAME");
                driverID = rs.getInt("DRIVERID");

                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                session.setAttribute("driverID", driverID);
                               
            }
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
        return password.equals(driver.getPassword());
    }

    public String logoutDriver(DriverDTO driver)
    {
        driver = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try
        {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }
        catch (IOException ex)
        {
            Logger.getLogger(SenderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index.xhtml";
    }
}
