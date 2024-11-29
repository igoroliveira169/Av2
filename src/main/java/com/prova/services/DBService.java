package com.prova.services;

import com.prova.domains.Empresa;
import com.prova.domains.Funcionario;
import com.prova.domains.Tarefa;
import com.prova.domains.enums.Situacao;
import com.prova.domains.enums.Status;
import com.prova.repositories.EmpresaRepository;
import com.prova.repositories.FuncionarioRepository;
import com.prova.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private TarefaRepository tarefaRepo;

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    @Autowired
    private EmpresaRepository empresaRepo;

    public void initDB(){

        Tarefa tarefa01 = new Tarefa(null,"Teste", LocalDate.now(),LocalDate.now(),25, Status.CONCLUIDO);
        tarefaRepo.save(tarefa01);
        Tarefa tarefa02 = new Tarefa(null,"Teste2", LocalDate.now(),LocalDate.now(),25, Status.CONCLUIDO);
        tarefaRepo.save(tarefa02);
        Tarefa tarefa03 = new Tarefa(null,"Teste3", LocalDate.now(),LocalDate.now(),25, Status.CONCLUIDO);
        tarefaRepo.save(tarefa03);


        Empresa empresa01 = new Empresa(null,"AssuntosLGA","Rua Logo Ali","1111","Fernandópolis");
        empresaRepo.save(empresa01);
        Empresa empresa02 = new Empresa(null,"AssuntwdfewwfeosLGA","Rua Logo Ali","2222","Fernandópolis");
        empresaRepo.save(empresa02);
        Empresa empresa03 = new Empresa(null,"wefawf","Rua Logo Ali","3333","Fernandópolis");
        empresaRepo.save(empresa03);

        Funcionario funcionario01 = new Funcionario(null,"Igor","1212","Rua Quinto dos Inferno",new BigDecimal(3000),
                "Limpador",50,"Pedro", Situacao.ATIVO,empresa01,tarefa02);
        funcionarioRepo.save(funcionario01);
        Funcionario funcionario02 = new Funcionario(null,"sadsff","2121","Rua Quinto dos Inferno",new BigDecimal(3000),
                "Limpador",50,"Pedro", Situacao.ATIVO,empresa02,tarefa03);
        funcionarioRepo.save(funcionario02);
        Funcionario funcionario03 = new Funcionario(null,"dade","1313","Rua Quinto dos Inferno",new BigDecimal(3000),
                "Limpador",50,"Pedro", Situacao.ATIVO,empresa03,tarefa01);
        funcionarioRepo.save(funcionario03);



    }
}
