package hutech.java.chautrongnhan2080601309;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@AllArgsConstructor
public class SpringSecurityConfig {
    private UserDetailsService userDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/webjars/**", "/assets/**").permitAll()
                                .requestMatchers("/nhanvien").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                .requestMatchers("/phongban").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                .requestMatchers("/nhanvien/create").hasAnyAuthority("ROLE_ADMIN")
                                .requestMatchers("/phongban/create").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/phongban/save").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/nhanvien/save").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/phongban/edit/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/nhanvien/edit/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/nhanvien/delete/**").hasAuthority("ROLE_ADMIN")
                                .anyRequest().authenticated()
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/nhanvien")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
