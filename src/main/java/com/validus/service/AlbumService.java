package com.validus.service;

import com.validus.domain.Album;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AlbumService {
    List<Album> findAll();

    Album createAlbum(Album album);

    Album findAlbum(long id);

    Album updateAlbum( long id, Album album);

    void deleteById(long id);

    void delete(Album album);
}
