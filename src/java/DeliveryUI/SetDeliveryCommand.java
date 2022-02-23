package DeliveryUI;

import Managers.DeliveryManager;
import DTO.ParcelDTO;
import javax.servlet.http.HttpServletRequest;

public class SetDeliveryCommand implements DeliveryCommand
{

    private final DeliveryManager deliverlMgr;
    private final ParcelDTO parcelDTO;
    
    public SetDeliveryCommand(ParcelDTO parcelDTO, HttpServletRequest request)
    {
        this.parcelDTO = parcelDTO;
        deliverlMgr = new DeliveryManager(request);
    }

    @Override
    public Object execute()
    {
        return deliverlMgr.setDeliveryPreference(parcelDTO);
    }
}
