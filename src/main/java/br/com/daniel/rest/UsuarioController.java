package br.com.daniel.rest;

import br.com.daniel.model.entity.Usuario;
import br.com.daniel.model.repository.UsuarioRepository;
import br.com.daniel.rest.exceptions.UsuarioCadastradoException;
import br.com.daniel.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
//    private final PasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario) {
//        String senhaCript = passwordEncoder.encode(usuario.getPassword());
//        usuario.setPassword(senhaCript);
        try {
            usuarioService.salvar(usuario);
        }catch (UsuarioCadastradoException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @PostMapping
    @RequestMapping("/autenticar")
    @ResponseStatus(HttpStatus.CREATED)
    public void autenticar(@RequestBody @Valid Usuario usuario) {
//        String senhaCript = passwordEncoder.encode(usuario.getPassword());
//        usuario.setPassword(senhaCript);
        usuarioService.autenticar(usuario);
    }
}
