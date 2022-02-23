/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DTO.ParcelDTO;
import DTO.SenderDTO;
import db.DatabaseConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author ushi
 */
public class ParcelManager extends DatabaseConn
{

    public boolean registerParcel(ParcelDTO parcel)
    {
        boolean registerOK = false;
        try
        {
            Connection conn = DatabaseConn.getConnection();
            PreparedStatement stmtCheck = conn.prepareStatement("SELECT TRACKINGCODE FROM PARCELS WHERE TRACKINGCODE =?");
            stmtCheck.setString(1, parcel.getTrackingCode());
            ResultSet rs = stmtCheck.executeQuery();

            if (!rs.next())
            {

                PreparedStatement stmt = conn.prepareStatement("INSERT INTO PARCELS (SENDERID, SENDERBUSINESSNAME, SENDEREMAIL, RECIPIENTNAME, RECIPIENTEMAIL, "
                        + "DESCRIPTION, DIMENSIONS, TRACKINGCODE, ADDRESS, POSTCODE, DELIVERYSTATUS, DELIVERYDATE)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                stmt.setInt(1, parcel.getSenderID());
                stmt.setString(2, parcel.getBusinessName());
                stmt.setString(3, parcel.getSenderEmail());
                stmt.setString(4, parcel.getRecipientName());
                stmt.setString(5, parcel.getRecipientEmail());
                stmt.setString(6, parcel.getDescription());
                stmt.setString(7, parcel.getDimensions());
                stmt.setString(8, parcel.getTrackingCode());
                stmt.setString(9, parcel.getAddress());
                stmt.setString(10, parcel.getPostcode());
                stmt.setString(11, parcel.getDeliveryStatus());
                stmt.setDate(12, parcel.getDeliveryDate());
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

    public boolean updateParcel(ParcelDTO parcel)
    {
        boolean updateOK = false;
        try
        {
            Connection conn = DatabaseConn.getConnection();

            if (!parcel.getRecipientName().isEmpty())
            {
                PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET RECIPIENTNAME = ? WHERE PARCELID = ?");
                stmt.setString(1, parcel.getRecipientName());
                stmt.setInt(2, parcel.getParcelID());
                int rows = stmt.executeUpdate();
                updateOK = rows == 1;
                stmt.close();
            }

            if (!parcel.getRecipientEmail().isEmpty())
            {
                PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET RECIPIENTEMAIL = ? WHERE PARCELID = ?");
                stmt.setString(1, parcel.getRecipientEmail());
                stmt.setInt(2, parcel.getParcelID());
                int rows = stmt.executeUpdate();
                updateOK = rows == 1;
                stmt.close();
            }

            if (!parcel.getAddress().isEmpty())
            {
                PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET ADDRESS = ? WHERE PARCELID = ?");
                stmt.setString(1, parcel.getAddress());
                stmt.setInt(2, parcel.getParcelID());
                int rows = stmt.executeUpdate();
                updateOK = rows == 1;
                stmt.close();
            }

            if (!parcel.getPostcode().isEmpty())
            {
                PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET POSTCODE = ? WHERE PARCELID = ?");
                stmt.setString(1, parcel.getPostcode());
                stmt.setInt(2, parcel.getParcelID());
                int rows = stmt.executeUpdate();
                updateOK = rows == 1;
                stmt.close();
            }

            if (!parcel.getDescription().isEmpty())
            {
                PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET DESCRIPTION =? WHERE PARCELID = ?");
                stmt.setString(1, parcel.getDescription());
                stmt.setInt(2, parcel.getParcelID());
                int rows = stmt.executeUpdate();
                updateOK = rows == 1;
                stmt.close();
            }

            if (!parcel.getDimensions().isEmpty())
            {
                PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET DIMENSIONS =? WHERE PARCELID = ?");
                stmt.setString(1, parcel.getDimensions());
                stmt.setInt(2, parcel.getParcelID());
                int rows = stmt.executeUpdate();
                updateOK = rows == 1;
                stmt.close();
            }
            conn.close();

        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }

        return updateOK;
    }

    public boolean deleteParcel(ParcelDTO parcel)
    {
        boolean deleteOK = false;
        try
        {
            Connection conn = DatabaseConn.getConnection();

            if (parcel.getParcelID() != 0)
            {
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM PARCELS WHERE PARCELID = ?");
                stmt.setInt(1, parcel.getParcelID());
                int rows = stmt.executeUpdate();

                deleteOK = rows == -1;

                stmt.close();
            }
            conn.close();

        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }

        return deleteOK;
    }

    public ArrayList<ParcelDTO> getParcelSummeries(String senderEmail)
    {

        ArrayList<ParcelDTO> parcelSummeries = new ArrayList<>();
        try
        {

            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PARCELS WHERE SENDEREMAIL = ? ORDER BY PARCELID ASC");
            stmt.setString(1, senderEmail);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                ParcelDTO par = new ParcelDTO(rs.getInt("PARCELID"), rs.getInt("SENDERID"), rs.getString("SENDERBUSINESSNAME"), rs.getString("RECIPIENTNAME"), rs.getString("SENDEREMAIL"), rs.getString("RECIPIENTEMAIL"),
                        rs.getString("DESCRIPTION"), rs.getString("DIMENSIONS"), rs.getString("ADDRESS"), rs.getString("POSTCODE"), rs.getString("TRACKINGCODE"), rs.getString("DELIVERYSTATUS"), rs.getDate("DELIVERYDATE"));
                parcelSummeries.add(par);
            }

            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
        }
        return parcelSummeries;
    }
}
