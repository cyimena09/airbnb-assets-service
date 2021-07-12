package be.cyimena.airbnb.assetsservice.config.security;

import be.cyimena.airbnb.assetsservice.enumerations.ProfileEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService myUserDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/assets/authenticate").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/assets/users").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/assets/users").permitAll()
                // realEstates
                .antMatchers(HttpMethod.GET, "/api/v1/assets/real_estates").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/assets/real_estates").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/assets/real_estates/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/assets/real_estates/{id}").permitAll()
                // bookings
                .antMatchers(HttpMethod.GET, "/api/v1/assets/bookings").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/assets/bookings").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/assets/bookings/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/assets/bookings/{id}").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
