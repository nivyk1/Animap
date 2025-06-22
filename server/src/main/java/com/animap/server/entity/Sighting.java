package com.animap.server.entity;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "sightings")
public class Sighting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "animal", nullable = false)
    private String animal;

    @Column(name = "description")
    private String description;

    @Column(name = "location", columnDefinition = "geometry(Point, 4326)", nullable = false)
    private Point location;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sighted_at", nullable = false)
    private java.util.Date sightedAt;

    @Column(name = "active", nullable = false)
    private boolean active = true; // Default to true

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign key in the "sightings" table
    private User user;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public java.util.Date getSightedAt() {
        return sightedAt;
    }

    public void setSightedAt(java.util.Date sightedAt) {
        this.sightedAt = sightedAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
