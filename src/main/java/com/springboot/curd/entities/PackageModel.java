package com.springboot.curd.entities;

import com.sun.istack.NotNull;

import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "packages")
public class PackageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, updatable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @Column(name = "package_name")
    private String packageName;

    @NotNull
    @Column(name = "destination")
    private String destination;

    @NotNull
    @Column(name = "duration", length = 500)
    private String duration;

    @NotNull
    @Column(name = "price")
    private Integer price;

    @NotNull
    @Column(name = "description")
    private String description;

    @Lob
    @Column()
    private String image;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Booking> booking;

    // getters and setters ...

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PackageModel() {
    }

    public PackageModel(String packageName, String destination, String duration, Integer price, String description, String image) {
        this.packageName = packageName;
        this.destination = destination;
        this.duration = duration;
        this.price = price;
        this.description = description;
        this.image = image;
    }
}
