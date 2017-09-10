/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "PBF_SAQUES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PbfSaques.findAll", query = "SELECT p FROM PbfSaques p")
    , @NamedQuery(name = "PbfSaques.findByIdPBFSAQUES", query = "SELECT p FROM PbfSaques p WHERE p.idPBFSAQUES = :idPBFSAQUES")
    , @NamedQuery(name = "PbfSaques.findByUf", query = "SELECT p FROM PbfSaques p WHERE p.uf = :uf")
    , @NamedQuery(name = "PbfSaques.findByCodigoSIAFIMunicipio", query = "SELECT p FROM PbfSaques p WHERE p.codigoSIAFIMunicipio = :codigoSIAFIMunicipio")
    , @NamedQuery(name = "PbfSaques.findByNomeMunicipio", query = "SELECT p FROM PbfSaques p WHERE p.nomeMunicipio = :nomeMunicipio")
    , @NamedQuery(name = "PbfSaques.findByCodigoFuncao", query = "SELECT p FROM PbfSaques p WHERE p.codigoFuncao = :codigoFuncao")
    , @NamedQuery(name = "PbfSaques.findByCodigoSubfuncao", query = "SELECT p FROM PbfSaques p WHERE p.codigoSubfuncao = :codigoSubfuncao")
    , @NamedQuery(name = "PbfSaques.findByCodigoPrograma", query = "SELECT p FROM PbfSaques p WHERE p.codigoPrograma = :codigoPrograma")
    , @NamedQuery(name = "PbfSaques.findByCodigoAcao", query = "SELECT p FROM PbfSaques p WHERE p.codigoAcao = :codigoAcao")
    , @NamedQuery(name = "PbfSaques.findByNISFavorecido", query = "SELECT p FROM PbfSaques p WHERE p.nISFavorecido = :nISFavorecido")
    , @NamedQuery(name = "PbfSaques.findByNomeFavorecido", query = "SELECT p FROM PbfSaques p WHERE p.nomeFavorecido = :nomeFavorecido")
    , @NamedQuery(name = "PbfSaques.findByFonteFinalidade", query = "SELECT p FROM PbfSaques p WHERE p.fonteFinalidade = :fonteFinalidade")
    , @NamedQuery(name = "PbfSaques.findByMesReferenciaParcela", query = "SELECT p FROM PbfSaques p WHERE p.mesReferenciaParcela = :mesReferenciaParcela")
    , @NamedQuery(name = "PbfSaques.findByValorParcela", query = "SELECT p FROM PbfSaques p WHERE p.valorParcela = :valorParcela")
    , @NamedQuery(name = "PbfSaques.findByMesCompetencia", query = "SELECT p FROM PbfSaques p WHERE p.mesCompetencia = :mesCompetencia")
    , @NamedQuery(name = "PbfSaques.findByAnoCompetencia", query = "SELECT p FROM PbfSaques p WHERE p.anoCompetencia = :anoCompetencia")
    , @NamedQuery(name = "PbfSaques.findByDataSaque", query = "SELECT p FROM PbfSaques p WHERE p.dataSaque = :dataSaque")})
public class PbfSaques implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPBF_SAQUES")
    private Long idPBFSAQUES;
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
    @Column(name = "Mes_Referencia_Parcela")
    private String mesReferenciaParcela;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor_Parcela")
    private Double valorParcela;
    @Column(name = "Mes_Competencia")
    private String mesCompetencia;
    @Column(name = "Ano_Competencia")
    private String anoCompetencia;
    @Column(name = "Data_Saque")
    @Temporal(TemporalType.DATE)
    private Date dataSaque;

    public PbfSaques() {
    }

    public PbfSaques(Long idPBFSAQUES) {
        this.idPBFSAQUES = idPBFSAQUES;
    }

    public Long getIdPBFSAQUES() {
        return idPBFSAQUES;
    }

    public void setIdPBFSAQUES(Long idPBFSAQUES) {
        this.idPBFSAQUES = idPBFSAQUES;
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

    public String getMesReferenciaParcela() {
        return mesReferenciaParcela;
    }

    public void setMesReferenciaParcela(String mesReferenciaParcela) {
        this.mesReferenciaParcela = mesReferenciaParcela;
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

    public Date getDataSaque() {
        return dataSaque;
    }

    public void setDataSaque(Date dataSaque) {
        this.dataSaque = dataSaque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPBFSAQUES != null ? idPBFSAQUES.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PbfSaques)) {
            return false;
        }
        PbfSaques other = (PbfSaques) object;
        if ((this.idPBFSAQUES == null && other.idPBFSAQUES != null) || (this.idPBFSAQUES != null && !this.idPBFSAQUES.equals(other.idPBFSAQUES))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PbfSaques[ idPBFSAQUES=" + idPBFSAQUES + " ]";
    }
    
}