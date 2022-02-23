/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DeliveryUI.DeliveryCommandFactory;
import javax.inject.Named;
import DTO.DeliveryDTO;
import java.io.Serializable;
import java.sql.Date;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named(value = "SetDeliveryDriverMB")
@SessionScoped
public class SetDeliveryDriverMB implements Serializable
{

    private int parID;
    private int driverID;

    public String setDriver(HttpServletRequest request, int parcelID)
    {
        boolean driverSet = false;

        HttpSession session = request.getSession();
        driverID = (int) session.getAttribute("driverID");
        Date date = null;

        DeliveryDTO setDriver
                = new DeliveryDTO(
                        parcelID,
                        driverID,
                        0,
                        "",
                        "",
                        "",
                        "",
                        "",
                        date,
                        "");

        driverSet
                = (boolean) DeliveryCommandFactory
                        .createCommand(
                                DeliveryCommandFactory.SET_DELIVER_DRIVER,
                                setDriver, request)
                        .execute();

        if (driverSet == false)
        {
            parID = 0;
        }

        return driverSet ? "driverViewParcels.xhtml" : "";

    }

    public int getParID()
    {
        return parID;
    }
}
