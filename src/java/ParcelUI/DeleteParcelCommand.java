package ParcelUI;

import DTO.ParcelDTO;
import Managers.ParcelManager;

public class DeleteParcelCommand implements ParcelCommand
{

    private final ParcelDTO parcelDTO;
    private final ParcelManager parcelMgr;

    public DeleteParcelCommand(ParcelDTO parcelDTO)
    {
        this.parcelDTO = parcelDTO;
        parcelMgr = new ParcelManager();
    }
    
    @Override
    public Object execute()
    {
         return parcelMgr.deleteParcel(parcelDTO);
    }
}
