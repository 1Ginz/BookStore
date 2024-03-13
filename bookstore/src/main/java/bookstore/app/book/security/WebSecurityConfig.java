package bookstore.app.book.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/","/registration","../assets/css/**").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/",true)
                .successHandler((request, response, authentication) -> {
                    request.getSession().setAttribute("username",authentication.getName());
                    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

                    boolean isAdmin = authorities.stream()
                            .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
                    if (isAdmin) {
                        response.sendRedirect("/admin/");
                    } else {
                        response.sendRedirect("/");
                    }
                })
                .permitAll().and()
                .logout().logoutSuccessUrl("/").permitAll()
                .and().httpBasic();
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS).and().userDetailsService(userDetailService);
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**", "/resources/**","/data/**");
    }

}
