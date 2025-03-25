
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
* Classe que representa a tabela VAGA
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"VAGA\"")
@XmlRootElement
@CronappSecurity(post = "Administrators", delete = "Administrators", put = "Administrators")
@JsonFilter("app.entity.Vaga")
@CronappTable(role=CronappTableRole.CLASS)
public class Vaga implements Serializable {
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
    @CronappColumn(attributeType="STRING", label="Nome")
    @Column(name = "nome", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String nome;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Status")
    @Column(name = "status", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String status;


    /**
    * @generated
    */
    @OneToOne
    @JoinColumn(name="fk_localizacao", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Localizacao localizacao;


    /**
    * Construtor
    * @generated
    */
    public Vaga(){
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
    public Vaga setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém nome
    * return nome
    * @generated
    */
    public java.lang.String getNome() {
        return this.nome;
    }

    /**
    * Define nome
    * @param nome nome
    * @generated
    */
    public Vaga setNome(java.lang.String nome) {
        this.nome = nome;
        return this;
    }
    /**
    * Obtém status
    * return status
    * @generated
    */
    public java.lang.String getStatus() {
        return this.status;
    }

    /**
    * Define status
    * @param status status
    * @generated
    */
    public Vaga setStatus(java.lang.String status) {
        this.status = status;
        return this;
    }
    /**
    * Obtém localizacao
    * return localizacao
    * @generated
    */
    public Localizacao getLocalizacao() {
        return this.localizacao;
    }

    /**
    * Define localizacao
    * @param localizacao localizacao
    * @generated
    */
    public Vaga setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Vaga object = (Vaga)obj;
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
