/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Murilo
 */
public class ConsAuditoria {
    private int codigo;
    private Date datahora;
    private String acao;
    private String valorAnterior;
    private String valorPosterior;
    private int usuario_codigo;

    public ConsAuditoria(int codigo, Date datahora, String acao, String valorAnterior, String valorPosterior, int usuario_codigo) {
        this.codigo = codigo;
        this.datahora = datahora;
        this.acao = acao;
        this.valorAnterior = valorAnterior;
        this.valorPosterior = valorPosterior;
        this.usuario_codigo = usuario_codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public String getValorPosterior() {
        return valorPosterior;
    }

    public void setValorPosterior(String valorPosterior) {
        this.valorPosterior = valorPosterior;
    }

    public int getUsuario_codigo() {
        return usuario_codigo;
    }

    public void setUsuario_codigo(int usuario_codigo) {
        this.usuario_codigo = usuario_codigo;
    }            
}
