package com.validus.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="album")
public class Album extends BaseModel{
    @NotNull
    @Column
    private String name;

    @Column(name = "year_released")
    private int yearReleased;

    @ManyToMany(mappedBy = "albums")
    //@JsonManagedReference
    private Set<Artist> artists;

    @OneToMany(mappedBy = "album")
    //@JsonManagedReference
    private Set<Song> songs;

}
