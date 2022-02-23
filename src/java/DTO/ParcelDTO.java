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
public class ParcelDTO
{

    private int parcelID;
    private int senderID;
    private String businessName;
    private String recipientName;
    private String SenderEmail;
    private String recipientEmail;
    private String description;
    private String dimensions;
    private String address;
    private String postcode;
    private String trackingCode;
    private String deliveryStatus;
    Date deliveryDate;

    public ParcelDTO(int parcelID, int senderID, String businessName, String recipientName, String SenderEmail, String recipientEmail, String description, String dimensions, String address, String postcode, String trackingCode, String deliveryStatus, Date deliveryDate)
    {
        this.parcelID = parcelID;
        this.senderID = senderID;
        this.businessName = businessName;
        this.recipientName = recipientName;
        this.SenderEmail = SenderEmail;
        this.recipientEmail = recipientEmail;
        this.description = description;
        this.dimensions = dimensions;
        this.address = address;
        this.postcode = postcode;
        this.trackingCode = trackingCode;
        this.deliveryStatus = deliveryStatus;
        this.deliveryDate = deliveryDate;
    }

    public int getSenderID()
    {
        return senderID;
    }

    public String getDeliveryStatus()
    {
        return deliveryStatus;
    }

    public Date getDeliveryDate()
    {
        return deliveryDate;
    }

    public int getParcelID()
    {
        return parcelID;
    }

    public void setParcelID(int parcelID)
    {
        this.parcelID = parcelID;
    }

    public String getBusinessName()
    {
        return businessName;
    }

    public String getRecipientName()
    {
        return recipientName;
    }

    public String getSenderEmail()
    {
        return SenderEmail;
    }

    public String getRecipientEmail()
    {
        return recipientEmail;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDimensions()
    {
        return dimensions;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public String getTrackingCode()
    {
        return trackingCode;
    }

}
