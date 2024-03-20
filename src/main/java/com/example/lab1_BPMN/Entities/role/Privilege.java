package com.example.lab1_BPMN.Entities.role;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "privileges")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Set<Roles> roles;

    public Privilege( String name, Set<Roles> roles) {
        this.name = name;
        this.roles = roles;
    }

    public Privilege() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
// Геттеры и сеттеры
}

