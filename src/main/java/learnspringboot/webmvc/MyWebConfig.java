package learnspringboot.webmvc;

import learnspringboot.webmvc.interceptor.SessionInterception;
import learnspringboot.webmvc.resolver.PartnerArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterception sessionInterception;

    @Autowired
    private PartnerArgumentResolver partnerArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(partnerArgumentResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterception).addPathPatterns("/user/*");
        // Ant path mather
        // /user/* , /user/dade
        // /User/**, /user/dade/jack
    }
}
