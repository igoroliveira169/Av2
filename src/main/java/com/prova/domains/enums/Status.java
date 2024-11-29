package com.prova.domains.enums;

public enum Status {
    PENDENTE(0, "PENDENTE"), CONCLUIDO(1, "CONCLUIDO"), ANDAMENTO(2, "EM ANDAMENTO");

    private Integer id;
    private String status;

    Status(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public static Status toEnum(Integer id) {
        if (id == null) return null;
        for (Status x : Status.values()) {
            if (id.equals(x.getId())) {
                return x;

            }
        }

        throw new IllegalArgumentException("Status invalido");
    }
}
