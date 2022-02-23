/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DTO.SenderDTO;
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
public class SenderManager extends DatabaseConn
{

    String senderEmail;
    String businessName = "";
    int senderID = 0;
    private boolean credentialsOK = false;

    private HttpServletRequest request;

    public SenderManager(HttpServletRequest request)
    {
        this.request = request;
    }

    public String SenderDetails(SenderDTO sender)
    {
        try
        {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT EMAIL FROM SENDERS WHERE EMAIL =?");

            senderEmail = sender.getEmail();

            stmt.setString(1, senderEmail);
            stmt.executeQuery();

            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
        }
        return senderEmail;
    }

    public boolean registerSender(SenderDTO sender)
    {
        boolean registerOK = false;
        try
        {
            Connection conn = DatabaseConn.getConnection();

            PreparedStatement stmtCheck = conn.prepareStatement("SELECT EMAIL FROM SENDERS WHERE EMAIL =?");
            stmtCheck.setString(1, sender.getEmail());
            ResultSet rs = stmtCheck.executeQuery();
            if (!rs.next())
            {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO SENDERS (BUSINESSNAME, EMAIL, ADDRESS, POSTCODE, PASSWORD)"
                        + "VALUES (?, ?, ?, ?, ?)");
                stmt.setString(1, sender.getBusinessName());
                stmt.setString(2, sender.getEmail());
                stmt.setString(3, sender.getAddress());
                stmt.setString(4, sender.getPostcode());
                stmt.setString(5, sender.getPassword());
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

    public boolean loginSender(SenderDTO sender)
    {
        String password = "";
        try
        {
            Connection conn = DatabaseConn.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SENDERS WHERE EMAIL =?");
            stmt.setString(1, sender.getEmail());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                password = rs.getString("PASSWORD");
                businessName = rs.getString("BUSINESSNAME");
                senderID = rs.getInt("SenderID");

                HttpSession session = request.getSession();
                session.setAttribute("businessName", businessName);
                session.setAttribute("senderID", senderID);

            }

            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
        return password.equals(sender.getPassword());
    }

    public String logoutSender(SenderDTO sender)
    {
        sender = null;
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
