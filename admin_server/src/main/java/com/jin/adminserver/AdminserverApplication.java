package com.jin.adminserver;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringBootApplication
@EnableAdminServer
public class AdminserverApplication extends WebSecurityConfigurerAdapter {
    @Autowired
    private AdminServerProperties adminServerProperties;

    public static void main(String[] args) {
        SpringApplication.run(AdminserverApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String adminContxtPaht = adminServerProperties.getContextPath();

        SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
        handler.setTargetUrlParameter("redirectTo");
        handler.setDefaultTargetUrl(adminContxtPaht + "/");

        http.authorizeRequests()
                .antMatchers(adminContxtPaht + "/assets/**").permitAll()
                .antMatchers(adminContxtPaht + "/login").permitAll()
                .and()
                .formLogin().loginPage(adminContxtPaht + "/login").successHandler(handler).and()
                .logout().logoutUrl(adminContxtPaht + "/logout")
                .and()
                .httpBasic().and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringAntMatchers(
                        adminContxtPaht + "/instances",
                        adminContxtPaht + "actuator/**"
                );
    }

}
