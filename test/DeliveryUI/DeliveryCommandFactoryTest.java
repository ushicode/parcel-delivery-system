/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeliveryUI;

import DTO.DeliveryDTO;
import org.junit.Test;
import static org.junit.Assert.*;
import DTO.ParcelDTO;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;

/**
 *
 * @author ushi
 */
public class DeliveryCommandFactoryTest extends Mockito
{

    @Test
    public void TrackDelivery()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        String trackingcode = "46793ujhi96";

        int commandType = DeliveryCommandFactory.TRACK_DELIVERY;
        // DeliveryCommand expectResult = DeliveryCommandFactory.createCommand(commandType, parcelDTO, request);
        DeliveryCommand result = DeliveryCommandFactory.createCommand(commandType, trackingcode, request);

        assertNotNull(result);
        //assertEquals(expectResult, result);
    }

    @Test
    public void UpdateDeliveryStatus()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);

        String dte = "2001-01-01";
        Date date = Date.valueOf(dte);
        ParcelDTO parcelDTO = new ParcelDTO(1, 0, "", "", "", "",
                "", "", "", "", "", "Delivery", date);

        int commandType = DeliveryCommandFactory.UPDATE_DELIVERY_STATUS;
        // DeliveryCommand expectResult = DeliveryCommandFactory.createCommand(commandType, parcelDTO, request);
        DeliveryCommand result = DeliveryCommandFactory.createCommand(commandType, parcelDTO, request);

        assertNotNull(result);
        //assertEquals(expectResult, result);
    }

    @Test
    public void SetDelivery()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);

        String dte = "2001-01-01";
        Date date = Date.valueOf(dte);
        ParcelDTO parcelDTO = new ParcelDTO(1, 1, "BlueWales", "Collins", "lins@gmail.com", "ushi@gmail.com",
                "gift item", "10x10x10", "81 College Road", "ST1 4DE", "CdDd8370H", "Delivery", date);

        int commandType = DeliveryCommandFactory.SET_DELIVERY;
        DeliveryCommand result = DeliveryCommandFactory.createCommand(commandType, parcelDTO, request);

        assertNotNull(result);
    }

    @Test
    public void ViewAllDeliveries()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);

        int commandType = DeliveryCommandFactory.VIEW_ALL_DELIVERY;
        DeliveryCommand result = DeliveryCommandFactory.createCommand(commandType, request);

        assertNotNull(result);
    }

    @Test
    public void ViewMyDeliveries()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);

        int commandType = DeliveryCommandFactory.VIEW_MY_DELIVERY;
        DeliveryCommand result = DeliveryCommandFactory.createCommand(commandType, request);

        assertNotNull(result);
    }

    @Test
    public void SetDeliveryDriver()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        String dte = "2001-01-01";
        Date date = Date.valueOf(dte);

        DeliveryDTO deliveryDTO = new DeliveryDTO(1, 1, 1, "DriverName", "Collins", "10x10x10", "55 field road",
                "B867YK", date, "Delivery");

        int commandType = DeliveryCommandFactory.SET_DELIVER_DRIVER;
        
        DeliveryCommand result = DeliveryCommandFactory.createCommand(commandType, deliveryDTO, request);

        assertNotNull(result);
    }

}
