package com.example.RHB.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import com.example.RHB.Security.OpenIdConnectFilter;

@Configuration
@EnableWebSecurity
public class Securityconfiguration  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	OAuth2RestTemplate restTemplate;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/resources/**");
	}
	
	@Bean
	public OpenIdConnectFilter Filter() {
        final OpenIdConnectFilter filter = new OpenIdConnectFilter("/google-login");
        filter.setRestTemplate(restTemplate);
        return filter;
    }
	
	@Override
	 protected void configure(HttpSecurity http) throws Exception {
	        // @formatter:off
	        http
	        .addFilterAfter(new OAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
	        .addFilterAfter(Filter(), OAuth2ClientContextFilter.class)
	        .httpBasic().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/google-login"))
	        .and()
	        .authorizeRequests()
	       // .antMatchers("/","/index*").permitAll()
	        .anyRequest().authenticated()
	        ;

	     // @formatter:on
	    }

}
