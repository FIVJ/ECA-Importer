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
@Table(name = "tb_program")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProgram.findAll", query = "SELECT t FROM TbProgram t")
    , @NamedQuery(name = "TbProgram.findByIntCodProgram", query = "SELECT t FROM TbProgram t WHERE t.intCodProgram = :intCodProgram")
    , @NamedQuery(name = "TbProgram.findByStrNameProgram", query = "SELECT t FROM TbProgram t WHERE t.strNameProgram = :strNameProgram")})
public class TbProgram implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "int_cod_program")
    private Integer intCodProgram;
    @Column(name = "str_name_program")
    private String strNameProgram;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbProgramIdProgram")
    private List<TbPayments> tbPaymentsList;

    public TbProgram() {
    }

    public TbProgram(Integer intCodProgram) {
        this.intCodProgram = intCodProgram;
    }

    public Integer getIntCodProgram() {
        return intCodProgram;
    }

    public void setIntCodProgram(Integer intCodProgram) {
        this.intCodProgram = intCodProgram;
    }

    public String getStrNameProgram() {
        return strNameProgram;
    }

    public void setStrNameProgram(String strNameProgram) {
        this.strNameProgram = strNameProgram;
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
        hash += (intCodProgram != null ? intCodProgram.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProgram)) {
            return false;
        }
        TbProgram other = (TbProgram) object;
        if ((this.intCodProgram == null && other.intCodProgram != null) || (this.intCodProgram != null && !this.intCodProgram.equals(other.intCodProgram))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbProgram[ intCodProgram=" + intCodProgram + " ]";
    }
    
}
