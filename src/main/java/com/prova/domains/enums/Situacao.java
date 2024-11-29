package com.prova.domains.enums;

public enum Situacao {
    DESLIGADO(0, "INATIVO"), ATIVO(1, "ATIVO"), LICENÇA(2, "EM LICENÇA");

    private Integer id;
    private String situacao;

    Situacao(Integer id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public static Situacao toEnum(Integer id) {
        if (id == null) return null;
        for (Situacao x : Situacao.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Situação invalida");
    }
}
