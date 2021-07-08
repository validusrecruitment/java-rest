package com.validus.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date created;

    @Column
    private Date lastModified;

    public void setCreated(Date created) {
        if (created == null) {
            created = new Date(System.currentTimeMillis());
        }

        this.created = created;
    }

    public void setLastModified(Date lastModified) {
        if (lastModified == null) {
            lastModified = new Date(System.currentTimeMillis());
        }
        this.lastModified = lastModified;
    }
}
