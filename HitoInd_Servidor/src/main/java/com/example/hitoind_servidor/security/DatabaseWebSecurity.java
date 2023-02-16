package com.example.hitoind_servidor.security;

import com.example.hitoind_servidor.models.Authorities;
import com.example.hitoind_servidor.models.Usuarios;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;


@Configuration
public class DatabaseWebSecurity  {


    @Bean
    public InMemoryUserDetailsManager detalleUsuarios(){
        String URL = "http://localhost:8085";
        String urlRol = "http://localhost:8085/rol";

        //
        ArrayList<UserDetails> users = new ArrayList<>();




        RestTemplate rest = new RestTemplate();
        Usuarios[] arrayUsuarios = rest.getForObject(URL, Usuarios[].class);
        String[] arrayRoles = rest.getForObject(urlRol, String[].class);

        int i = 0;
       for (Usuarios usuario: arrayUsuarios) {


            users.add(User.withUsername(usuario.getNombre())
                    .password(usuario.getPassword())
                    .authorities(arrayRoles[i])
                    .disabled(false)
                    .build());

           System.out.println(arrayRoles[i]);
           i++;
           System.out.println(usuario.getNombre());

       }

        return new InMemoryUserDetailsManager(users);
    }


    // Filtros por URL.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests()
// Recursos estáticos que no requieren autentificación.
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/js/**").permitAll()
                // No se requiere autenticación para acceso a la raiz y al login
                .requestMatchers("/", "/login", "/signup").permitAll()
                // Solo puede acceder a la vista medicos el usuario con rol medico
                .requestMatchers("/medicos").hasAuthority("medico")
                // Solo puede acceder a la vista productos el usuario con rol USUARIO
                .requestMatchers("/enfermeros").hasAnyAuthority("enfermero", "medico")
                // Se requiere autenticación para el resto de reutas.
                .anyRequest().authenticated()
                // Se permite iniciar y cerrar sesión.
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll()
                // Error permiso denegado
                .and().exceptionHandling().accessDeniedPage("/denegado");
        return http.build();
    }
}
