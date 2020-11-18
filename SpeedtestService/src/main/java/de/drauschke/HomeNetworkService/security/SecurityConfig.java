package de.drauschke.HomeNetworkService.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * https://www.thomasvitale.com/https-spring-boot-ssl-certificate/
 * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-configure-ssl
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.requiresChannel().anyRequest().requiresSecure();
  }
}
