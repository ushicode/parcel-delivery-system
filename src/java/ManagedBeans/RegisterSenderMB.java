/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import SenderUI.SenderCommandFactory;
import javax.inject.Named;
import DTO.SenderDTO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@Named(value = "registerSenderMB")
@RequestScoped
public class RegisterSenderMB
{

    private String businessName;
    private String email;
    private String address;
    private String postcode;
    private String password;
    private String Cpassword;

    public String registerSender(HttpServletRequest request)
    {
        boolean senderRegistered = false;

        if (password.equals(Cpassword))
        {
            SenderDTO newSender
                    = new SenderDTO(
                            businessName,
                            email,
                            address,
                            postcode,
                            password,
                            Cpassword);
            senderRegistered
                    = (boolean) SenderCommandFactory
                            .createCommand(
                                    SenderCommandFactory.REGISTER_SENDER,
                                    newSender, request)
                            .execute();
        }
        if (senderRegistered == false)
        {
            businessName = "";
            email = "";
            address = "";
            postcode = "";
            password = "";
            Cpassword = "";
        }

        return senderRegistered ? "index.xhtml" : "";

    }

    public void validateEmail(FacesContext context,
            UIComponent component,
            Object emailStr)
    {
        if (!((String)emailStr).contains("@"))
        {
            ((UIInput)component).setValid(false);
            context.addMessage(component.getClientId(), new FacesMessage("Error: Email is not valid"));
        }
    }

    public String getBusinessName()
    {
        return businessName;
    }

    public void setBusinessName(String businessName)
    {
        this.businessName = businessName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        try
        {
            byte[] passHash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(password.getBytes(StandardCharsets.UTF_8));

            password = Base64.getEncoder().encodeToString(passHash);
            // System.out.println("Password: '" + password + "'");
        }
        catch (NoSuchAlgorithmException nsae)
        {

        }
        this.password = password;
    }

    public String getCpassword()
    {
        return Cpassword;
    }

    public void setCpassword(String Cpassword)
    {
        try
        {
            byte[] CpassHash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(Cpassword.getBytes(StandardCharsets.UTF_8));

            Cpassword = Base64.getEncoder().encodeToString(CpassHash);
        }
        catch (NoSuchAlgorithmException nsae)
        {

        }
        this.Cpassword = Cpassword;
    }
}
