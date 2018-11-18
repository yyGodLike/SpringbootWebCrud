package com.lhy.resultcrud.component;


import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {

        Map map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("company", "alibaba");
        //获取异常处理器携带的数据
        Map extMap = (Map) requestAttributes.getAttribute("ext", 0);
        map.put("ext", extMap);

        return map;
    }
}
