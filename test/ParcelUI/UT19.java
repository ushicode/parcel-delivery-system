/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcelUI;

import DTO.SenderDTO;
import Managers.SenderManager;
import db.DatabaseConn;
import static db.DatabaseConn.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author ushi
 */
public class UT19 extends DatabaseConn
{

    HttpServletRequest request = mock(HttpServletRequest.class);

    Connection conn;
    boolean registerOK = false;
    boolean updateOK = false;
    String senderEmail;
    String businessName = "";
    int senderID;
    String password;

    String dte = "2001-01-01";
    Date date = Date.valueOf(dte);
    SenderDTO senderDTO
            = new SenderDTO(
                    null,
                    "test@gmail.com",
                    "test",
                    "test",
                    "test",
                    "test");

    SenderDTO senderDTOnew
            = new SenderDTO(
                    "test",
                    "test@gmail.com",
                    "test",
                    "test",
                    "test",
                    "test");

    public UT19() throws SQLException
    {
        this.conn = getConnection();
    }

    @Test
    public void RegisterSender() throws SQLException
    {

        SenderManager result;
        result = new SenderManager(request);
        result.registerSender(senderDTO);

        PreparedStatement stmtCheck = conn.prepareStatement("SELECT EMAIL FROM SENDERS WHERE EMAIL =?");
        stmtCheck.setString(1, senderDTO.getEmail());
        ResultSet rs = stmtCheck.executeQuery();
        if (!rs.next())
        {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO SENDERS (BUSINESSNAME, EMAIL, ADDRESS, POSTCODE, PASSWORD)"
                    + "VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, senderDTO.getBusinessName());
            stmt.setString(2, senderDTO.getEmail());
            stmt.setString(3, senderDTO.getAddress());
            stmt.setString(4, senderDTO.getPostcode());
            stmt.setString(5, senderDTO.getPassword());
            int rows = stmt.executeUpdate();

            registerOK = rows == 1;
            stmt.close();
        }
        else
        {

        }
        stmtCheck.close();

        LoginSender();
        assertNotNull(registerOK);
    }

    @Test
    public void LoginSender() throws SQLException
    {

        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SENDERS WHERE EMAIL =?");
        stmt.setString(1, senderDTOnew.getEmail());
        ResultSet rs = stmt.executeQuery();
        if (rs.next())
        {
            password = rs.getString("PASSWORD");
            businessName = rs.getString("BUSINESSNAME");
            senderID = rs.getInt("SenderID");
            updateOK = true;
        }
        else
        {
            updateOK = false;

        }

        assertFalse(updateOK);
        stmt.close();
        conn.close();

    }

}
