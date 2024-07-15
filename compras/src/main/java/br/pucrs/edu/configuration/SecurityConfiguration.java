package br.pucrs.edu.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
   @Value("${security.basic.auth.user}")
   private String user;

   @Value("${security.basic.auth.pass}")
   private String password;	
	
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(user)
                .password(new BCryptPasswordEncoder().encode(password))
                .authorities("ROLE_USER")
            .and()
                .passwordEncoder( new BCryptPasswordEncoder());
    }


    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/pedidos-compra/**").permitAll()
                .anyRequest().authenticated()
           .and()
                .formLogin()
            .and()
                .cors()
            .and()
                .csrf().disable();
        http.headers().frameOptions().disable();
    }    
    
    
}
