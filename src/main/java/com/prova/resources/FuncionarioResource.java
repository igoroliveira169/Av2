package com.prova.resources;

import com.prova.domains.Empresa;
import com.prova.domains.Funcionario;
import com.prova.domains.dtos.EmpresaDTO;
import com.prova.domains.dtos.FuncionarioDTO;
import com.prova.services.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> findAll() {
        return ResponseEntity.ok().body(funcionarioService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id){
        Funcionario obj = this.funcionarioService.findbyId(id);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }
    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<FuncionarioDTO> findbyCpf(@PathVariable String cpf){
        Funcionario obj = this.funcionarioService.findbyCpf(cpf);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }
    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@Valid @RequestBody FuncionarioDTO dto){
        Funcionario funcionario = funcionarioService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(funcionario.getIdFuncionario()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @Valid @RequestBody FuncionarioDTO objDto){
        Funcionario Obj = funcionarioService.update(id, objDto);
        return ResponseEntity.ok().body(new FuncionarioDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> delete(@PathVariable Long id){
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}