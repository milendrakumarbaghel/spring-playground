package org.geofence.springplayground.config;

//import com.SecurityApp.SecurityApplication.filters.JWTAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

//    private final JWTAuthFilter jwtAuthFilter;

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/posts", "/error", "/auth/**").permitAll()
////                        .requestMatchers("/posts/**").hasAnyRole("ADMIN")
//                        .anyRequest().authenticated())
//                .csrf(csrfConfig -> csrfConfig.disable())
//                .sessionManagement(sessionConfig -> sessionConfig
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .oauth2Login(oauth2Config -> oauth2Config
//                        .failureUrl("/login?error=true"));
////                .formLogin(Customizer.withDefaults());
//
//        return httpSecurity.build();
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/api/student/**").hasAnyRole("Student", "Admin")
                        .requestMatchers(HttpMethod.POST, "/api/student/create").hasRole("Admin")
                        .requestMatchers(HttpMethod.PUT, "/api/student/**").hasAnyRole("Student", "Admin")
                        .requestMatchers(HttpMethod.DELETE, "/api/student").hasRole("Admin")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("Admin")
                .build();

        UserDetails student = User.builder()
                .username("student")
                .password(passwordEncoder.encode("student"))
                .roles("Student")
                .build();

        return new InMemoryUserDetailsManager(admin, student);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) {
        return config.getAuthenticationManager();
    }

//    @Bean
//    UserDetailsService myInMemoryUserDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails normalUser = User
//                .withUsername("user")
//                .password(passwordEncoder.encode("abc123"))
//                .roles("USER")
//                .build();
////        System.out.println(passwordEncoder.encode("abc123"));
//
//
//        UserDetails adminUser = User
//                .withUsername("admin")
//                .password(passwordEncoder.encode("admin123"))
//                .roles("ADMIN")
//                .build();
////        System.out.println(passwordEncoder.encode("admin123"));
//
//        return new InMemoryUserDetailsManager(normalUser, adminUser);
//    }
}
