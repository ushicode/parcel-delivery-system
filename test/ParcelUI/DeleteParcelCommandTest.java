/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcelUI;

import DTO.ParcelDTO;
import Managers.ParcelManager;
import java.sql.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ushi
 */
public class DeleteParcelCommandTest
{
    @Test
    public void SenderDeleteParcel()
    {
        String dte = "2001-01-01";
        Date date = Date.valueOf(dte);
        ParcelDTO parcelDTO = new ParcelDTO(109, 1, "BlueWhales", "Collins", "lins@gmail.com", "ushi@gmail.com",
                "chicken", "10x10x10", "55 field road", "B867YK", "Bdjd8370H", "Delivery", date);

        ParcelManager result;
        result = new ParcelManager();
        result.deleteParcel(parcelDTO);

        assertNotNull(result);

    }
}
