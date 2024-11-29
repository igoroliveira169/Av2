package com.prova.domains;

import com.prova.domains.dtos.FuncionarioDTO;
import com.prova.domains.enums.Situacao;
import com.prova.domains.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_funcionario")
    private Long idFuncionario;

    @NotNull @NotBlank
    private String nome;

    @NotNull @NotBlank
    @Column(unique = true)
    private String cpf;

    @NotNull @NotBlank
    private String endereco;

    @NotNull
    @Digits(integer = 15, fraction = 3)
    private BigDecimal salario;

    @NotBlank @NotNull
    private String cargo;

    @NotNull
    private int cargaHoraria;

    @NotNull @NotBlank
    private String supervisor;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "situação")
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "idtarefa")
    private Tarefa tarefa;

    public Funcionario() {
        this.situacao = Situacao.ATIVO;
        this.salario = BigDecimal.ZERO;
    }

    public Funcionario(Long idFuncionario, String nome, String cpf, String endereco, BigDecimal salario, String cargo, int cargaHoraria, String supervisor, Situacao situacao, Empresa empresa, Tarefa tarefa) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.salario = salario;
        this.cargo = cargo;
        this.cargaHoraria = cargaHoraria;
        this.supervisor = supervisor;
        this.situacao = situacao;
        this.empresa = empresa;
        this.tarefa = tarefa;
    }
    public Funcionario(FuncionarioDTO dto){
        this.idFuncionario = dto.getIdFuncionario();
        this.cpf = dto.getCpf();
        this.nome = dto.getNome();
        this.salario = dto.getSalario();
        this.cargo = dto.getCargo();
        this.cargaHoraria = dto.getCargaHoraria();
        this.endereco = dto.getEndereco();
        this.supervisor = dto.getSupervisor();

        this.empresa = new Empresa();
        this.empresa.setIdEmpresa(dto.getEmpresa());
        this.tarefa = new Tarefa();
        this.tarefa.setIdTarefa(dto.getTarefa());
        this.situacao = Situacao.toEnum(dto.getSituacao());
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public @NotBlank @NotNull String getNome() {
        return nome;
    }

    public void setNome(@NotBlank @NotNull String nome) {
        this.nome = nome;
    }

    public @NotBlank @NotNull String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank @NotNull String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank @NotNull String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotBlank @NotNull String endereco) {
        this.endereco = endereco;
    }

    public @NotNull @Digits(integer = 15, fraction = 2) BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(@NotNull @Digits(integer = 15, fraction = 2)BigDecimal salario) {
        this.salario = salario;
    }

    public @NotBlank @NotNull String getCargo() {
        return cargo;
    }

    public void setCargo(@NotBlank @NotNull String cargo) {
        this.cargo = cargo;
    }

    public @NotNull int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(@NotNull int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public @NotBlank @NotNull String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(@NotBlank @NotNull String supervisor) {
        this.supervisor = supervisor;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return idFuncionario == that.idFuncionario && cargaHoraria == that.cargaHoraria && Objects.equals(nome, that.nome) && Objects.equals(cpf, that.cpf) && Objects.equals(endereco, that.endereco) && Objects.equals(salario, that.salario) && Objects.equals(cargo, that.cargo) && Objects.equals(supervisor, that.supervisor) && situacao == that.situacao && Objects.equals(empresa, that.empresa) && Objects.equals(tarefa, that.tarefa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFuncionario, nome, cpf, endereco, salario, cargo, cargaHoraria, supervisor, situacao, empresa, tarefa);
    }
}