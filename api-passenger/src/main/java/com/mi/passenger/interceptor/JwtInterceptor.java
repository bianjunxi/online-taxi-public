package com.mi.passenger.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.mi.common.dto.ResponseResult;
import com.mi.passenger.utils.JwtUtils;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * ClassName: TokenInterceptor
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        String resultString = "";

        //请求头中携带token
        String token = request.getHeader("Authorization");

        try {
            JwtUtils.parseToken(token);
        } catch (SignatureVerificationException e) {
            //签名错误
            resultString = "token sign error";
            flag = false;
        } catch (TokenExpiredException e) {
            resultString = "token time out";
            flag = false;
        } catch (AlgorithmMismatchException e) {
            resultString = "token AlgorithmMismatchException";
            flag = false;
        } catch (Exception e) {
            resultString = "token invalid";
            flag = false;
        }

        if (!flag){
            PrintWriter out = response.getWriter();
            out.print(JSONObject.fromObject(ResponseResult.fail(resultString)).toString());
        }

        return flag;
    }
}
