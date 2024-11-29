package com.prova.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prova.domains.dtos.EmpresaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empresa")
    private Integer idEmpresa;

    @NotNull @NotBlank
    private String nomeEmpresa;

    @NotNull @NotBlank
    @Column(unique = true)
    private String cnpjEmpresa;

    @NotNull @NotBlank
    private String enderecoEmpresa;

    @NotNull @NotBlank
    private String cidadeEmpresa;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Funcionario> funcionarios = new ArrayList<>();

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Empresa() {
    }

    public Empresa(Integer idEmpresa, String nomeEmpresa, String enderecoEmpresa, String cnpjEmpresa, String cidadeEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.enderecoEmpresa = enderecoEmpresa;
        this.cnpjEmpresa = cnpjEmpresa;
        this.cidadeEmpresa = cidadeEmpresa;
    }

    public Empresa(EmpresaDTO dto){
        this.cidadeEmpresa = dto.getCidadeEmpresa();
        this.cnpjEmpresa = dto.getCnpjEmpresa();
        this.enderecoEmpresa = dto.getEnderecoEmpresa();
        this.nomeEmpresa = dto.getNomeEmpresa();
        this.idEmpresa = dto.getId();
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public String getEnderecoEmpresa() {
        return enderecoEmpresa;
    }

    public void setEnderecoEmpresa(String enderecoEmpresa) {
        this.enderecoEmpresa = enderecoEmpresa;
    }

    public String getCidadeEmpresa() {
        return cidadeEmpresa;
    }

    public void setCidadeEmpresa(String cidadeEmpresa) {
        this.cidadeEmpresa = cidadeEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return idEmpresa == empresa.idEmpresa && Objects.equals(nomeEmpresa, empresa.nomeEmpresa) && Objects.equals(cnpjEmpresa, empresa.cnpjEmpresa) && Objects.equals(enderecoEmpresa, empresa.enderecoEmpresa) && Objects.equals(cidadeEmpresa, empresa.cidadeEmpresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, nomeEmpresa, cnpjEmpresa, enderecoEmpresa, cidadeEmpresa);
    }
}
