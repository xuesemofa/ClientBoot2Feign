package org.client.com.util.verification;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ld
 * @name 验证码验证
 * @table
 * @remarks
 */
public class VerificationUtils {
    public boolean imgvrifyControllerDefaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        String parameter = httpServletRequest.getParameter("vrifyCode");
        System.out.println("Session  vrifyCode " + captchaId + " form vrifyCode " + parameter);

        if (!captchaId.equals(parameter)) {
            return false;
        } else {
            return true;

        }
    }
}
