package com.mussatto;

import com.mussatto.repository.ProfileRepository;
import com.mussatto.repository.UserConnectionRepository;
import com.mussatto.util.AuthUtil;
import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserConnectionRepository userConnectionRepository;

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/h2-console/*");
        return registration;
    }

    @Bean
    public SocialConfigurer socialConfigurerAdapter(DataSource dataSource) {
        // https://github.com/spring-projects/spring-social/blob/master/spring-social-config/src/main/java/org/springframework/social/config/annotation/SocialConfiguration.java#L87
        return new DatabaseSocialConfigurer(dataSource, profileRepository, userConnectionRepository);
    }

}
