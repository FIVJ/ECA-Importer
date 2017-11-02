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
@Table(name = "tb_beneficiaries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbBeneficiaries.findAll", query = "SELECT t FROM TbBeneficiaries t")
    , @NamedQuery(name = "TbBeneficiaries.findByIntNis", query = "SELECT t FROM TbBeneficiaries t WHERE t.intNis = :intNis")
    , @NamedQuery(name = "TbBeneficiaries.findByStrNamePerson", query = "SELECT t FROM TbBeneficiaries t WHERE t.strNamePerson = :strNamePerson")})
public class TbBeneficiaries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "int_nis")
    private Long intNis;
    @Basic(optional = false)
    @Column(name = "str_name_person")
    private String strNamePerson;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbBeneficiariesIdBeneficiary")
    private List<TbPayments> tbPaymentsList;

    public TbBeneficiaries() {
    }

    public TbBeneficiaries(Long intNis) {
        this.intNis = intNis;
    }

    public TbBeneficiaries(Long intNis, String strNamePerson) {
        this.intNis = intNis;
        this.strNamePerson = strNamePerson;
    }

    public Long getIntNis() {
        return intNis;
    }

    public void setIntNis(Long intNis) {
        this.intNis = intNis;
    }

    public String getStrNamePerson() {
        return strNamePerson;
    }

    public void setStrNamePerson(String strNamePerson) {
        this.strNamePerson = strNamePerson;
    }

    @XmlTransient
    public List<TbPayments> getTbPaymentsList() {
        return tbPaymentsList;
    }

    public void setTbPaymentsList(List<TbPayments> tbPaymentsList) {
        this.tbPaymentsList = tbPaymentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (intNis != null ? intNis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbBeneficiaries)) {
            return false;
        }
        TbBeneficiaries other = (TbBeneficiaries) object;
        if ((this.intNis == null && other.intNis != null) || (this.intNis != null && !this.intNis.equals(other.intNis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbBeneficiaries[ intNis=" + intNis + " ]";
    }
    
}
