/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author ushi
 */
public class DeliveryDTO
{

    private int parcelID;
    private int DriverID;
    private int deliveryID;
    private String driverName;
    private String recipientName;
    private String dimensionsl;
    private String address;
    private String postcode;
    private Date deliveryDate;
    private String deliveryStatus;

    public DeliveryDTO(int parcelID, int DriverID, int deliveryID, String driverName, String recipientName, String dimensionsl, String address, String postcode, Date deliveryDate, String deliveryStatus)
    {
        this.parcelID = parcelID;
        this.DriverID = DriverID;
        this.deliveryID = deliveryID;
        this.driverName = driverName;
        this.recipientName = recipientName;
        this.dimensionsl = dimensionsl;
        this.address = address;
        this.postcode = postcode;
        this.deliveryDate = deliveryDate;
        this.deliveryStatus = deliveryStatus;
    }

    public int getParcelID()
    {
        return parcelID;
    }

    public int getDriverID()
    {
        return DriverID;
    }

    public int getDeliveryID()
    {
        return deliveryID;
    }

    public String getDriverName()
    {
        return driverName;
    }

    public String getRecipientName()
    {
        return recipientName;
    }

    public String getDimensionsl()
    {
        return dimensionsl;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public Date getDeliveryDate()
    {
        return deliveryDate;
    }

    public String getDeliveryStatus()
    {
        return deliveryStatus;
    }



  

}
