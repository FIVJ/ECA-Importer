package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "PBF_PAGAMENTOS")
@XmlRootElement
public class PbfPagamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPbfPagamentos")
    private Long idPbfPagamentos;
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

    public PbfPagamentos() {
    }

    public PbfPagamentos(Long idPbfPagamentos) {
        this.idPbfPagamentos = idPbfPagamentos;
    }

    public Long getIdPbfPagamentos() {
        return idPbfPagamentos;
    }

    public void setIdPbfPagamentos(Long idPbfPagamentos) {
        this.idPbfPagamentos = idPbfPagamentos;
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
        hash += (idPbfPagamentos != null ? idPbfPagamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PbfPagamentos)) {
            return false;
        }
        PbfPagamentos other = (PbfPagamentos) object;
        if ((this.idPbfPagamentos == null && other.idPbfPagamentos != null) || (this.idPbfPagamentos != null && !this.idPbfPagamentos.equals(other.idPbfPagamentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PbfPagamentos[ idPbfPagamentos=" + idPbfPagamentos + " ]";
    }

}
