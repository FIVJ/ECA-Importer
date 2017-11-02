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
@Table(name = "tb_functions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFunctions.findAll", query = "SELECT t FROM TbFunctions t")
    , @NamedQuery(name = "TbFunctions.findByIntCodFunction", query = "SELECT t FROM TbFunctions t WHERE t.intCodFunction = :intCodFunction")
    , @NamedQuery(name = "TbFunctions.findByStrNameFunction", query = "SELECT t FROM TbFunctions t WHERE t.strNameFunction = :strNameFunction")})
public class TbFunctions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "int_cod_function")
    private Integer intCodFunction;
    @Basic(optional = false)
    @Column(name = "str_name_function")
    private String strNameFunction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbFunctionIdFunction")
    private List<TbPayments> tbPaymentsList;

    public TbFunctions() {
    }

    public TbFunctions(Integer intCodFunction) {
        this.intCodFunction = intCodFunction;
    }

    public TbFunctions(Integer intCodFunction, String strNameFunction) {
        this.intCodFunction = intCodFunction;
        this.strNameFunction = strNameFunction;
    }

    public Integer getIntCodFunction() {
        return intCodFunction;
    }

    public void setIntCodFunction(Integer intCodFunction) {
        this.intCodFunction = intCodFunction;
    }

    public String getStrNameFunction() {
        return strNameFunction;
    }

    public void setStrNameFunction(String strNameFunction) {
        this.strNameFunction = strNameFunction;
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
        hash += (intCodFunction != null ? intCodFunction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFunctions)) {
            return false;
        }
        TbFunctions other = (TbFunctions) object;
        if ((this.intCodFunction == null && other.intCodFunction != null) || (this.intCodFunction != null && !this.intCodFunction.equals(other.intCodFunction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbFunctions[ intCodFunction=" + intCodFunction + " ]";
    }
    
}
