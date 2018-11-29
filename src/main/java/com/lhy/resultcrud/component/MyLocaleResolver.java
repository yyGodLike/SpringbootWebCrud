package com.lhy.resultcrud.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义切换国际化属性配置类
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {

        String language = httpServletRequest.getParameter("language");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)) {
            String[] strLanguage = language.split("_");
            locale = new Locale(strLanguage[0], strLanguage[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
