package ru.hvorostovsky.api.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "spectacles")
@Data
@NoArgsConstructor
public class Spectacle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "static_id")
    private String staticId;

    @Column(name = "name")
    private String name;

    @Column(name = "subject")
    private String subject;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "place")
    private String place;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "year")
    private String year;

    @OneToMany(mappedBy = "spectacle")
    private List<Marker> markers;

    @OneToMany(mappedBy = "spectacle")
    private List<Photo> photos;

    @OneToMany(mappedBy = "spectacle")
    private List<Video> videos;

    @OneToMany(mappedBy = "spectacle")
    private List<Audio> audios;
}
