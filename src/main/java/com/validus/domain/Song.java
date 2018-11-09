package com.validus.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name="song")
@EqualsAndHashCode(exclude = "album")
public class Song extends BaseModel{

    @Id
    @GeneratedValue
    private long id;

    @Column
    private int track;

    @NotNull
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "album_id")
    @JsonBackReference
    private Album album;

}
