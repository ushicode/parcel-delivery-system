package SenderUI;

import DTO.SenderDTO;
import Managers.SenderManager;
import javax.servlet.http.HttpServletRequest;

public class RegisterSenderCommand implements SenderCommand
{

    private final SenderDTO senderDTO;
    private final SenderManager senderMgr;

    public RegisterSenderCommand(SenderDTO senderDTO, HttpServletRequest request)
    {
        this.senderDTO = senderDTO;
        senderMgr = new SenderManager(request);
    }
    
    @Override
    public Object execute()
    {
         return senderMgr.registerSender(senderDTO);
    }
}
