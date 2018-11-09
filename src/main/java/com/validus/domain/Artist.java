package com.validus.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="artist")
@EqualsAndHashCode(exclude="albums")
public class Artist extends BaseModel{

    @Id
    @GeneratedValue
    private long id;

    @Column
    private Date created;

    @Column
    private Date lastModified;

    @NotNull
    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "artist_albums", joinColumns = @JoinColumn(name = "albums_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
    @JsonBackReference
    private Set<Album> albums;
}
