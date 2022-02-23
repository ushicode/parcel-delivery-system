/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcelUI;

import DTO.ParcelDTO;
import ParcelUI.ParcelCommand;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author ushi
 */
public class ParcelCommandFactoryTest
{

    @Test
    public void RegisterParcel()
    {

        String dte = "2001-01-01";
        Date date = Date.valueOf(dte);
        ParcelDTO parcelDTO = new ParcelDTO(1, 1, "BlueWhales", "Collins", "lins@gmail.com", "ushi@gmail.com",
                "chicken", "10x10x10", "55 field road", "B867YK", "Bdjd8370H", "Delivery", date);

        int commandType = ParcelCommandFactory.REGISTER_PARCEL;
        ParcelCommand result = ParcelCommandFactory.createCommand(commandType, parcelDTO);

        assertNotNull(result);
    }

    @Test
    public void UpdateParcel()
    {

        String dte = "2001-01-01";
        Date date = Date.valueOf(dte);
        ParcelDTO parcelDTO = new ParcelDTO(1, 1, "BlueWhales", "Jack", "jdairsoft@gmail.com", "jackgrant@gmail.com",
                "chicken", "10x10x10", "55 field road", "B867YK", "Bdjd8370H", "Delivery", date);

        int commandType = ParcelCommandFactory.UPDATE_PARCELS;
        ParcelCommand result = ParcelCommandFactory.createCommand(commandType, parcelDTO);

        assertNotNull(result);
    }

    @Test
    public void DeleteParcel()
    {

        String dte = "2001-01-01";
        Date date = Date.valueOf(dte);
        ParcelDTO parcelDTO = new ParcelDTO(1, 1, "BlueWhales", "collins", "lins@gmail.com", "ushi@gmail.com",
                "chicken", "10x10x10", "55 field road", "B867YK", "Bdjd8370H", "Delivery", date);

        int commandType = ParcelCommandFactory.DELETE_PARCELS;
        ParcelCommand result = ParcelCommandFactory.createCommand(commandType, parcelDTO);

        assertNotNull(result);
    }
    
        @Test
    public void ViewParcel()
    {
        String senderEmail = "lins@gmail.com";
        int commandType = ParcelCommandFactory.VIEW_PARCELS;
        ParcelCommand result = ParcelCommandFactory.createCommand(commandType, senderEmail);

        assertNotNull(result);
    }
}
