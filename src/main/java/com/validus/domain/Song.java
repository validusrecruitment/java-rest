package com.validus.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "song")
@EqualsAndHashCode(exclude = "album")
public class Song extends BaseModel {
    @Column
    private int track;

    @NotNull
    @Column
    private String name;

    @ManyToOne
    //@JoinColumn(name = "album_id")
    @JsonBackReference
    private Album album;

}
