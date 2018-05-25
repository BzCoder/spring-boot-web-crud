package com.example.springbootwebcrud.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

//给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    /**
     * 重写getErrorAttributes方法，将自己需要的错误讯息放入到map中，以便错误时能在map中获取
     * 其中webRequest.getAttribute(para,para2))函数第二项表示从何处取数据
     *  int SCOPE_REQUEST = 0;
     *  int SCOPE_SESSION = 1;
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
       Map<String,Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
       map.put("user_name","baozhou");
       map.put("ext",webRequest.getAttribute("ext",0));
       return map;
    }
}
