package org.example.evaluations.evaluation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "message")
public class Message {
    @Id
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member author;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private WhatsappGroup group;
}
