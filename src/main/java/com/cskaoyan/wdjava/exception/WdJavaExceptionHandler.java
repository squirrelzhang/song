package com.cskaoyan.wdjava.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by little Stone
 * Date 2019/7/10 Time 9:37
 */
@Component
public class WdJavaExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error/default");
        if (e instanceof WdFileTypeException) {
            modelAndView.setViewName("/error/fileType");
        }
        if (e instanceof WdTermExistException) {
            modelAndView.setViewName("/error/termExist");
        }

        return modelAndView;
    }
}
