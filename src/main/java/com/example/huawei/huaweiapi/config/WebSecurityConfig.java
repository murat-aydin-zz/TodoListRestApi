package com.example.huawei.huaweiapi.config;

import javax.sql.DataSource;

import com.example.huawei.huaweiapi.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{


    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Configuration
    public static class ApiLoginConfig extends WebSecurityConfigurerAdapter{
        @Autowired
        DataSource dataSource;

        @Autowired
        ClientDetailsService clientDetailsService;

        @Autowired
        CustomUserDetailsService customUserDetailsService;




        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/h2-console","/h2-console/**","/oauth/token").permitAll();
            http.csrf().disable();
            http.headers().frameOptions().disable();
        }


        @Autowired
        public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
        }



        @Override
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Bean
        public TokenStore tokenStore() {
            return new InMemoryTokenStore();
        }

        @Bean
        @Autowired
        public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore){
            TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
            handler.setTokenStore(tokenStore);
            handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
            handler.setClientDetailsService(clientDetailsService);
            return handler;
        }

        @Bean
        @Autowired
        public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
            TokenApprovalStore store = new TokenApprovalStore();
            store.setTokenStore(tokenStore);
            return store;
        }
    }






}