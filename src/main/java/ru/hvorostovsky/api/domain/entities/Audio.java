package ru.hvorostovsky.api.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "audios")
@Data
@NoArgsConstructor
public class Audio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "url")
    private String url;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "duration")
    private Long duration;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spectacle_id")
    private Spectacle spectacle;
}
