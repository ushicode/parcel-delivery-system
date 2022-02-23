/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeliveryUI;

import DTO.ParcelDTO;
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
public class SetDeliveryCommandTest
{

    @Test
    public void SetDeliveryCommand()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);

        String dte = "2001-01-01";
        Date date = Date.valueOf(dte);
        ParcelDTO parcelDTO = new ParcelDTO(6, 0, "BlueWhales", "Jack", "jdairsoft@gmail.com", "jackgrant@gmail.com",
                "chicken", "10x10x10", "55 field road", "B867YK", "Bdjd8370H", "Delivery", date);

        DeliveryManager result;

        result = new DeliveryManager(request);

        result.setDeliveryPreference(parcelDTO);

        assertNotNull(result);
    }
}
