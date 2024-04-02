package com.example.bci.base;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.example.bci.model.Telefono;
import com.example.bci.model.Usuario;
import com.example.bci.to.TelefonoRequestTO;
import com.example.bci.to.UsuarioRequestTO;
import com.example.bci.to.UsuarioResponseTO;

@Component
public class UtilNegocio {

   private final Environment environment;

    @Autowired
    public UtilNegocio(Environment environment) {
        this.environment = environment;
    }
    
    public Usuario setterUsuario(UsuarioRequestTO u) {        
        Usuario usuario = new Usuario();
        List<Telefono> telefonos = new ArrayList<>();      
        usuario.setNombre(u.getName());
        usuario.setEmail(u.getEmail());
        usuario.setPassword(u.getPassword());        
        for(TelefonoRequestTO t: u.getPhones()) {
            Telefono telefono = setterTelefono(t);
            telefono.setUsuario(usuario);
            telefonos.add(telefono);
        }       
        usuario.setTelefonos(telefonos);    
        return usuario;
    }
    
    public Telefono setterTelefono(TelefonoRequestTO to){
        Telefono telefono = new Telefono();
        telefono.setNumero(Integer.valueOf(to.getNumber()));
        telefono.setCodigoCiudad(Integer.valueOf(to.getCitycode()));
        telefono.setCodigoPais(Integer.valueOf(to.getContrycode()));
        return telefono;
    }
    
    public UsuarioResponseTO setterUsuario(Usuario u) {
        UsuarioResponseTO response = new UsuarioResponseTO();
        response.setId(u.getId());
        response.setCreated(u.getFechaCreacion());
        response.setModified(u.getFechaModificacion());
        response.setLast_login(u.getFechaUltimoAcceso());
        response.setToken(u.getToken());
        response.setIsactive(u.isActivo());
        return response;
    }
    
    public MensajeValidacion validaciones(UsuarioRequestTO u) {
        MensajeValidacion mensaje = validaRegex(u.getPassword(), getPasswordRegex(), Constantes.MSG_INVALID_PASSWORD);
        
        if(!mensaje.isOk()) 
            return mensaje;
        else 
            mensaje = validaRegex(u.getEmail(), getEmailRegex(), Constantes.MSG_INVALID_EMAIL);        
        
        
        return mensaje;
    } 

    public MensajeValidacion validaRegex(String cadena, String regex, String msjError) {
        MensajeValidacion mensaje = new MensajeValidacion();
        if (!Pattern.matches(regex, cadena)) {
            mensaje.setOk(false);
            mensaje.setGlosa(msjError);
        }       
        return mensaje;
    }
    
    public String getEmailRegex() {
        return environment.getProperty("validation.email.regex");
    }
    
    public String getPasswordRegex() {
        return environment.getProperty("validation.psswrd.regex");
    }

}