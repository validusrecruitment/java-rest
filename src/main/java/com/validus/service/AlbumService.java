package com.validus.service;

import com.validus.domain.Album;
import com.validus.domain.Artist;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface AlbumService {
    List<Album> findAll();

    Album createAlbum(Album album);

    Album findAlbum(long id);

    void updateAlbum(long id, Album album);

    void deleteById(long id);

    void delete(Album album);


    Set<Artist> findArtist(long albumId);
}
