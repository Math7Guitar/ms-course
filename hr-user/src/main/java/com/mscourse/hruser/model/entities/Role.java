package com.mscourse.hruser.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.PersistenceCreator;

@Entity
@Table(name = "TB_ROLES")
public class Role implements Serializable {
    
    private static final long serialVersionUID = 1L;


    //Atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;
    

    //Constructors
    @PersistenceCreator
    public Role(Long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public Role() {}


    //Getters
    public Long getId() { return this.id; }
    public String getName() { return this.name; }


    //Setters
    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }


    //HashCode and Equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Role other = (Role) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
