package br.com.daniel.rest;

import br.com.daniel.model.entity.Usuario;
import br.com.daniel.model.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
//    private final PasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario) {
//        String senhaCript = passwordEncoder.encode(usuario.getPassword());
//        usuario.setPassword(senhaCript);
        usuarioRepository.save(usuario);
    }

    @PostMapping
    @RequestMapping("/autenticar")
    @ResponseStatus(HttpStatus.CREATED)
    public void autenticar(@RequestBody @Valid Usuario usuario) {
//        String senhaCript = passwordEncoder.encode(usuario.getPassword());
//        usuario.setPassword(senhaCript);
        usuarioRepository.save(usuario);
    }
}
