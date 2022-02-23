package DeliveryUI;

import Managers.DeliveryManager;
import DTO.DeliveryDTO;
import javax.servlet.http.HttpServletRequest;

public class SetDeliveryDriverCommand implements DeliveryCommand
{

    private final DeliveryManager deliverlMgr;
    private final DeliveryDTO deliveryDTO;
    
    public SetDeliveryDriverCommand(DeliveryDTO deliveryDTO, HttpServletRequest request)
    {
        this.deliveryDTO = deliveryDTO;
        deliverlMgr = new DeliveryManager(request);
    }

    @Override
    public Object execute()
    {
        return deliverlMgr.setDeliveryDriver(deliveryDTO);
    }
}
