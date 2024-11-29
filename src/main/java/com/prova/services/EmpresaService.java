package com.prova.services;

import com.prova.domains.Empresa;
import com.prova.domains.dtos.EmpresaDTO;
import com.prova.repositories.EmpresaRepository;
import com.prova.services.exceptions.DataIntegrityViolationException;
import com.prova.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepo;

    public List<EmpresaDTO> findAll(){
        //retorna uma lista de GrupoProdutoDRO
        return empresaRepo.findAll().stream()
                .map(obj -> new EmpresaDTO(obj))
                .collect(Collectors.toList());
    }

    public Empresa findbyId(int id){
        Optional<Empresa> obj = empresaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Empresa não encontrada! ID: " + id));
    }
    public Empresa findbyCnpjEmpresa(String cnpjEmpresa){
        Optional<Empresa> obj = empresaRepo.findByCnpjEmpresa(cnpjEmpresa);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Empresa não encontrada! CNPJ: " + cnpjEmpresa));
    }
    public Empresa create(EmpresaDTO dto){
        dto.setId(null);
        Empresa obj = new Empresa(dto);
        return empresaRepo.save(obj);
    }
    public Empresa update(Integer id, EmpresaDTO objDto){
        objDto.setId(id);
        Empresa oldObj = findbyId(id);
        oldObj = new Empresa(objDto);
        return empresaRepo.save(oldObj);
    }
    public void delete(Integer id){
        Empresa obj = findbyId(id);
        if (obj.getFuncionarios().size()>0){
            throw new DataIntegrityViolationException("Empresa não pode ser deletada, pois tem um funcionario vinculado ");
        }
        empresaRepo.deleteById(id);
    }
}
