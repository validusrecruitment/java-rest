package com.validus.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name="song")
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
    private Album album;

}
