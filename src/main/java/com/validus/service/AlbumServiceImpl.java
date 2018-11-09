package com.validus.service;
import com.validus.domain.Album;
import com.validus.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> findAll() {
        return (List<Album>)albumRepository.findAll();
    }

    @Override
    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album findAlbum(long id) {
        return albumRepository.findById(id).orElse(null);
    }

    /**
     * Simplifying scenario for not going for partial updates.
     * @param id
     * @param album
     * @return
     */
    @Override
    public Album updateAlbum(long id, Album album) {
        Album updateAlbum = findAlbum(id);
        updateAlbum.setName(album.getName());
        updateAlbum.setYearReleased(album.getYearReleased());
        updateAlbum.setArtists(album.getArtists());
        updateAlbum.setSongs(album.getSongs());
        updateAlbum.setCreated(album.getCreated());
        updateAlbum.setLastModified(new Date(System.currentTimeMillis()));

        return albumRepository.save(album);
    }

    @Override
    public void deleteById(long id) {
        albumRepository.deleteById(id);
    }

    public void delete(Album album) {
        albumRepository.delete(album);
    }
}
