package br.com.daniel.config;

import br.com.daniel.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

////    private final UserDetailsService userDetailsService;
////    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
    @Autowired
    private UsuarioService usuarioService;
//
////    private static final String[] AUTH_WHITELIST = {
////            "/v2/api-docs",
////            "/swagger-resources",
////            "/swagger-resources/**",
////            "/configuration/ui",
////            "/configuration/security",
////            "/swagger-ui.html",
////            "/webjars/**",
////            "/v3/api-docs/**",
////            "/h2-console/**",
////            "/swagger-ui/**",
////            "/login"
////    };
//
    @Bean
    public PasswordEncoder passwordEncoder(){
//        PasswordEncoder enconder = new BCryptPasswordEncoder();
//        return enconder;
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        String senhaCodificada = passwordEncoder().encode("123456");
//        auth.inMemoryAuthentication().withUser("usuario2")
//                .password(senhaCodificada).roles("USER");
//
//
//        auth.inMemoryAuthentication().withUser("fulano")
//                .password("123").roles("USER");
//
//
        auth.userDetailsService(usuarioService)
                .passwordEncoder(passwordEncoder());
    }
//

//
    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .cors()
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////            http.authorizeRequests().anyRequest().authenticated();
//
//
////        http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll();
////        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }


}
