package ru.practicum.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "compilations")
public class Compilation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "compilations_to_event", joinColumns = @JoinColumn(name = "compilation_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Event> events;

    @Column(name = "pinned")
    private boolean pinned;

    @Column(name = "title", nullable = false, length = 50)
    private String title;
}
