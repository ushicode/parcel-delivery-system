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
public class UpdateParcelCommandTest
{

    @Test
    public void UpdateParcel()
    {
        String dte = "2001-01-01";
        Date date = Date.valueOf(dte);
        ParcelDTO parcelDTO = new ParcelDTO(107, 1, "BlueWhales", "Pual Collins", "jdairsoft@gmail.com", "just4Pual@gmail.com",
                "Tm Recoil", "10x10x10", "55 field road", "B867YK", "6797Jhgf97lO", "Delivery", date);

        ParcelManager result;
        result = new ParcelManager();
        result.updateParcel(parcelDTO);

        assertNotNull(result);

    }

}
