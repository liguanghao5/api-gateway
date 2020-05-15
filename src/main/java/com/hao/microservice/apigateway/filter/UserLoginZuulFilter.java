package com.hao.microservice.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤器
 */
@Component
public class UserLoginZuulFilter extends ZuulFilter {

    /**
     * 过滤类型
     a)pre：请求在被路由之前执行
     b)routing：在路由请求时调用
     c)post：在routing和errror过滤器之后调用
     d)error：处理请求时发生错误调用
     * @return
     */
    @Override
    public String filterType() {

        return "pre";
    }

    /**
     * 过滤器优先级 越小越优先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 运行方法
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext currentContext = RequestContext.getCurrentContext();

        HttpServletRequest request = currentContext.getRequest();

        String token = request.getParameter("token");

        if(StringUtils.isEmpty(token)){
            currentContext.setSendZuulResponse(false);//过滤请求，不对其进行路由
            currentContext.setResponseStatusCode(401);//设置相应状态码
            currentContext.setResponseBody("token is empty!");//设置提示消息
            return null;
        }
        return null;
    }
}
