package com.validus.service;

import com.validus.domain.Artist;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArtistService {
    List<Artist> findAll();

    Artist createArtist(Artist artist);

    Artist findArtist(long id);

    Artist updateArtist(long id, Artist artist);

    void deleteById(long id);

    void delete(Artist artist);

}
