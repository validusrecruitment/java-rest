package com.validus.repositories;

import com.validus.domain.Album;
import com.validus.domain.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    List<Artist> findByName(@Param("name") String name);
}
