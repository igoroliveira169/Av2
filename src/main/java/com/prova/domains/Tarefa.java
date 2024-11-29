package com.prova.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prova.domains.dtos.TarefaDTO;
import com.prova.domains.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tarefa")
    private Integer idTarefa;

    @NotNull @NotBlank
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataConclusao = LocalDate.now();

    @NotNull
    private int quantidadeProduzida;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private Status status;

    @JsonIgnore
    @OneToMany(mappedBy = "tarefa")
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Tarefa() {
        this.status = Status.CONCLUIDO;
    }

    public Tarefa(Integer idTarefa, String descricao, LocalDate dataInicio, LocalDate dataConclusao, int quantidadeProduzida, Status status) {
        this.idTarefa = idTarefa;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.quantidadeProduzida = quantidadeProduzida;
        this.status = status;
    }

    public Tarefa(TarefaDTO dto){
        this.idTarefa = dto.getId();
        this.descricao = dto.getDescricao();
        this.dataInicio = dto.getDataInicio();
        this.dataConclusao = dto.getDataConclusao();
        this.quantidadeProduzida = dto.getQuantidadeProduzida();

        this.status = Status.toEnum(dto.getStatus());

    }

    public Integer getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Integer idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public int getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    public void setQuantidadeProduzida(int quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return idTarefa == tarefa.idTarefa && quantidadeProduzida == tarefa.quantidadeProduzida && Objects.equals(descricao, tarefa.descricao) && Objects.equals(dataInicio, tarefa.dataInicio) && Objects.equals(dataConclusao, tarefa.dataConclusao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarefa, descricao, dataInicio, dataConclusao, quantidadeProduzida);
    }
}
