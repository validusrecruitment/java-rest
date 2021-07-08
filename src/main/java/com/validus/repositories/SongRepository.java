package com.validus.repositories;

import com.validus.domain.Song;
import org.springframework.data.repository.CrudRepository;


public interface SongRepository extends CrudRepository<Song, Long> {
    //List<Song> findByName(@Param("name") String name);
}
