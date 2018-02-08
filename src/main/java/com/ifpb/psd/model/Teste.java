package com.ifpb.psd.model;

/**
 *
 * @author Rodrigo Bento
 */
public class Teste {
    
    private int id;
    private String name;
    private boolean edited;
    private boolean deleted;

    public Teste(String nome) {
        this.name = nome;
        this.edited = false;
        this.deleted = false;
    }

    public Teste(int id, String name, boolean edited, boolean deleted) {
        this.id = id;
        this.name = name;
        this.edited = edited;
        this.deleted = deleted;
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Teste{" + "name=" + name + ", edited=" + edited + ", deleted=" + deleted + '}';
    }
    
}
