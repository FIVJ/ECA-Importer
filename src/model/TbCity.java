/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "tb_city")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCity.findAll", query = "SELECT t FROM TbCity t")
    , @NamedQuery(name = "TbCity.findByStrNameCity", query = "SELECT t FROM TbCity t WHERE t.strNameCity = :strNameCity")
    , @NamedQuery(name = "TbCity.findByIntCodSiafiCity", query = "SELECT t FROM TbCity t WHERE t.intCodSiafiCity = :intCodSiafiCity")})
public class TbCity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "str_name_city")
    private String strNameCity;
    @Id
    @Basic(optional = false)
    @Column(name = "int_cod_siafi_city")
    private Integer intCodSiafiCity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbCityIdCity")
    private List<TbPayments> tbPaymentsList;
    @JoinColumn(name = "tb_state_id_state", referencedColumnName = "id_state")
    @ManyToOne(optional = false)
    private TbState tbStateIdState;

    public TbCity() {
    }

    public TbCity(Integer intCodSiafiCity) {
        this.intCodSiafiCity = intCodSiafiCity;
    }

    public TbCity(Integer intCodSiafiCity, String strNameCity) {
        this.intCodSiafiCity = intCodSiafiCity;
        this.strNameCity = strNameCity;
    }

    public String getStrNameCity() {
        return strNameCity;
    }

    public void setStrNameCity(String strNameCity) {
        this.strNameCity = strNameCity;
    }

    public Integer getIntCodSiafiCity() {
        return intCodSiafiCity;
    }

    public void setIntCodSiafiCity(Integer intCodSiafiCity) {
        this.intCodSiafiCity = intCodSiafiCity;
    }

    @XmlTransient
    public List<TbPayments> getTbPaymentsList() {
        return tbPaymentsList;
    }

    public void setTbPaymentsList(List<TbPayments> tbPaymentsList) {
        this.tbPaymentsList = tbPaymentsList;
    }

    public TbState getTbStateIdState() {
        return tbStateIdState;
    }

    public void setTbStateIdState(TbState tbStateIdState) {
        this.tbStateIdState = tbStateIdState;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (intCodSiafiCity != null ? intCodSiafiCity.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCity)) {
            return false;
        }
        TbCity other = (TbCity) object;
        if ((this.intCodSiafiCity == null && other.intCodSiafiCity != null) || (this.intCodSiafiCity != null && !this.intCodSiafiCity.equals(other.intCodSiafiCity))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbCity[ intCodSiafiCity=" + intCodSiafiCity + " ]";
    }
    
}
