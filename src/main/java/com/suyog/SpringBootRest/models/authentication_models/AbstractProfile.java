package com.suyog.SpringBootRest.models.authentication_models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractProfile implements Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "profile",fetch = FetchType.EAGER)
    private List<SocialLink> socialLinks;

    @JsonManagedReference
    @OneToOne(mappedBy = "profile",fetch = FetchType.EAGER)
    private ContactInfo contactInfo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}