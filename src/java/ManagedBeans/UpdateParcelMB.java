/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import ParcelUI.ParcelCommandFactory;
import javax.inject.Named;
import DTO.ParcelDTO;
import java.io.Serializable;
import java.sql.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

@Named(value = "updateParcelMB")
@SessionScoped
public class UpdateParcelMB implements Serializable
{

    private int parID;

    private String recipientName = null;
    private String recipientEmail = null;
    private String description = null;
    private String dimensions = null;
    private String address = null;
    private String postcode = null;

    public String prepareToUpdateParcel(int parcelID)
    {
        parID = parcelID;
        return "updateParcel.xhtml";
    }

    public String updateParcel()
    {
        boolean parcelUpdated = false;
        String str = "2001-05-10";
        // Date date = Date.valueOf(str);
        Date date = null;

        ParcelDTO updateParcel
                = new ParcelDTO(
                        parID,
                        0,
                        "",
                        recipientName,
                        "",
                        recipientEmail,
                        description,
                        dimensions,
                        address,
                        postcode,
                        "",
                        "",
                        date);

        parcelUpdated
                = (boolean) ParcelCommandFactory
                        .createCommand(
                                ParcelCommandFactory.UPDATE_PARCELS,
                                updateParcel)
                        .execute();

        if (parcelUpdated == false)
        {
            parID = 0;
            recipientName = "";
            recipientEmail = "";
            description = "";
            dimensions = "";
            address = "";
        }

        return parcelUpdated ? "viewParcel.xhtml" : "";

    }

    public void validateEmail(FacesContext context,
            UIComponent component,
            Object emailStr)
    {
        if (!((String) emailStr).contains("@") && !((String) emailStr).isEmpty())
        {
            ((UIInput) component).setValid(false);
            context.addMessage(component.getClientId(), new FacesMessage("Error: Email is not valid"));
        }
    }

    public int getParID()
    {
        return parID;
    }

    public String getRecipientName()
    {
        return recipientName;
    }

    public void setRecipientName(String recipientName)
    {
        this.recipientName = recipientName;
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
}
