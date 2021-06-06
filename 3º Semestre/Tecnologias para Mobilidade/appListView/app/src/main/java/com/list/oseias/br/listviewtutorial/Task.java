package com.list.oseias.br.listviewtutorial;

import java.util.Date;

/**
 * Created by Escola on 24/06/2016.
 */
public class Task {

    private String descricao;
    private Date dtaFinal;

    public Date getDtaFinal() {
        return dtaFinal;
    }

    public void setDtaFinal(Date dtaFinal) {
        this.dtaFinal = dtaFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
