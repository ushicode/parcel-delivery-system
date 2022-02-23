package DeliveryUI;

import Managers.DeliveryManager;
import DTO.ParcelDTO;
import javax.servlet.http.HttpServletRequest;

public class UpdateDeliveryStatusCommand implements DeliveryCommand
{

    private final DeliveryManager deliverlMgr;
    private final ParcelDTO ParcelDTO;
    
    public UpdateDeliveryStatusCommand(ParcelDTO ParcelDTO, HttpServletRequest request)
    {
        this.ParcelDTO = ParcelDTO;
        deliverlMgr = new DeliveryManager(request);
    }

    @Override
    public Object execute()
    {
        return deliverlMgr.updateDeliveryStatus(ParcelDTO);
    }
}
