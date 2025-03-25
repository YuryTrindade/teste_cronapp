
package app.entity;

import java.io.*;
import jakarta.persistence.*;
import java.util.*;
import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;



import cronapp.framework.core.persistence.*;

/**
* Classe que representa a tabela PERIODO
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"PERIODO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Periodo")
@CronappTable(role=CronappTableRole.CLASS)
public class Periodo implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @CronappColumn(attributeType="STRING", label="Id", defaultValue = "UUID.randomUUID().toString().toUpperCase()")
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Periodo")
    @Column(name = "periodo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String periodo;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="Ativo")
    @Column(name = "ativo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean ativo;


    /**
    * @generated
    */
    @Temporal(TemporalType.DATE)
    @CronappColumn(attributeType="DATE", label="Data Inicial")
    @Column(name = "dataInicial", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date dataInicial;


    /**
    * @generated
    */
    @Temporal(TemporalType.DATE)
    @CronappColumn(attributeType="DATE", label="Data Final")
    @Column(name = "dataFinal", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date dataFinal;


    /**
    * Construtor
    * @generated
    */
    public Periodo(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public Periodo setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém periodo
    * return periodo
    * @generated
    */
    public java.lang.String getPeriodo() {
        return this.periodo;
    }

    /**
    * Define periodo
    * @param periodo periodo
    * @generated
    */
    public Periodo setPeriodo(java.lang.String periodo) {
        this.periodo = periodo;
        return this;
    }
    /**
    * Obtém ativo
    * return ativo
    * @generated
    */
    public java.lang.Boolean getAtivo() {
        return this.ativo;
    }

    /**
    * Define ativo
    * @param ativo ativo
    * @generated
    */
    public Periodo setAtivo(java.lang.Boolean ativo) {
        this.ativo = ativo;
        return this;
    }
    /**
    * Obtém dataInicial
    * return dataInicial
    * @generated
    */
    public java.util.Date getDataInicial() {
        return this.dataInicial;
    }

    /**
    * Define dataInicial
    * @param dataInicial dataInicial
    * @generated
    */
    public Periodo setDataInicial(java.util.Date dataInicial) {
        this.dataInicial = dataInicial;
        return this;
    }
    /**
    * Obtém dataFinal
    * return dataFinal
    * @generated
    */
    public java.util.Date getDataFinal() {
        return this.dataFinal;
    }

    /**
    * Define dataFinal
    * @param dataFinal dataFinal
    * @generated
    */
    public Periodo setDataFinal(java.util.Date dataFinal) {
        this.dataFinal = dataFinal;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Periodo object = (Periodo)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
