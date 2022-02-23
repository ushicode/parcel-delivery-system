/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DeliveryUI.DeliveryCommandFactory;
import javax.inject.Named;
import DTO.ParcelDTO;
import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named(value = "SetDeliveryStatusMB")
@SessionScoped
public class SetDeliveryStatusMB implements Serializable
{

    private String TrackingCode;
    private String deliveryStatus = null;
    String stringDate = null;
    // private Date date = null;
    java.util.Date date = new java.util.Date();
    java.sql.Date sDate = convertUtilToSql(date);
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    private static java.sql.Date convertUtilToSql(java.util.Date date)
    {
        java.sql.Date sDate = new java.sql.Date(date.getTime());
        return sDate;
    }

    public String setDeliveryStatus(HttpServletRequest request)
    {
        boolean deliverySet = false;
        //String str = "2001-05-10";

        HttpSession session = request.getSession();
        TrackingCode = (String) session.getAttribute("trackingCode");

        ParcelDTO setDeliveryStatus
                = new ParcelDTO(
                        0,
                        0,
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        TrackingCode,
                        deliveryStatus,
                        sDate);

        deliverySet
                = (boolean) DeliveryCommandFactory
                        .createCommand(
                                DeliveryCommandFactory.SET_DELIVERY,
                                setDeliveryStatus, request)
                        .execute();

        if (deliverySet == false)
        {
            deliveryStatus = null;
            stringDate = null;
            date = null;
        }

        return deliverySet ? "recipientViewParcel.xhtml" : "";

    }

    public String getTrackingCode()
    {
        return TrackingCode;
    }

    public void setTrackingCode(String TrackingCode)
    {
        this.TrackingCode = TrackingCode;
    }

    public String getDeliveryStatus()
    {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus)
    {
        this.deliveryStatus = deliveryStatus;
    }

    public String getStringDate()
    {
        return stringDate;
    }

    public void setStringDate(String stringDate)
    {
        this.stringDate = stringDate;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

}
