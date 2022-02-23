/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcelUI;

import DTO.ParcelDTO;
import Managers.ParcelManager;
import db.DatabaseConn;
import static db.DatabaseConn.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ushi
 */
public class UT16 extends DatabaseConn
{

    Connection conn;
    boolean registerOK = false;
    boolean updateOK = false;

    String dte = "2001-01-01";
    Date date = Date.valueOf(dte);
    ParcelDTO parcelDTO = new ParcelDTO(107, 1, "JDAirsoft", null, "jdairsoft@gmail.com", "just4Pual@gmail.com",
            "Tm Recoil", "10x10x10", "55 field road", "B867YK", "6797Jhgf97lO", "Delivery", date);
    ParcelDTO parcelDTOnew = new ParcelDTO(107, 1, "JDAirsoft", "Pual Collins", "jdairsoft@gmail.com", "just4Pual@gmail.com",
            "Tm Recoil", "10x10x10", "55 field road", "B867YK", "6797Jhgf97lO", "Delivery", date);

    public UT16() throws SQLException
    {
        this.conn = getConnection();
    }

    @Test
    public void RegisterParcel() throws SQLException
    {

        ParcelManager result;
        result = new ParcelManager();
        result.registerParcel(parcelDTO);

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO PARCELS (SENDERID, SENDERBUSINESSNAME, SENDEREMAIL, RECIPIENTNAME, RECIPIENTEMAIL, "
                + "DESCRIPTION, DIMENSIONS, TRACKINGCODE, ADDRESS, POSTCODE, DELIVERYSTATUS, DELIVERYDATE)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        stmt.setInt(1, parcelDTO.getSenderID());
        stmt.setString(2, parcelDTO.getBusinessName());
        stmt.setString(3, parcelDTO.getSenderEmail());
        stmt.setString(4, parcelDTO.getRecipientName());
        stmt.setString(5, parcelDTO.getRecipientEmail());
        stmt.setString(6, parcelDTO.getDescription());
        stmt.setString(7, parcelDTO.getDimensions());
        stmt.setString(8, parcelDTO.getTrackingCode());
        stmt.setString(9, parcelDTO.getAddress());
        stmt.setString(10, parcelDTO.getPostcode());
        stmt.setString(11, parcelDTO.getDeliveryStatus());
        stmt.setDate(12, parcelDTO.getDeliveryDate());
        int rows = stmt.executeUpdate();

        registerOK = rows == 1;

        UpdateParcel();
        assertNotNull(registerOK);

    }

    @Test
    public void UpdateParcel() throws SQLException
    {

        if (!parcelDTOnew.getRecipientName().isEmpty())
        {
            PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET RECIPIENTNAME = ? WHERE PARCELID = ?");
            stmt.setString(1, parcelDTOnew.getRecipientName());
            stmt.setInt(2, parcelDTOnew.getParcelID());
            int rows = stmt.executeUpdate();
            updateOK = rows == 1;
            stmt.close();
        }

        if (!parcelDTOnew.getRecipientEmail().isEmpty())
        {
            PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET RECIPIENTEMAIL = ? WHERE PARCELID = ?");
            stmt.setString(1, parcelDTOnew.getRecipientEmail());
            stmt.setInt(2, parcelDTOnew.getParcelID());
            int rows = stmt.executeUpdate();
            updateOK = rows == 1;
            stmt.close();
        }

        if (!parcelDTOnew.getAddress().isEmpty())
        {
            PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET ADDRESS = ? WHERE PARCELID = ?");
            stmt.setString(1, parcelDTOnew.getAddress());
            stmt.setInt(2, parcelDTOnew.getParcelID());
            int rows = stmt.executeUpdate();
            updateOK = rows == 1;
            stmt.close();
        }

        if (!parcelDTOnew.getPostcode().isEmpty())
        {
            PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET POSTCODE = ? WHERE PARCELID = ?");
            stmt.setString(1, parcelDTOnew.getPostcode());
            stmt.setInt(2, parcelDTOnew.getParcelID());
            int rows = stmt.executeUpdate();
            updateOK = rows == 1;
            stmt.close();
        }

        if (!parcelDTOnew.getDescription().isEmpty())
        {
            PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET DESCRIPTION =? WHERE PARCELID = ?");
            stmt.setString(1, parcelDTOnew.getDescription());
            stmt.setInt(2, parcelDTOnew.getParcelID());
            int rows = stmt.executeUpdate();
            updateOK = rows == 1;
            stmt.close();
        }

        if (!parcelDTOnew.getDimensions().isEmpty())
        {
            PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET DIMENSIONS =? WHERE PARCELID = ?");
            stmt.setString(1, parcelDTOnew.getDimensions());
            stmt.setInt(2, parcelDTOnew.getParcelID());
            int rows = stmt.executeUpdate();
            updateOK = rows == 1;
            stmt.close();
        }
        assertFalse(updateOK);
        conn.close();

    }

}
