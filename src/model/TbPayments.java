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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "tb_payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPayments.findAll", query = "SELECT t FROM TbPayments t")
    , @NamedQuery(name = "TbPayments.findByIdPayments", query = "SELECT t FROM TbPayments t WHERE t.idPayments = :idPayments")
    , @NamedQuery(name = "TbPayments.findByDbValue", query = "SELECT t FROM TbPayments t WHERE t.dbValue = :dbValue")})
public class TbPayments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_payments")
    private Long idPayments;
    @Basic(optional = false)
    @Column(name = "db_value")
    private double dbValue;
    @JoinColumn(name = "tb_action_id_action", referencedColumnName = "int_cod_action")
    @ManyToOne(optional = false)
    private TbAction tbActionIdAction;
    @JoinColumn(name = "tb_beneficiaries_id_beneficiary", referencedColumnName = "int_nis")
    @ManyToOne(optional = false)
    private TbBeneficiaries tbBeneficiariesIdBeneficiary;
    @JoinColumn(name = "tb_city_id_city", referencedColumnName = "int_cod_siafi_city")
    @ManyToOne(optional = false)
    private TbCity tbCityIdCity;
    @JoinColumn(name = "tb_files_id_file", referencedColumnName = "id_file")
    @ManyToOne(optional = false)
    private TbFiles tbFilesIdFile;
    @JoinColumn(name = "tb_function_id_function", referencedColumnName = "int_cod_function")
    @ManyToOne(optional = false)
    private TbFunctions tbFunctionIdFunction;
    @JoinColumn(name = "tb_program_id_program", referencedColumnName = "int_cod_program")
    @ManyToOne(optional = false)
    private TbProgram tbProgramIdProgram;
    @JoinColumn(name = "tb_source_id_source", referencedColumnName = "id_source")
    @ManyToOne(optional = false)
    private TbSource tbSourceIdSource;
    @JoinColumn(name = "tb_subfunction_id_subfunction", referencedColumnName = "int_cod_subfunction")
    @ManyToOne(optional = false)
    private TbSubfunctions tbSubfunctionIdSubfunction;

    public TbPayments() {
    }

    public TbPayments(Long idPayments) {
        this.idPayments = idPayments;
    }

    public TbPayments(Long idPayments, double dbValue) {
        this.idPayments = idPayments;
        this.dbValue = dbValue;
    }

    public Long getIdPayments() {
        return idPayments;
    }

    public void setIdPayments(Long idPayments) {
        this.idPayments = idPayments;
    }

    public double getDbValue() {
        return dbValue;
    }

    public void setDbValue(double dbValue) {
        this.dbValue = dbValue;
    }

    public TbAction getTbActionIdAction() {
        return tbActionIdAction;
    }

    public void setTbActionIdAction(TbAction tbActionIdAction) {
        this.tbActionIdAction = tbActionIdAction;
    }

    public TbBeneficiaries getTbBeneficiariesIdBeneficiary() {
        return tbBeneficiariesIdBeneficiary;
    }

    public void setTbBeneficiariesIdBeneficiary(TbBeneficiaries tbBeneficiariesIdBeneficiary) {
        this.tbBeneficiariesIdBeneficiary = tbBeneficiariesIdBeneficiary;
    }

    public TbCity getTbCityIdCity() {
        return tbCityIdCity;
    }

    public void setTbCityIdCity(TbCity tbCityIdCity) {
        this.tbCityIdCity = tbCityIdCity;
    }

    public TbFiles getTbFilesIdFile() {
        return tbFilesIdFile;
    }

    public void setTbFilesIdFile(TbFiles tbFilesIdFile) {
        this.tbFilesIdFile = tbFilesIdFile;
    }

    public TbFunctions getTbFunctionIdFunction() {
        return tbFunctionIdFunction;
    }

    public void setTbFunctionIdFunction(TbFunctions tbFunctionIdFunction) {
        this.tbFunctionIdFunction = tbFunctionIdFunction;
    }

    public TbProgram getTbProgramIdProgram() {
        return tbProgramIdProgram;
    }

    public void setTbProgramIdProgram(TbProgram tbProgramIdProgram) {
        this.tbProgramIdProgram = tbProgramIdProgram;
    }

    public TbSource getTbSourceIdSource() {
        return tbSourceIdSource;
    }

    public void setTbSourceIdSource(TbSource tbSourceIdSource) {
        this.tbSourceIdSource = tbSourceIdSource;
    }

    public TbSubfunctions getTbSubfunctionIdSubfunction() {
        return tbSubfunctionIdSubfunction;
    }

    public void setTbSubfunctionIdSubfunction(TbSubfunctions tbSubfunctionIdSubfunction) {
        this.tbSubfunctionIdSubfunction = tbSubfunctionIdSubfunction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPayments != null ? idPayments.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPayments)) {
            return false;
        }
        TbPayments other = (TbPayments) object;
        if ((this.idPayments == null && other.idPayments != null) || (this.idPayments != null && !this.idPayments.equals(other.idPayments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbPayments[ idPayments=" + idPayments + " ]";
    }
    
}
