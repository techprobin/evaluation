package org.example.evaluations.evaluation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "whatsapp_group")
public class WhatsappGroup {
    @Id
    private Long id;

    private String name;

    private String description;


    @ManyToMany(mappedBy = "groups")
    private Set<Member> members = new HashSet<>();

    @OneToMany(mappedBy = "group")
    private List<Message> messages = new ArrayList<>();
}
