package com.prova.services;

import com.prova.domains.Empresa;
import com.prova.domains.Tarefa;
import com.prova.domains.dtos.EmpresaDTO;
import com.prova.domains.dtos.TarefaDTO;
import com.prova.repositories.TarefaRepository;
import com.prova.services.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepo;

    public List<TarefaDTO> findAll(){
        //retorna uma lista de GrupoProdutoDRO
        return tarefaRepo.findAll().stream()
                .map(obj -> new TarefaDTO(obj))
                .collect(Collectors.toList());
    }
    public Tarefa findbyId(int id){
        Optional<Tarefa> obj = tarefaRepo.findById(id);
        return obj.orElse(null);
    }
    public Tarefa create(TarefaDTO dto){
        dto.setId(null);
        Tarefa obj = new Tarefa(dto);
        return tarefaRepo.save(obj);
    }
    public Tarefa update(Integer id, TarefaDTO objDto){
        objDto.setId(id);
        Tarefa oldObj = findbyId(id);
        oldObj = new Tarefa(objDto);
        return tarefaRepo.save(oldObj);
    }
    public void delete(Integer id){
        Tarefa obj = findbyId(id);
        if (obj.getFuncionarios().size()>0){
            throw new DataIntegrityViolationException("Tarefa não pode ser deletada, pois tem um funcionario vinculado ");
        }
        tarefaRepo.deleteById(id);
    }

}
