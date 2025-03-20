package com.pfe.AllTheTps.config.securite;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService1) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService1;
    }

   /* @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder builder =
                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        return builder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and().
                build();
    }*/
   @Bean
   public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
       AuthenticationManagerBuilder builder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
       builder.userDetailsService(userDetailsService) // Set the custom UserDetailsService
               .passwordEncoder(passwordEncoder);        // Set the PasswordEncoder
       return builder.build();
   }

    /*@Bean
    UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .password(passwordEncoder.encode("123"))
                .username("user1")
                .roles("ADMIN")
                .build();
        UserDetails user2 = User.builder()
                .password(passwordEncoder.encode("123"))
                .username("user2")
                .roles("USER")
                .build();
        return new
                InMemoryUserDetailsManager(Arrays.asList(user1,user2));
    }*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html")
                        .hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .permitAll()
                        .defaultSuccessUrl("/swagger-ui/index.html")
                );

        return http.build();
    }
}



