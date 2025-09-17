package com.cishockley.hero.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resources")
public class Resource {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 32)
    private String category;

    public Resource() {}                    // JPA-required no-arg (protected is fine)

    public Resource(String name, String category) {  // <-- public ctor for app code
        this.name = name;
        this.category = category;
    }

    public Long getId() { return id; }
    private void setId(Long id) { this.id = id; } // keep private or remove

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
