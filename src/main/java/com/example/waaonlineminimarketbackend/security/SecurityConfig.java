package com.example.waaonlineminimarketbackend.security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final JwtFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean()
        throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors(withDefaults())
            .csrf().disable()
//            .exceptionHandling().authenticationEntryPoint()
//            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
                .antMatchers(
                        "/api/v1/roles/**",
                        "/api/v1/authenticate/**",
                        "/api/v1/address/**",
                        "/api/v1/orders/status",
                        "/swagger-ui/**",
                        "/static/**",
                        "/api/v1/invoice",
                        "/api/v1/reviews"
                ).permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/orders").hasAuthority("BUYER")
                .antMatchers(HttpMethod.PUT, "/api/v1/orders/status/**").hasAuthority("SELLER")
                .antMatchers(HttpMethod.PUT, "/api/v1/orders/status/**").hasAuthority("SELLER")
                .antMatchers(HttpMethod.POST, "/api/v1/product").hasAuthority("SELLER")
                .antMatchers(HttpMethod.PUT, "/api/v1/product").hasAuthority("SELLER")
                .antMatchers(HttpMethod.DELETE, "/api/v1/product").hasAuthority("SELLER")
                .antMatchers("/api/v1/admin/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,  "/api/v1/users").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,  "/api/v1/users").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,  "/api/v1/users").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,  "/api/v1/users/follow/**").hasAuthority("BUYER")
                .antMatchers(HttpMethod.POST,  "/api/v1/reviews").hasAuthority("BUYER")
                .antMatchers(HttpMethod.PUT,  "/api/v1/reviews").hasAuthority("BUYER")
                .antMatchers(HttpMethod.DELETE,  "/api/v1/reviews").hasAuthority("BUYER")
                .antMatchers(HttpMethod.POST,  "/api/v1/upload").hasAuthority("SELLER")
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(
                jwtFilter,
                UsernamePasswordAuthenticationFilter.class
        );
    }
}
