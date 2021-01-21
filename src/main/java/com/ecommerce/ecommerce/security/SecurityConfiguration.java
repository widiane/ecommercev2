package com.ecommerce.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ecommerce.ecommerce.service.IUser;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private IUser userService;
	private AuthenticationSuccessHandler authenticationSuccessHandler;

	    @Autowired
    public SecurityConfiguration(AuthenticationSuccessHandler authenticationSuccessHandler) {
	        this.authenticationSuccessHandler = authenticationSuccessHandler;
	    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests().antMatchers("/rest/**").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/login").permitAll().antMatchers("/admin/**").hasAuthority("ADMIN")
		.antMatchers("/client/**").hasAuthority("CLIENT").anyRequest().authenticated().and().csrf().disable().formLogin().loginPage("/login").failureUrl("/login?error=true").successHandler(authenticationSuccessHandler)
				.usernameParameter("username").passwordParameter("password").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and()
				.exceptionHandling().accessDeniedPage("/access-denied");*/
		http.authorizeRequests().
		antMatchers("/").permitAll().
		antMatchers("/login").permitAll().
		antMatchers("/produits").permitAll().
		antMatchers("/inscription").permitAll().
		antMatchers("/welcome").hasAnyAuthority("ADMIN","CLIENT").
		antMatchers("/admin/**").hasAuthority("ADMIN").
		antMatchers("/client/**").hasAuthority("CLIENT").
		anyRequest().authenticated().
		and().csrf().disable().
		formLogin().loginPage("/login").
		failureUrl("/login?error=true").
		successHandler(authenticationSuccessHandler).
		usernameParameter("username").
		passwordParameter("password").
		and().logout().logoutRequestMatcher(new
		AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").
		and().exceptionHandling().accessDeniedPage("/access-denied");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/fonts/**","/img/**");
	}
}