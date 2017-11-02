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
@Table(name = "tb_action")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAction.findAll", query = "SELECT t FROM TbAction t")
    , @NamedQuery(name = "TbAction.findByIntCodAction", query = "SELECT t FROM TbAction t WHERE t.intCodAction = :intCodAction")
    , @NamedQuery(name = "TbAction.findByStrNameAction", query = "SELECT t FROM TbAction t WHERE t.strNameAction = :strNameAction")})
public class TbAction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "int_cod_action")
    private Integer intCodAction;
    @Column(name = "str_name_action")
    private String strNameAction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbActionIdAction")
    private List<TbPayments> tbPaymentsList;

    public TbAction() {
    }

    public TbAction(Integer intCodAction) {
        this.intCodAction = intCodAction;
    }

    public Integer getIntCodAction() {
        return intCodAction;
    }

    public void setIntCodAction(Integer intCodAction) {
        this.intCodAction = intCodAction;
    }

    public String getStrNameAction() {
        return strNameAction;
    }

    public void setStrNameAction(String strNameAction) {
        this.strNameAction = strNameAction;
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
        hash += (intCodAction != null ? intCodAction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAction)) {
            return false;
        }
        TbAction other = (TbAction) object;
        if ((this.intCodAction == null && other.intCodAction != null) || (this.intCodAction != null && !this.intCodAction.equals(other.intCodAction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbAction[ intCodAction=" + intCodAction + " ]";
    }
    
}
