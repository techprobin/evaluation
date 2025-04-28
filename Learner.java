package org.example.evaluations.evaluation.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "learner")
public class Learner {
    @Id
    private UUID id;

    private String name;

    private String email;

    @ManyToOne
    //@MapsId("currentBatchId") //optional?
    @JoinColumn(name = "current_batch_id")
    private Batch currentBatch;

    @ManyToMany
    @JoinTable(
        name = "learners_previous_batches",
        joinColumns = @JoinColumn(name = "learner_id"),
        inverseJoinColumns = @JoinColumn(name = "previous_batch_id")
    )
    private Set<Batch> previousBatches=new HashSet<>();
}
