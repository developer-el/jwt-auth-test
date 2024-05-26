package io.eleutherius.lemonhc.resourceserver.config;

import io.eleutherius.lemonhc.resourceserver.filter.CustomHeaderValidationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilterConfig implements WebMvcConfigurer {

  @Bean
  public FilterRegistrationBean<CustomHeaderValidationFilter> addFilter(
      CustomHeaderValidationFilter filter) {
    FilterRegistrationBean<CustomHeaderValidationFilter> bean = new FilterRegistrationBean(filter);
    bean.addUrlPatterns("/messages");
    bean.setOrder(Integer.MIN_VALUE);
    return bean;
  }

}
