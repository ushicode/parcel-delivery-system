package ParcelUI;

import DTO.ParcelDTO;
import Managers.ParcelManager;

public class UpdateParcelCommand implements ParcelCommand
{

    private final ParcelDTO parcelDTO;
    private final ParcelManager parcelMgr;

    public UpdateParcelCommand(ParcelDTO parcelDTO)
    {
        this.parcelDTO = parcelDTO;
        parcelMgr = new ParcelManager();
    }
    
    @Override
    public Object execute()
    {
         return parcelMgr.updateParcel(parcelDTO);
    }
}
