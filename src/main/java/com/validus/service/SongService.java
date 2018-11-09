package com.validus.service;

import com.validus.domain.Song;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SongService {
    List<Song> findAll();

    Song createSong(Song song);

    Song findSong(long id);

    Song updateSong(Song song);

    void deleteById(long id);

    void delete(Song song);
}
