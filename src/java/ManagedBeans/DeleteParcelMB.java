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

@Named(value = "deleteParcelMB")
@SessionScoped
public class DeleteParcelMB implements Serializable
{

    private int parID;

    public String deleteParcel(int parcelID)
    {
        parID = parcelID;
        boolean parcelDeleted = false;
        String str = "2001-01-01";
        Date date = null;

        ParcelDTO deleteParcel
                = new ParcelDTO(
                        parID,
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
                        "",
                        date);

        parcelDeleted
                = (boolean) ParcelCommandFactory
                        .createCommand(
                                ParcelCommandFactory.DELETE_PARCELS,
                                deleteParcel)
                        .execute();

        if (parcelDeleted == false)
        {
            parID = 0;
        }

        return parcelDeleted ? "viewParcel.xhtml" : "";

    }

    public int getParID()
    {
        return parID;
    }
}
