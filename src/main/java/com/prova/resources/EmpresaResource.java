package com.prova.resources;

import com.prova.domains.Empresa;
import com.prova.domains.dtos.EmpresaDTO;
import com.prova.domains.dtos.FuncionarioDTO;
import com.prova.domains.dtos.TarefaDTO;
import com.prova.services.EmpresaService;
import com.prova.services.FuncionarioService;
import com.prova.services.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/empresa")
public class EmpresaResource {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> findAll() {
        return ResponseEntity.ok().body(empresaService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmpresaDTO> findById(@PathVariable Integer id){
        Empresa obj = this.empresaService.findbyId(id);
        return ResponseEntity.ok().body(new EmpresaDTO(obj));
    }
    @GetMapping(value = "/cnpj/{cnpjEmpresa}")
    public ResponseEntity<EmpresaDTO> findByCnpjEmpresa(@PathVariable String cnpjEmpresa){
        Empresa obj = this.empresaService.findbyCnpjEmpresa(cnpjEmpresa);
        return ResponseEntity.ok().body(new EmpresaDTO(obj));
    }
    @PostMapping
    public ResponseEntity<EmpresaDTO> create(@Valid @RequestBody EmpresaDTO dto){
        Empresa empresa = empresaService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(empresa.getIdEmpresa()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<EmpresaDTO> update(@PathVariable Integer id, @Valid @RequestBody EmpresaDTO objDto){
        Empresa obj = empresaService.update(id, objDto);
        return ResponseEntity.ok().body(new EmpresaDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EmpresaDTO> delete(@PathVariable Integer id){
        empresaService.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
