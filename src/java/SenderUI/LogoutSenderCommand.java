package SenderUI;

import DTO.SenderDTO;
import Managers.SenderManager;
import javax.servlet.http.HttpServletRequest;

public class LogoutSenderCommand implements SenderCommand
{

    private final SenderDTO senderDTO;
    private final SenderManager senderMgr;

    public LogoutSenderCommand(SenderDTO senderDTO, HttpServletRequest request)
    {
        this.senderDTO = senderDTO;
        senderMgr = new SenderManager(request);
    }
    
    @Override
    public Object execute()
    {
         return senderMgr.logoutSender(senderDTO);
    }
}
