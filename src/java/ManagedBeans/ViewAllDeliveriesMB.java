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
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;

@Named(value = "ViewAllDeliveries")
@SessionScoped
public class ViewAllDeliveriesMB implements Serializable
{

    
    public ArrayList<ParcelDTO> getDeliveryummeries(HttpServletRequest request)
    {

        ArrayList<ParcelDTO> DeliverySummeries
                = (ArrayList<ParcelDTO>) DeliveryCommandFactory
                        .createCommand(
                                DeliveryCommandFactory.VIEW_ALL_DELIVERY, request)
                        .execute();

        return DeliverySummeries;
    }

}
