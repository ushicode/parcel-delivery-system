package SenderUI;

import DTO.SenderDTO;
import Managers.SenderManager;
import javax.servlet.http.HttpServletRequest;

public class LoginSenderCommand implements SenderCommand
{

    private final SenderDTO senderDTO;
    private final SenderManager senderMgr;

    public LoginSenderCommand(SenderDTO senderDTO, HttpServletRequest request)
    {
        this.senderDTO = senderDTO;
        senderMgr = new SenderManager(request);
    }
    
    @Override
    public Object execute()
    {
         return senderMgr.loginSender(senderDTO);
    }
}
