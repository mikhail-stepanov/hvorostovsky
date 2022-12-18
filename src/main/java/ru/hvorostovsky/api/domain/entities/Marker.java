package ru.hvorostovsky.api.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "markers")
@Data
@NoArgsConstructor
public class Marker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "order")
    private int order;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lng")
    private double lng;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spectacle_id")
    private Spectacle spectacle;

}
