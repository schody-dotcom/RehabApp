package pwr.edu.rehabapp.utilities.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pwr.edu.rehabapp.utilities.security.filter.CustomAuthenticationFilter;
import pwr.edu.rehabapp.utilities.security.filter.CustomAuthorizationFilter;
import pwr.edu.rehabapp.service.UserService;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.cors().and().csrf().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/api/patient/**").hasAnyAuthority("ROLE_PATIENT");
        http.authorizeRequests().antMatchers("/api/doctor/**").hasAnyAuthority("ROLE_DOCTOR");
        http.authorizeRequests().antMatchers("/console/**").permitAll();



        http.authorizeHttpRequests().anyRequest().authenticated();

        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean(), userService));
       // http.addFilterBefore(new CustomAuthenticationFilter(authenticationManagerBean()), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/console/**");
    }
}
