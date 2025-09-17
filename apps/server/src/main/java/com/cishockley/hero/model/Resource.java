package com.cishockley.hero.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 32)
    private String category;

    // ---- Constructors ----

    /** JPA requires a no-args constructor (can be protected). */
    protected Resource() {}

    /** Convenience ctor for creating new Resources in code. */
    public Resource(String name, String category) {
        this.name = name;
        this.category = category;
    }

    // ---- Getters / Setters ----

    public Long getId() {
        return id;
    }

    /** Keep this private so JPA manages the ID. */
    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
