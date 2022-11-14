package br.com.daniel.rest;

import br.com.daniel.model.entity.Cliente;
import br.com.daniel.model.entity.ServicoPrestado;
import br.com.daniel.model.repository.ClienteRepository;
import br.com.daniel.model.repository.ServicoPrestadoRepository;
import br.com.daniel.rest.dto.ServicoPrestadoDTO;
import br.com.daniel.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor  //Ele instancia como @autowired todos atributos como final
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final BigDecimalConverter bigDecimalConverter;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto){
        LocalDate data =LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Optional<Cliente> opCliente = clienteRepository.findById(dto.getIdCliente());
        Cliente cliente = opCliente.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cliente Inexistente!"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));

        return servicoPrestadoRepository.save(servicoPrestado);
    }

    public List<ServicoPrestado> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ){
        return servicoPrestadoRepository.findByNomeClienteAndMes("%"+nome+"%", mes);

    }

//    @GetMapping("{id}")
//    public ServicoPrestado findById(@PathVariable Integer id){
//        return servicoPrestadoRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço Prestado não encontrado!"));
//    }
//    @GetMapping
//    public List<ServicoPrestado> findAll(){
//        return servicoPrestadoRepository.findAll();
//    }
//
//    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deletar(@PathVariable Integer id){
//        servicoPrestadoRepository.findById(id).map(ServicoPrestado -> {
//            servicoPrestadoRepository.delete(ServicoPrestado);
//            return Void.TYPE;
//        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço Prestado não encontrado!"));
//    }
//
//    @PutMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void atualizar(@PathVariable Integer id, @RequestBody @Valid ServicoPrestado servicoPrestadoAtualizado){
//        servicoPrestadoRepository.findById(id).map(servicoPrestado -> {
//            servicoPrestado.setCliente(servicoPrestadoAtualizado.getCliente());
//            servicoPrestado.setDescricao(servicoPrestadoAtualizado.getDescricao());
//            servicoPrestado.setData(servicoPrestadoAtualizado.getData());
//            servicoPrestado.setValor(servicoPrestadoAtualizado.getValor());
//            return servicoPrestadoRepository.save(servicoPrestado);
//        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }

}
