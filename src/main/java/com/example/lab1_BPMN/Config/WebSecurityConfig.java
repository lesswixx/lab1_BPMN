package com.example.lab1_BPMN.Config;


import com.example.lab1_BPMN.JWT.JwtTokenFilter;
import com.example.lab1_BPMN.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and() // Если требуется CORS
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/products/**").hasAuthority("READ_PRODUCT")
                .antMatchers(HttpMethod.POST, "/api/orders/**").hasAuthority("CREATE_ORDER")
                .antMatchers(HttpMethod.PUT, "/api/orders/**").hasAuthority("CHANGE_ORDER_STATUS")
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        // Замените jwtAuthenticationFilter() на ваш фильтр JWT
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }
}

