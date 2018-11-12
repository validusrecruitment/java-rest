package com.validus.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "artist")
@EqualsAndHashCode(exclude = "albums")
public class Artist extends BaseModel {

    @NotNull
    @Column
    private String name;

    @ManyToMany(mappedBy = "artists")
    @JsonBackReference
    private Set<Album> albums;
}
