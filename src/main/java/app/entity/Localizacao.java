
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
* Classe que representa a tabela LOCALIZACAO
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"LOCALIZACAO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Localizacao")
@CronappTable(role=CronappTableRole.CLASS)
public class Localizacao implements Serializable {
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
    @CronappColumn(attributeType="STRING", label="Info")
    @Column(name = "Info", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String info;


    /**
    * Construtor
    * @generated
    */
    public Localizacao(){
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
    public Localizacao setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém info
    * return info
    * @generated
    */
    public java.lang.String getInfo() {
        return this.info;
    }

    /**
    * Define info
    * @param info info
    * @generated
    */
    public Localizacao setInfo(java.lang.String info) {
        this.info = info;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Localizacao object = (Localizacao)obj;
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
