/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeliveryUI;

import DTO.DeliveryDTO;
import Managers.DeliveryManager;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author ushi
 */
public class SetDeliveryDriverCommandTest
{

    @Test
    public void SetDeliveryDriverCommand()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        String dte = "2001-01-01";
        Date date = Date.valueOf(dte);

        DeliveryDTO deliveryDTO = new DeliveryDTO(107, 1, 1, "DriverName", "Collins", "10x10x10", "55 field road",
                "B867YK", date, "Delivery");

        DeliveryManager result;
        result = new DeliveryManager(request);

        result.setDeliveryDriver(deliveryDTO);

        assertNotNull(result);
    }
}
