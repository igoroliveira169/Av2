package com.prova.services;

import com.prova.domains.Empresa;
import com.prova.domains.Funcionario;
import com.prova.domains.Tarefa;
import com.prova.domains.dtos.EmpresaDTO;
import com.prova.domains.dtos.FuncionarioDTO;  // Adicione esta linha de importação
import com.prova.repositories.EmpresaRepository;
import com.prova.repositories.FuncionarioRepository;
import com.prova.repositories.TarefaRepository;
import com.prova.services.exceptions.DataIntegrityViolationException;
import com.prova.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private EmpresaRepository empresaRepo;

    @Autowired
    private TarefaRepository tarefaRepo;

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    public List<FuncionarioDTO> findAll() {
        // Retorna uma lista de FuncionarioDTO
        return funcionarioRepo.findAll().stream()
                .map(obj -> new FuncionarioDTO(obj))
                .collect(Collectors.toList());
    }
    public Funcionario findbyId(long id){
        Optional<Funcionario> obj = funcionarioRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Funcionario não encontrada! ID: " + id));
    }
    public Funcionario findbyCpf(String cpf){
        Optional<Funcionario> obj = funcionarioRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Funcionario não encontrada! CPF: " + cpf));
    }
    public Funcionario create(FuncionarioDTO dto){
        dto.setIdFuncionario(null);
        validaFuncionario(dto);
        Funcionario obj = new Funcionario(dto);
        return funcionarioRepo.save(obj);
    }
    private void validaFuncionario(FuncionarioDTO dto) {
        Optional<Funcionario> obj = funcionarioRepo.findByCpf(dto.getCpf());
        if (obj.isPresent() && obj.get().getIdFuncionario() != dto.getIdFuncionario()) {
            throw new DataIntegrityViolationException("CPF já cadastrado.");
        }

        Optional<Empresa> empresa = empresaRepo.findByCnpjEmpresa(String.valueOf(dto.getEmpresa()));
        if (!empresa.isPresent()) {
            throw new DataIntegrityViolationException("Empresa - " + dto.getEmpresa() + " não está cadastrada.");
        }

        Optional<Tarefa> tarefa = tarefaRepo.findById(dto.getTarefa());
        if(!tarefa.isPresent()){
            throw new DataIntegrityViolationException("Tarefa - " + dto.getTarefa() + " não está cadastrada.");
        }

    }
    public Funcionario update(Long id, FuncionarioDTO objDto){
        objDto.setIdFuncionario(id);
        Funcionario oldObj = findbyId(id);
        validaFuncionario(objDto);
        oldObj = new Funcionario(objDto);
        return funcionarioRepo.save(oldObj);
    }
    public void delete(Long id){
        Funcionario obj = findbyId(id);
        funcionarioRepo.deleteById(id);
    }


}
