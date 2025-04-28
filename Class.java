  package org.example.evaluations.evaluation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "class")
public class Class {
    @Id
    private UUID id;

    private String topic;

    @ManyToMany
    @JoinTable(
        name = "batches_classes",
        joinColumns = @JoinColumn(name = "class_id"),
        inverseJoinColumns = @JoinColumn(name = "batch_id")
    )
    private Set<Batch> batches;

    @ManyToOne //(mappedBy = "class")
    // @MapsId("instructorId")
    @JoinColumn(name = "current_instructor_id")
    private Instructor currentInstructor;
}
