package com.company.MatthewMarkewiczU1Capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery(
                        "select username, authority from authorities where username = ?")
                .passwordEncoder(encoder);

    }

    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic();

        // AUTHORIZE ROUTES HERE
        // ADD SECURITY SCHEMA TO THE EXISTING GAME STORE DATABASE
        httpSecurity.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/login").hasAuthority("ROLE_USER")
                .mvcMatchers(HttpMethod.PUT,  "/consoles").hasAuthority("ROLE_USER")
                .mvcMatchers(HttpMethod.PUT, "/games").hasAuthority("ROLE_USER")
                .mvcMatchers(HttpMethod.PUT, "/tshirts").hasAuthority("ROLE_USER")
                .mvcMatchers(HttpMethod.POST, "/consoles").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST, "/games").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST, "/tshirts").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.DELETE, "/consoles/{id}").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/games/{id}").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/tshirts/{id}").hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll();

        httpSecurity
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/allDone")
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
                .invalidateHttpSession(true);

        httpSecurity
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    }
}