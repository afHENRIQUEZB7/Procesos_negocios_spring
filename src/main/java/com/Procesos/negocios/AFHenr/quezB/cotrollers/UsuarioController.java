package com.Procesos.negocios.AFHenr.quezB.cotrollers;

import com.Procesos.negocios.AFHenr.quezB.models.Usuario;
import com.Procesos.negocios.AFHenr.quezB.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController

public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/usuario/{id}")
    public Optional<Usuario> getUsuario(@PathVariable Long id){
        Optional<Usuario> usuario= usuarioRepository.findById(id);

        return usuario;

    }

    @PostMapping("/usuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
        return usuario;
    }

    @GetMapping("/usuarios")
    public List<Usuario>ListarUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{nombre}/{apellidos}")
    public List<Usuario> listarPorNombreyApellidos(@PathVariable String nombre,@PathVariable String apellidos){
        return usuarioRepository.findAllByNombreAndApellidos(nombre, apellidos);
    }

    @GetMapping("/usuario/apellidos/{apellidos}")
    public List<Usuario> listarPorApellidos(@PathVariable String apellidos){
        return usuarioRepository.findAllByApellidos(apellidos);
    }

    @GetMapping("/usuario/nombre/{nombre}")
    public List<Usuario> listarPorNombre(@PathVariable String nombre){
        return usuarioRepository.findAllByNombre(nombre);
    }

    @PutMapping("/usuario/{id}")
    public Usuario editarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioBD= usuarioRepository.findById(id).get();
        try{
            usuarioBD.setId(usuarioBD.getId());
            usuarioBD.setNombre(usuario.getNombre());
            usuarioBD.setApellidos(usuario.getApellidos());
            usuarioBD.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioBD.setTelefono(usuario.getTelefono());
            usuarioBD.setDireccion(usuario.getDireccion());
            usuarioRepository.save(usuarioBD);
            return usuarioBD;
        }catch (Exception e){
            return null;
        }
    }

    @DeleteMapping("/usuario/{id]")
    public Usuario eliminarUsuario(@PathVariable Long id){
        Usuario usuarioBD= usuarioRepository.findById(id).get();
        try{
            usuarioRepository.delete(usuarioBD);
            return usuarioBD;
        }catch (Exception e){
            return null;
        }
    }

}
