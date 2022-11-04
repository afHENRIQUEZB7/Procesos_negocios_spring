package com.Procesos.negocios.AFHenr.quezB.cotrollers;

import com.Procesos.negocios.AFHenr.quezB.Services.UsuarioServiceImpl;
import com.Procesos.negocios.AFHenr.quezB.Utils.JWTUtil;
import com.Procesos.negocios.AFHenr.quezB.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping(value = "/auth/Login")
    public ResponseEntity Login(@RequestBody Usuario usuario){

        return usuarioService.Login(usuario.getCorreo(),usuario.getPassword());

    }

}
