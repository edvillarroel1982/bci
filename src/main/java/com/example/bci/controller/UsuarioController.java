package com.example.bci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bci.base.Constantes;
import com.example.bci.base.MensajeValidacion;
import com.example.bci.base.UtilNegocio;
import com.example.bci.service.UsuarioService;
import com.example.bci.to.ResponseTO;
import com.example.bci.to.UsuarioRequestTO;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/usuario")
@Validated
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    UtilNegocio utilNegocio;
    
    @PostMapping(value = "/registro")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody UsuarioRequestTO usuario) {
        ResponseTO response = new ResponseTO();
        MensajeValidacion validacion = utilNegocio.validaciones(usuario);
        if(validacion.isOk()) {
            if(!usuarioService.existeUsuarioByEmail(usuario.getEmail())) {
                response.setUsuario(utilNegocio.setterUsuario(usuarioService.guardarUsuario(utilNegocio.setterUsuario(usuario))));
                return ResponseEntity.status(HttpStatus.OK).body(response);    
            }else {
                response.setMensaje(Constantes.MSG_EMAIL_EXIST);
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            }
        }else {
            response.setMensaje(validacion.getGlosa());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
            
    }
    
}
