package com.utn.frm.desarrollosoftware.entities;

import java.time.LocalDateTime;

public class Base {
    private Long id;
    private boolean eliminado;
    private LocalDateTime createdAt;

    public Base(Long id) {
        this.id = id;
        this.eliminado = false;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
}
