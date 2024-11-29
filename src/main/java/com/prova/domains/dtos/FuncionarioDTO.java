package com.prova.domains.dtos;

import com.prova.domains.Funcionario;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class FuncionarioDTO {

    private Long idFuncionario;

    @NotNull(message = "O campo nome do funcionario não pode ser nulo")
    @NotBlank(message = "O campo nome do funcionario não pode estar vazio")
    private String nome;

    @NotNull(message = "O campo cpf do funcionario não pode ser nulo")
    @NotBlank(message = "O campo cpf do funcionario não pode estar vazio")
    private String cpf;

    @NotNull(message = "O campo endereço do funcionario não pode ser nulo")
    @NotBlank(message = "O campo endereço do funcionario não pode estar vazio")
    private String endereco;

    @NotNull(message = "O campo salario do funcionario não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal salario;

    @NotNull(message = "O campo cargo do funcionario não pode ser nulo")
    @NotBlank(message = "O campo cargo do funcionario não pode estar vazio")
    private String cargo;

    @NotNull(message = "O campo carga horaria do funcionario não pode ser nulo")
    private int cargaHoraria;

    @NotNull(message = "O supervisor nome do funcionario não pode ser nulo")
    @NotBlank(message = "O supervisor nome do funcionario não pode estar vazio")
    private String supervisor;

    @NotNull(message = "O campo empresa não pode ser nulo")
    private int empresa;

    @NotNull(message = "O campo tarefa não pode ser nulo")
    private int tarefa;

    private int situacao;


    public FuncionarioDTO() {}

    public FuncionarioDTO(Funcionario funcionario) {
        this.idFuncionario = funcionario.getIdFuncionario();
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.endereco = funcionario.getEndereco();
        this.salario = funcionario.getSalario();
        this.cargo = funcionario.getCargo();
        this.cargaHoraria = funcionario.getCargaHoraria();
        this.supervisor = funcionario.getSupervisor();
        this.empresa = funcionario.getEmpresa().getIdEmpresa();
        this.tarefa = funcionario.getTarefa().getIdTarefa();
        this.situacao = funcionario.getSituacao().getId();
    }


    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public @NotNull(message = "O campo nome do funcionario não pode ser nulo")
    @NotBlank(message = "O campo nome do funcionario não pode estar vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome do funcionario não pode ser nulo")
                        @NotBlank(message = "O campo nome do funcionario não pode estar vazio") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo cpf do funcionario não pode ser nulo")
    @NotBlank(message = "O campo cpf do funcionario não pode estar vazio") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo cpf do funcionario não pode ser nulo")
                       @NotBlank(message = "O campo cpf do funcionario não pode estar vazio") String cpf) {
        this.cpf = cpf;
    }

    public @NotNull(message = "O campo endereço do funcionario não pode ser nulo")
    @NotBlank(message = "O campo endereço do funcionario não pode estar vazio") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull(message = "O campo endereço do funcionario não pode ser nulo")
                            @NotBlank(message = "O campo endereço do funcionario não pode estar vazio") String endereco) {
        this.endereco = endereco;
    }

    public @NotNull(message = "O campo salario do funcionario não pode ser nulo") BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(@NotNull(message = "O campo salario do funcionario não pode ser nulo") BigDecimal salario) {
        this.salario = salario;
    }

    public @NotNull(message = "O campo cargo do funcionario não pode ser nulo")
    @NotBlank(message = "O campo cargo do funcionario não pode estar vazio") String getCargo() {
        return cargo;
    }

    public void setCargo(@NotNull(message = "O campo cargo do funcionario não pode ser nulo")
                         @NotBlank(message = "O campo cargo do funcionario não pode estar vazio") String cargo) {
        this.cargo = cargo;
    }

    public @NotNull(message = "O campo carga horaria do funcionario não pode ser nulo") int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(@NotNull(message = "O campo carga horaria do funcionario não pode ser nulo") int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public @NotNull(message = "O supervisor nome do funcionario não pode ser nulo")
    @NotBlank(message = "O supervisor nome do funcionario não pode estar vazio") String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(@NotNull(message = "O supervisor nome do funcionario não pode ser nulo")
                              @NotBlank(message = "O supervisor nome do funcionario não pode estar vazio") String supervisor) {
        this.supervisor = supervisor;
    }

    public @NotNull(message = "O campo empresa não pode ser nulo") int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(@NotNull(message = "O campo empresa não pode ser nulo") int empresa) {
        this.empresa = empresa;
    }

    public @NotNull(message = "O campo tarefa não pode ser nulo") int getTarefa() {
        return tarefa;
    }

    public void setTarefa(@NotNull(message = "O campo tarefa não pode ser nulo") int tarefa) {
        this.tarefa = tarefa;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
}
