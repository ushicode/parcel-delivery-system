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
import java.sql.Date;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;

@Named(value = "updateDeliveryStatusMB")
@SessionScoped
public class UpdateDeliveryStatusMB implements Serializable
{
    private String DeliveryStatus = null;

    public String updateDeliveryStatus(int parcelID,  HttpServletRequest request)
    {
        boolean deliveryStatusUpdated = false;

        Date date = null;

        ParcelDTO updateDeliveryStatus
                = new ParcelDTO(
                        parcelID,
                        0,
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        DeliveryStatus,
                        date);

        deliveryStatusUpdated
                = (boolean) DeliveryCommandFactory
                        .createCommand(
                                DeliveryCommandFactory.UPDATE_DELIVERY_STATUS,
                                updateDeliveryStatus, request)
                        .execute();

        if (deliveryStatusUpdated == false)
        {
            parcelID = 0;

        }

        return deliveryStatusUpdated ? "viewMtDeliveries.xhtml" : "";

    }
    public String getDeliveryStatus()
    {
        return DeliveryStatus;
    }

    public void setDeliveryStatus(String DeliveryStatus)
    {
        this.DeliveryStatus = DeliveryStatus;
    }

}
