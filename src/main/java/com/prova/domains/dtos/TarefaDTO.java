package com.prova.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prova.domains.Tarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TarefaDTO {

    private Integer id;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataConclusao;

    @NotNull(message = "O campo quantidade produzida não pode ser nulo")
    private int quantidadeProduzida;

    private int status;

    public TarefaDTO() {
    }

    public TarefaDTO(Tarefa tarefa) {
        this.id = tarefa.getIdTarefa(); // Supondo que o Tarefa tem um método getId() para obter o ID da tarefa
        this.descricao = tarefa.getDescricao(); // Supondo que o Tarefa tem um método getDescricao() para a descrição
        this.dataInicio = tarefa.getDataInicio(); // Supondo que o Tarefa tem um método getDataInicio() para a data de início
        this.dataConclusao = tarefa.getDataConclusao(); // Supondo que o Tarefa tem um método getDataConclusao() para a data de conclusão
        this.quantidadeProduzida = tarefa.getQuantidadeProduzida(); // Supondo que o Tarefa tem um método getQuantidadeProduzida() para a quantidade
        this.status = tarefa.getStatus().getId(); // Supondo que o Tarefa tem um método getStatus() para o status
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descrição não pode ser nulo")
                             @NotBlank(message = "O campo descrição não pode estar vazio") String descricao) {
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

    public @NotNull(message = "O campo quantidade produzida não pode ser nulo") int getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    public void setQuantidadeProduzida(@NotNull(message = "O campo quantidade produzida não pode ser nulo") int quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
