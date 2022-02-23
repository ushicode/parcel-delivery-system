/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import ParcelUI.ParcelCommandFactory;
import javax.inject.Named;
import DTO.ParcelDTO;
import DTO.SenderDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named(value = "ParcelMB")
@SessionScoped
public class ParcelMB implements Serializable
{

    private ParcelDTO parcel = null;
    private int totalParcels = 0;

    public ArrayList<ParcelDTO> getParcelSummeries(String senderEmail, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        senderEmail = (String) session.getAttribute("senderEmail");
        
        ArrayList<ParcelDTO> parcelSummeries
                = (ArrayList<ParcelDTO>) ParcelCommandFactory
                        .createCommand(
                                ParcelCommandFactory.VIEW_PARCELS, senderEmail)
                        .execute();      

        totalParcels = parcelSummeries.size();

        return parcelSummeries;
    }

    public int getTotalParcelss()
    {
        return totalParcels;
    }
}
