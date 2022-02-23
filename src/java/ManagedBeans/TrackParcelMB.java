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
import javax.servlet.http.HttpSession;

@Named(value = "TrackParcelMB")
@SessionScoped
public class TrackParcelMB implements Serializable
{

    private String TrackingCode = "";

    public ArrayList<ParcelDTO> getMyParcelSummeries(String trackingCode, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.setAttribute("trackingCode", TrackingCode);

        trackingCode = TrackingCode;
        ArrayList<ParcelDTO> myparcelSummeries
                = (ArrayList<ParcelDTO>) DeliveryCommandFactory
                        .createCommand(
                                DeliveryCommandFactory.TRACK_DELIVERY, trackingCode, request)
                        .execute();

        return myparcelSummeries;
    }

    public String Back(HttpServletRequest request)
    {
        TrackingCode = null;
        HttpSession session = request.getSession();
        session.setAttribute("trackingCode", "");
        return "findMyParcel.xhtml";
    }

    public String getTrackingCode()
    {
        return TrackingCode;
    }

    public void setTrackingCode(String TrackingCode)
    {
        this.TrackingCode = TrackingCode;
    }

}
