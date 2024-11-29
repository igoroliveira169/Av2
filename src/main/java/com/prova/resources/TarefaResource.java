package com.prova.resources;

import com.prova.domains.Empresa;
import com.prova.domains.Tarefa;
import com.prova.domains.dtos.EmpresaDTO;
import com.prova.domains.dtos.TarefaDTO;
import com.prova.services.TarefaService;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (value="/tarefa")
public class TarefaResource {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> findAll() {
        return ResponseEntity.ok().body(tarefaService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<TarefaDTO> findById(@PathVariable Integer id){
        Tarefa obj = this.tarefaService.findbyId(id);
        return ResponseEntity.ok().body(new TarefaDTO(obj));
    }
    @PostMapping
    public ResponseEntity<TarefaDTO> create(@Valid @RequestBody TarefaDTO dto){
        Tarefa tarefa = tarefaService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(tarefa.getIdTarefa()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TarefaDTO> delete(@PathVariable Integer id){
        tarefaService.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
