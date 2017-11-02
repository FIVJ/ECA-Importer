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
@Table(name = "tb_subfunctions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSubfunctions.findAll", query = "SELECT t FROM TbSubfunctions t")
    , @NamedQuery(name = "TbSubfunctions.findByIntCodSubfunction", query = "SELECT t FROM TbSubfunctions t WHERE t.intCodSubfunction = :intCodSubfunction")
    , @NamedQuery(name = "TbSubfunctions.findByStrNameSubfunction", query = "SELECT t FROM TbSubfunctions t WHERE t.strNameSubfunction = :strNameSubfunction")})
public class TbSubfunctions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "int_cod_subfunction")
    private Integer intCodSubfunction;
    @Basic(optional = false)
    @Column(name = "str_name_subfunction")
    private String strNameSubfunction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbSubfunctionIdSubfunction")
    private List<TbPayments> tbPaymentsList;

    public TbSubfunctions() {
    }

    public TbSubfunctions(Integer intCodSubfunction) {
        this.intCodSubfunction = intCodSubfunction;
    }

    public TbSubfunctions(Integer intCodSubfunction, String strNameSubfunction) {
        this.intCodSubfunction = intCodSubfunction;
        this.strNameSubfunction = strNameSubfunction;
    }

    public Integer getIntCodSubfunction() {
        return intCodSubfunction;
    }

    public void setIntCodSubfunction(Integer intCodSubfunction) {
        this.intCodSubfunction = intCodSubfunction;
    }

    public String getStrNameSubfunction() {
        return strNameSubfunction;
    }

    public void setStrNameSubfunction(String strNameSubfunction) {
        this.strNameSubfunction = strNameSubfunction;
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
        hash += (intCodSubfunction != null ? intCodSubfunction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSubfunctions)) {
            return false;
        }
        TbSubfunctions other = (TbSubfunctions) object;
        if ((this.intCodSubfunction == null && other.intCodSubfunction != null) || (this.intCodSubfunction != null && !this.intCodSubfunction.equals(other.intCodSubfunction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbSubfunctions[ intCodSubfunction=" + intCodSubfunction + " ]";
    }
    
}
