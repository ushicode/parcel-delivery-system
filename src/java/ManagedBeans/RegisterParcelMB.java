/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import ParcelUI.ParcelCommandFactory;
import javax.inject.Named;
import DTO.ParcelDTO;
import java.sql.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named(value = "registerParcelMB")
@RequestScoped
public class RegisterParcelMB
{

    int n = 12;

    int senderID = 0;
    private String businessName;
    private String recipientName;
    private String SenderEmail;
    private String recipientEmail;
    private String description;
    private String dimensions;
    private String address;
    private String postcode;
    private String trackingCode;

    public String registerParcel(HttpServletRequest request)
    {
        boolean parcelRegistered = false;

        String AlphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringbuilder = new StringBuilder(n);

        for (int i = 0; i < n; i++)
        {
            int index = (int) (AlphaNumeric.length() * Math.random());

            stringbuilder.append(AlphaNumeric.charAt(index));
        }
        trackingCode = stringbuilder.toString();

        HttpSession session = request.getSession();
        SenderEmail = (String) session.getAttribute("senderEmail");
        senderID = (int) session.getAttribute("senderID");
        businessName = (String) session.getAttribute("businessName");

        Date date = null;

        ParcelDTO newParcel
                = new ParcelDTO(
                        0,
                        senderID,
                        businessName,
                        recipientName,
                        SenderEmail,
                        recipientEmail,
                        description,
                        dimensions,
                        address,
                        postcode,
                        trackingCode,
                        "Not Set",
                        date);

        parcelRegistered
                = (boolean) ParcelCommandFactory
                        .createCommand(
                                ParcelCommandFactory.REGISTER_PARCEL,
                                newParcel)
                        .execute();

        if (parcelRegistered == false)
        {
            businessName = null;
            recipientName = null;
            SenderEmail = null;
            recipientEmail = null;
            description = null;
            dimensions = null;
            address = null;
            postcode = null;
            trackingCode = null;
        }

        return parcelRegistered ? "myAccount.xhtml" : "";

    }

    public void validateEmail(FacesContext context,
            UIComponent component,
            Object SenderEmailStr)
    {
        if (!((String) SenderEmailStr).contains("@"))
        {
            ((UIInput) component).setValid(false);
            context.addMessage(component.getClientId(), new FacesMessage("Error: Email is not valid"));
        }
    }

    public String getBusinessName()
    {
        return businessName;
    }

    public void setBusinessName(String businessName)
    {
        this.businessName = businessName;
    }

    public String getRecipientName()
    {
        return recipientName;
    }

    public void setRecipientName(String recipientName)
    {
        this.recipientName = recipientName;
    }

    public String getSenderEmail()
    {
        return SenderEmail;
    }

    public void setSenderEmail(String SenderEmail)
    {
        this.SenderEmail = SenderEmail;
    }

    public String getRecipientEmail()
    {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail)
    {
        this.recipientEmail = recipientEmail;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDimensions()
    {
        return dimensions;
    }

    public void setDimensions(String dimensions)
    {
        this.dimensions = dimensions;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getTrackingCode()
    {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode)
    {
        this.trackingCode = trackingCode;
    }

}
