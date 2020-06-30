package com.practice.microservice.netflixzuulapigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * This Filter is for logging purpose
 */
@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Decide which type of the request should this filter target to
     * @return 'pre' : before request getting executed
     * 'post': after request executed
     * 'error' : intercept error request
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1; // priority / order of this filter
    }

    /**
     * Decide whether to run this filter with the incoming request or not
     * @return true / false to decide
     */
    @Override
    public boolean shouldFilter() {
        return true; // filtering all incoming request
    }

    /**
     * Logic of this interceptor - what it does
     */
    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request =
                RequestContext.getCurrentContext().getRequest();
        logger.info("Request -> {} request uri => {}", request, request.getRequestURI());
        return null;
    }
}
