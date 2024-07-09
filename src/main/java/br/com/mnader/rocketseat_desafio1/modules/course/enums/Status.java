package br.com.mnader.rocketseat_desafio1.modules.course.enums;

public enum Status { 
    ACTIVE(true), 
    INACTIVE(false);

    private boolean value;

    Status(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}
