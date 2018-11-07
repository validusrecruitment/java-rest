package com.validus.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
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
    //@JsonIgnore
    @JsonBackReference
    private Set<Artist> artists;

    @JsonBackReference
    @OneToMany(mappedBy = "album")
    private Set<Song> songs;


}
