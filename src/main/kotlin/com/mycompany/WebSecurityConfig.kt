package com.mycompany

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@Configuration
@EnableWebSecurity
open class WebSecurityConfig : WebSecurityConfigurerAdapter() {
	override fun configure(http:HttpSecurity) {
		http
			.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/fonts/**")
				.permitAll().and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.logout() 
				.logoutSuccessUrl("/login") 
				.permitAll()
			.and().csrf().disable()
	}
	@Autowired
	fun configureGlobal(auth:AuthenticationManagerBuilder) {
		auth
			.inMemoryAuthentication()
				.withUser("usr@provider.com").password("test").roles("USER")
	}
}
