package learnspringboot.webmvc.resolver;

import jakarta.servlet.http.HttpServletRequest;
import learnspringboot.webmvc.model.Partner;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class PartnerArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Partner.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = (HttpServletRequest) webRequest.getNativeRequest();
        String apiLKey = servletRequest.getHeader("X-API-KEY");

        if (apiLKey != null) {
            //query ke database
            return new Partner(apiLKey, "Sample Partner");
        }

        throw new RuntimeException("Unautorized Exception");
    }
}
