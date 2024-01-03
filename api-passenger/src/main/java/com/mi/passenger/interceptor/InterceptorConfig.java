package com.mi.passenger.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: InterceptorConfig
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 容器初始化时加载拦截器
     * @return
     */
    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                //不拦截的路径
                .excludePathPatterns("/noAuthTest")
                .excludePathPatterns("/verification-code")
                .excludePathPatterns("/verification-code-check")
                .excludePathPatterns("/refresh-token")
                //拦截的路径
                .addPathPatterns("/**");
    }
}
