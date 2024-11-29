package com.prova.domains.dtos;

import com.prova.domains.Empresa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmpresaDTO {

    private Integer id;

    @NotNull(message = "O campo nome da empresa não pode ser nulo")
    @NotBlank(message = "O campo nome da empresa não pode estar vazio")
    private String nomeEmpresa;

    @NotNull(message = "O campo cnpj da empresa não pode ser nulo")
    @NotBlank(message = "O campo cnpj da empresa não pode estar vazio")
    private String cnpjEmpresa;

    @NotNull(message = "O campo endereço da empresa não pode ser nulo")
    @NotBlank(message = "O campo endereço da empresa não pode estar vazio")
    private String enderecoEmpresa;

    @NotNull(message = "O campo cidade da empresa não pode ser nulo")
    @NotBlank(message = "O campo cidade da empresa não pode estar vazio")
    private String cidadeEmpresa;

    public EmpresaDTO() {}

    public EmpresaDTO(Empresa empresa) {
        this.id = empresa.getIdEmpresa();  // Aqui deve ser o ID da empresa, e não getId()
        this.nomeEmpresa = empresa.getNomeEmpresa();
        this.cnpjEmpresa = empresa.getCnpjEmpresa();
        this.enderecoEmpresa = empresa.getEnderecoEmpresa();
        this.cidadeEmpresa = empresa.getCidadeEmpresa();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome da empresa não pode ser nulo")
    @NotBlank(message = "O campo nome da empresa não pode estar vazio") String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(@NotNull(message = "O campo nome da empresa não pode ser nulo")
                               @NotBlank(message = "O campo nome da empresa não pode estar vazio") String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public @NotNull(message = "O campo cnpj da empresa não pode ser nulo")
    @NotBlank(message = "O campo cnpj da empresa não pode estar vazio") String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(@NotNull(message = "O campo cnpj da empresa não pode ser nulo")
                               @NotBlank(message = "O campo cnpj da empresa não pode estar vazio") String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public @NotNull(message = "O campo endereço da empresa não pode ser nulo")
    @NotBlank(message = "O campo endereço da empresa não pode estar vazio") String getEnderecoEmpresa() {
        return enderecoEmpresa;
    }

    public void setEnderecoEmpresa(@NotNull(message = "O campo endereço da empresa não pode ser nulo")
                                   @NotBlank(message = "O campo endereço da empresa não pode estar vazio") String enderecoEmpresa) {
        this.enderecoEmpresa = enderecoEmpresa;
    }

    public @NotNull(message = "O campo cidade da empresa não pode ser nulo")
    @NotBlank(message = "O campo cidade da empresa não pode estar vazio") String getCidadeEmpresa() {
        return cidadeEmpresa;
    }

    public void setCidadeEmpresa(@NotNull(message = "O campo cidade da empresa não pode ser nulo")
                                 @NotBlank(message = "O campo cidade da empresa não pode estar vazio") String cidadeEmpresa) {
        this.cidadeEmpresa = cidadeEmpresa;
    }
}
