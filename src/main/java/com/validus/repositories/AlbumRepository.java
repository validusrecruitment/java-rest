package com.validus.repositories;

import com.validus.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    //List<Artist> findByName(@Param("name") String name);
}
