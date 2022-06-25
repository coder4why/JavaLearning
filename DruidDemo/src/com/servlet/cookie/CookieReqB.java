package com.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/** Cookie的读取与解码 */

/** Cookie的编解码问题：
 *      Cookie默认不支持中文字符,只能包含ASCII码字符，所以需要对Cookie字符进行编码，否则会出现乱码；
 *      1.编码：
 *           使用java.net.URLEncoder类的encode(String str,String encoding)方法；
 *      2.解码：
 *          使用java.net.URLDecoder类的decode(String str,String encoding)方法；
 *
 */
@WebServlet(value = "/cookieB")
public class CookieReqB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /** 1.通过Request对象获取所有Cookie */
        Cookie[] cookies = req.getCookies();

        /** 避免空指针异常 */
        if (cookies != null){
            for (Cookie c:cookies) {
                /** 2.Cookie的解码问题 */
                String name = URLDecoder.decode(c.getName(),"UTF-8");
                String value = URLDecoder.decode(c.getValue(),"UTF-8");
                System.out.println(name+":"+value);
            }
        }
    }


}
