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
@Table(name = "tb_PBFPayments2011")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPBFPayments2011.findAll", query = "SELECT t FROM TbPBFPayments2011 t")
    , @NamedQuery(name = "TbPBFPayments2011.findByIdPBFPayments2011", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.idPBFPayments2011 = :idPBFPayments2011")
    , @NamedQuery(name = "TbPBFPayments2011.findByNis", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.nis = :nis")
    , @NamedQuery(name = "TbPBFPayments2011.findByName", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.name = :name")
    , @NamedQuery(name = "TbPBFPayments2011.findBySiafi", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.siafi = :siafi")
    , @NamedQuery(name = "TbPBFPayments2011.findByCity", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.city = :city")
    , @NamedQuery(name = "TbPBFPayments2011.findByState", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.state = :state")
    , @NamedQuery(name = "TbPBFPayments2011.findByRegion", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.region = :region")
    , @NamedQuery(name = "TbPBFPayments2011.findByFile", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.file = :file")
    , @NamedQuery(name = "TbPBFPayments2011.findByMonth", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.month = :month")
    , @NamedQuery(name = "TbPBFPayments2011.findByYear", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.year = :year")
    , @NamedQuery(name = "TbPBFPayments2011.findByProgram", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.program = :program")
    , @NamedQuery(name = "TbPBFPayments2011.findByAction", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.action = :action")
    , @NamedQuery(name = "TbPBFPayments2011.findByFunction", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.function = :function")
    , @NamedQuery(name = "TbPBFPayments2011.findBySubFunction", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.subFunction = :subFunction")
    , @NamedQuery(name = "TbPBFPayments2011.findBySource", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.source = :source")
    , @NamedQuery(name = "TbPBFPayments2011.findByValue", query = "SELECT t FROM TbPBFPayments2011 t WHERE t.value = :value")})
public class TbPBFPayments2011 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPBFPayments2011")
    private Long idPBFPayments2011;
    @Basic(optional = false)
    @Column(name = "NIS")
    private String nis;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Siafi")
    private String siafi;
    @Basic(optional = false)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @Column(name = "State")
    private String state;
    @Basic(optional = false)
    @Column(name = "Region")
    private String region;
    @Basic(optional = false)
    @Column(name = "File")
    private String file;
    @Basic(optional = false)
    @Column(name = "Month")
    private int month;
    @Basic(optional = false)
    @Column(name = "Year")
    private int year;
    @Basic(optional = false)
    @Column(name = "Program")
    private int program;
    @Basic(optional = false)
    @Column(name = "Action")
    private int action;
    @Basic(optional = false)
    @Column(name = "Function")
    private int function;
    @Basic(optional = false)
    @Column(name = "SubFunction")
    private int subFunction;
    @Basic(optional = false)
    @Column(name = "Source")
    private String source;
    @Basic(optional = false)
    @Column(name = "Value")
    private double value;

    public TbPBFPayments2011() {
    }

    public TbPBFPayments2011(Long idPBFPayments2011) {
        this.idPBFPayments2011 = idPBFPayments2011;
    }

    public TbPBFPayments2011(Long idPBFPayments2011, String nis, String name, String siafi, String city, String state, String region, String file, int month, int year, int program, int action, int function, int subFunction, String source, double value) {
        this.idPBFPayments2011 = idPBFPayments2011;
        this.nis = nis;
        this.name = name;
        this.siafi = siafi;
        this.city = city;
        this.state = state;
        this.region = region;
        this.file = file;
        this.month = month;
        this.year = year;
        this.program = program;
        this.action = action;
        this.function = function;
        this.subFunction = subFunction;
        this.source = source;
        this.value = value;
    }

    public Long getIdPBFPayments2011() {
        return idPBFPayments2011;
    }

    public void setIdPBFPayments2011(Long idPBFPayments2011) {
        this.idPBFPayments2011 = idPBFPayments2011;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getProgram() {
        return program;
    }

    public void setProgram(int program) {
        this.program = program;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getFunction() {
        return function;
    }

    public void setFunction(int function) {
        this.function = function;
    }

    public int getSubFunction() {
        return subFunction;
    }

    public void setSubFunction(int subFunction) {
        this.subFunction = subFunction;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPBFPayments2011 != null ? idPBFPayments2011.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPBFPayments2011)) {
            return false;
        }
        TbPBFPayments2011 other = (TbPBFPayments2011) object;
        if ((this.idPBFPayments2011 == null && other.idPBFPayments2011 != null) || (this.idPBFPayments2011 != null && !this.idPBFPayments2011.equals(other.idPBFPayments2011))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbPBFPayments2011[ idPBFPayments2011=" + idPBFPayments2011 + " ]";
    }
    
}
