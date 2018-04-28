package com.iktpreobuka.security.config;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration 
@EnableWebSecurity
public class SpringSecurityConfig extends 
WebSecurityConfigurerAdapter{
	
	@Autowired 
	private AuthenticationEntryPoint authEntryPoint; 
	 
	@Override 
	protected void configure(HttpSecurity http) throws Exception { 
	http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(authEntryPoint); 

}
	@Autowired 
	public void configure(AuthenticationManagerBuilder auth) throws 
	Exception { 
	/*auth.inMemoryAuthentication().withUser("testuser").password("testpass").roles("admin"); */
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery).dataSource((javax.sql.DataSource) dataSource); 
}
	@Autowired 
	private DataSource dataSource; 
	 
	@Value("${spring.queries.users-query}") 
	private String usersQuery; 
	 
	@Value("${spring.queries.roles-query}") 
	private String rolesQuery; 
}
