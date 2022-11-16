package br.com.daniel.rest.dto;

import br.com.daniel.model.entity.Cliente;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServicoPrestadoDTO {

    @NotEmpty(message = "{campo.servico.descricao.obrigatorio}")
    private String descricao;

    @NotEmpty(message = "{campo.servico.valor.obrigatorio}")
    private String valor;

    @NotEmpty(message = "{campo.servico.data.obrigatorio}")
    private String data;

    @NotNull(message = "{campo.servico.cliente.obrigatorio}")
    private Cliente Cliente;
}
