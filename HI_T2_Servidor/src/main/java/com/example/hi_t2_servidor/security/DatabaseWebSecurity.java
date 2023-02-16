package com.example.hi_t2_servidor.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {

    @Autowired
    private DataSource origenDatos;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(origenDatos)
                .usersByUsernameQuery("select NIF, pw, activo from cliente where NIF=?")
                .authoritiesByUsernameQuery("SELECT NIF, authority FROM authorities WHERE NIF=?");
    }
}
