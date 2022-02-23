/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DTO.ParcelDTO;
import DTO.DeliveryDTO;
import db.DatabaseConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ushi
 */
public class DeliveryManager extends DatabaseConn
{

    private HttpServletRequest request;

    public DeliveryManager(HttpServletRequest request)
    {
        this.request = request;
    }

    public ArrayList<ParcelDTO> getMyParcel(String trackingCode)
    {

        ArrayList<ParcelDTO> deliverySummeries = new ArrayList<>();
        try
        {

            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PARCELS WHERE TRACKINGCODE = ?");
            stmt.setString(1, trackingCode);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                ParcelDTO del = new ParcelDTO(rs.getInt("PARCELID"), rs.getInt("SENDERID"), rs.getString("SENDERBUSINESSNAME"), rs.getString("RECIPIENTNAME"), rs.getString("SENDEREMAIL"), rs.getString("RECIPIENTEMAIL"),
                        rs.getString("DESCRIPTION"), rs.getString("DIMENSIONS"), rs.getString("ADDRESS"), rs.getString("POSTCODE"), rs.getString("TRACKINGCODE"), rs.getString("DELIVERYSTATUS"), rs.getDate("DELIVERYDATE"));
                deliverySummeries.add(del);
            }

            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
        }
        return deliverySummeries;
    }

    public boolean setDeliveryPreference(ParcelDTO parcel)
    {
        boolean setDeliveryOK = false;
        try
        {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET DELIVERYSTATUS =?, DELIVERYDATE = ? WHERE TRACKINGCODE = ?");
            stmt.setString(1, parcel.getDeliveryStatus());
            stmt.setDate(2, parcel.getDeliveryDate());
            stmt.setString(3, parcel.getTrackingCode());
            int rows = stmt.executeUpdate();
            setDeliveryOK = rows == 1;
            stmt.close();
        }
        catch (SQLException sqle)
        {
        }
        return setDeliveryOK;
    }

    public ArrayList<ParcelDTO> ViewAllParcels()
    {

        ArrayList<ParcelDTO> deliverySummeries = new ArrayList<>();
        try
        {

            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PARCELS WHERE DRIVERID IS NULL ORDER BY DELIVERYDATE ASC");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                ParcelDTO del = new ParcelDTO(rs.getInt("PARCELID"), rs.getInt("SENDERID"), rs.getString("SENDERBUSINESSNAME"), rs.getString("RECIPIENTNAME"), rs.getString("SENDEREMAIL"), rs.getString("RECIPIENTEMAIL"),
                        rs.getString("DESCRIPTION"), rs.getString("DIMENSIONS"), rs.getString("ADDRESS"), rs.getString("POSTCODE"), rs.getString("TRACKINGCODE"), rs.getString("DELIVERYSTATUS"), rs.getDate("DELIVERYDATE"));
                deliverySummeries.add(del);
            }

            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
        }
        return deliverySummeries;
    }

    public ArrayList<ParcelDTO> ViewMyDeliveries()
    {

        ArrayList<ParcelDTO> MyDeliveries = new ArrayList<>();
        try

        {
            HttpSession session = request.getSession();
            int driverID = (int) session.getAttribute("driverID");

            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PARCELS WHERE DRIVERID = ? ORDER BY DELIVERYDATE ASC");
            stmt.setInt(1, driverID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                ParcelDTO del = new ParcelDTO(rs.getInt("PARCELID"), rs.getInt("SENDERID"), rs.getString("SENDERBUSINESSNAME"), rs.getString("RECIPIENTNAME"), rs.getString("SENDEREMAIL"), rs.getString("RECIPIENTEMAIL"),
                        rs.getString("DESCRIPTION"), rs.getString("DIMENSIONS"), rs.getString("ADDRESS"), rs.getString("POSTCODE"), rs.getString("TRACKINGCODE"), rs.getString("DELIVERYSTATUS"), rs.getDate("DELIVERYDATE"));
                MyDeliveries.add(del);
            }

            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
        }
        return MyDeliveries;
    }

    public boolean setDeliveryDriver(DeliveryDTO delivery)
    {
        boolean setDriverOK = false;
        try
        {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO DELIVERIES (PARCELID, DRIVERID) VALUES (?, ?)");
            stmt.setInt(1, delivery.getParcelID());
            stmt.setInt(2, delivery.getDriverID());
            int rows = stmt.executeUpdate();

            PreparedStatement stmt2 = conn.prepareStatement("UPDATE PARCELS SET DRIVERID = ? WHERE PARCELID = ?");
            stmt2.setInt(1, delivery.getDriverID());
            stmt2.setInt(2, delivery.getParcelID());

            int rows2 = stmt2.executeUpdate();

            // setDriverOK = rows == 1;
            if (rows == 1 && rows2 == 1)
            {
                setDriverOK = true;
            }
            stmt.close();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
        return setDriverOK;
    }

    public boolean updateDeliveryStatus(ParcelDTO parcel)
    {
        boolean setDriverOK = false;
        try
        {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE PARCELS SET DELIVERYSTATUS = ? WHERE PARCELID = ?");
            stmt.setString(1, parcel.getDeliveryStatus());
            stmt.setInt(2, parcel.getParcelID());

            int rows = stmt.executeUpdate();

            stmt.close();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
        return setDriverOK;
    }
}
