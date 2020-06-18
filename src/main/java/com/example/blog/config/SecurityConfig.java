package com.example.blog.config;

import com.example.blog.models.UserRole;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author smustafov
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .logout().logoutSuccessUrl("/");

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/post").hasRole(UserRole.ADMIN.toString())
                .antMatchers(HttpMethod.POST, "/post/edit").hasRole(UserRole.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/post/delete").hasRole(UserRole.ADMIN.toString())
                .anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("sinan").password("123456").roles(UserRole.ADMIN.toString())
                .and()
                .withUser("pesho").password("123456").roles(UserRole.USER.toString());
    }
}
