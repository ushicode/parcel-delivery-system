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
public class UT17 extends DatabaseConn
{

    Connection conn;
    boolean registerOK = false;
    boolean updateOK = false;

    String dte = "2001-01-01";
    Date date = Date.valueOf(dte);
    ParcelDTO parcelDTO = new ParcelDTO(107, 1, "JDAirsoft", "Paul COllins", "jdairsoft@gmail.com", null,
            "Tm Recoil", "10x10x10", "55 field road", "B867YK", "6797Jhgf97lO", "On route", date);
    ParcelDTO parcelDTOnew = new ParcelDTO(107, 1, "JDAirsoft", "Pual Collins", "jdairsoft@gmail.com", "just4Pual@gmail.com",
            "Tm Recoil", "10x10x10", "55 field road", "B867YK", "6797Jhgf97lO", "Delivery", date);

    public UT17() throws SQLException
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

        if (!parcelDTOnew.getDeliveryStatus().isEmpty())
        {
            PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET DELIVERYSTATUS =? WHERE PARCELID = ?");
            stmt.setString(1, parcelDTOnew.getDeliveryStatus());
            stmt.setInt(2, parcelDTOnew.getParcelID());
            int rows = stmt.executeUpdate();
            updateOK = rows == 1;
            stmt.close();
        }
        assertFalse(updateOK);
        conn.close();

    }

}
