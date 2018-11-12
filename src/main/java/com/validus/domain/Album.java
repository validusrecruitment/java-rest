package com.validus.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "album")
public class Album extends BaseModel {
    @NotNull
    @Column
    private String name;

    @Column(name = "year_released")
    private int yearReleased;

    //@JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "artist_albums", joinColumns = @JoinColumn(name = "albums_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
    private Set<Artist> artists;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonManagedReference
    private Set<Song> songs;

}
