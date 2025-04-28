package org.example.evaluations.evaluation.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "batch")
public class Batch {
    @Id
    private UUID id;

    @ManyToMany
    @JoinTable(
        name = "instructors_batches",
        joinColumns = @JoinColumn(name = "batch_id"),
        inverseJoinColumns = @JoinColumn(name = "instructor_id")
    )
    private List<Instructor> instructors;

    private String name;

    @OneToMany(mappedBy = "currentBatch") //MIMP
    private Set<Learner> learners = new HashSet<>();

    @ManyToMany(mappedBy = "batches")
    private Set<Class> classes;
}
