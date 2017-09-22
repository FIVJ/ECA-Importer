/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "PBF_PAGAMENTOS_2013")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PbfPagamentos2013.findAll", query = "SELECT p FROM PbfPagamentos2013 p")
    , @NamedQuery(name = "PbfPagamentos2013.findByIdPBFPAGAMENTOS", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.idPBFPAGAMENTOS = :idPBFPAGAMENTOS")
    , @NamedQuery(name = "PbfPagamentos2013.findByUf", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.uf = :uf")
    , @NamedQuery(name = "PbfPagamentos2013.findByCodigoSIAFIMunicipio", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.codigoSIAFIMunicipio = :codigoSIAFIMunicipio")
    , @NamedQuery(name = "PbfPagamentos2013.findByNomeMunicipio", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.nomeMunicipio = :nomeMunicipio")
    , @NamedQuery(name = "PbfPagamentos2013.findByCodigoFuncao", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.codigoFuncao = :codigoFuncao")
    , @NamedQuery(name = "PbfPagamentos2013.findByCodigoSubfuncao", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.codigoSubfuncao = :codigoSubfuncao")
    , @NamedQuery(name = "PbfPagamentos2013.findByCodigoPrograma", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.codigoPrograma = :codigoPrograma")
    , @NamedQuery(name = "PbfPagamentos2013.findByCodigoAcao", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.codigoAcao = :codigoAcao")
    , @NamedQuery(name = "PbfPagamentos2013.findByNISFavorecido", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.nISFavorecido = :nISFavorecido")
    , @NamedQuery(name = "PbfPagamentos2013.findByNomeFavorecido", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.nomeFavorecido = :nomeFavorecido")
    , @NamedQuery(name = "PbfPagamentos2013.findByFonteFinalidade", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.fonteFinalidade = :fonteFinalidade")
    , @NamedQuery(name = "PbfPagamentos2013.findByValorParcela", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.valorParcela = :valorParcela")
    , @NamedQuery(name = "PbfPagamentos2013.findByMesCompetencia", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.mesCompetencia = :mesCompetencia")
    , @NamedQuery(name = "PbfPagamentos2013.findByAnoCompetencia", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.anoCompetencia = :anoCompetencia")
    , @NamedQuery(name = "PbfPagamentos2013.findByAtualizacao", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.atualizacao = :atualizacao")
    , @NamedQuery(name = "PbfPagamentos2013.findByOrigem", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.origem = :origem")
    , @NamedQuery(name = "PbfPagamentos2013.findByArquivo", query = "SELECT p FROM PbfPagamentos2013 p WHERE p.arquivo = :arquivo")})
public class PbfPagamentos2013 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPBF_PAGAMENTOS")
    private Long idPBFPAGAMENTOS;
    @Column(name = "UF")
    private String uf;
    @Column(name = "Codigo_SIAFI_Municipio")
    private Integer codigoSIAFIMunicipio;
    @Column(name = "Nome_Municipio")
    private String nomeMunicipio;
    @Column(name = "Codigo_Funcao")
    private Integer codigoFuncao;
    @Column(name = "Codigo_Subfuncao")
    private Integer codigoSubfuncao;
    @Column(name = "Codigo_Programa")
    private Integer codigoPrograma;
    @Column(name = "Codigo_Acao")
    private Integer codigoAcao;
    @Column(name = "NIS_Favorecido")
    private String nISFavorecido;
    @Column(name = "Nome_Favorecido")
    private String nomeFavorecido;
    @Column(name = "Fonte_Finalidade")
    private String fonteFinalidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor_Parcela")
    private Double valorParcela;
    @Column(name = "Mes_Competencia")
    private String mesCompetencia;
    @Column(name = "Ano_Competencia")
    private String anoCompetencia;
    @Column(name = "Atualizacao")
    private String atualizacao;
    @Column(name = "Origem")
    private String origem;
    @Column(name = "Arquivo")
    private String arquivo;

    public PbfPagamentos2013() {
    }

    public PbfPagamentos2013(Long idPBFPAGAMENTOS) {
        this.idPBFPAGAMENTOS = idPBFPAGAMENTOS;
    }

    public Long getIdPBFPAGAMENTOS() {
        return idPBFPAGAMENTOS;
    }

    public void setIdPBFPAGAMENTOS(Long idPBFPAGAMENTOS) {
        this.idPBFPAGAMENTOS = idPBFPAGAMENTOS;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getCodigoSIAFIMunicipio() {
        return codigoSIAFIMunicipio;
    }

    public void setCodigoSIAFIMunicipio(Integer codigoSIAFIMunicipio) {
        this.codigoSIAFIMunicipio = codigoSIAFIMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Integer getCodigoFuncao() {
        return codigoFuncao;
    }

    public void setCodigoFuncao(Integer codigoFuncao) {
        this.codigoFuncao = codigoFuncao;
    }

    public Integer getCodigoSubfuncao() {
        return codigoSubfuncao;
    }

    public void setCodigoSubfuncao(Integer codigoSubfuncao) {
        this.codigoSubfuncao = codigoSubfuncao;
    }

    public Integer getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(Integer codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public Integer getCodigoAcao() {
        return codigoAcao;
    }

    public void setCodigoAcao(Integer codigoAcao) {
        this.codigoAcao = codigoAcao;
    }

    public String getNISFavorecido() {
        return nISFavorecido;
    }

    public void setNISFavorecido(String nISFavorecido) {
        this.nISFavorecido = nISFavorecido;
    }

    public String getNomeFavorecido() {
        return nomeFavorecido;
    }

    public void setNomeFavorecido(String nomeFavorecido) {
        this.nomeFavorecido = nomeFavorecido;
    }

    public String getFonteFinalidade() {
        return fonteFinalidade;
    }

    public void setFonteFinalidade(String fonteFinalidade) {
        this.fonteFinalidade = fonteFinalidade;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getMesCompetencia() {
        return mesCompetencia;
    }

    public void setMesCompetencia(String mesCompetencia) {
        this.mesCompetencia = mesCompetencia;
    }

    public String getAnoCompetencia() {
        return anoCompetencia;
    }

    public void setAnoCompetencia(String anoCompetencia) {
        this.anoCompetencia = anoCompetencia;
    }

    public String getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(String atualizacao) {
        this.atualizacao = atualizacao;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPBFPAGAMENTOS != null ? idPBFPAGAMENTOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PbfPagamentos2013)) {
            return false;
        }
        PbfPagamentos2013 other = (PbfPagamentos2013) object;
        if ((this.idPBFPAGAMENTOS == null && other.idPBFPAGAMENTOS != null) || (this.idPBFPAGAMENTOS != null && !this.idPBFPAGAMENTOS.equals(other.idPBFPAGAMENTOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PbfPagamentos2013[ idPBFPAGAMENTOS=" + idPBFPAGAMENTOS + " ]";
    }
    
}
