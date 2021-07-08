package com.validus.service;

import com.validus.domain.Album;
import com.validus.domain.Artist;
import com.validus.domain.Song;
import com.validus.exception.GenericNotFoundException;
import com.validus.repositories.AlbumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class AlbumServiceImpl implements AlbumService {

    private static final Logger logger = LoggerFactory.getLogger("AlbumServiceImpl");
    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> findAll() {
        return (List<Album>) albumRepository.findAll();
    }

    @Override
    public Album createAlbum(Album album) {

        if (album.getSongs() == null) {
            album.getSongs().clear();
        } else {
            for (Song s : album.getSongs()) {
                s.setAlbum(album);
            }
        }

        return albumRepository.save(album);
    }

    @Override
    public Album findAlbum(long id) {

        Album album = albumRepository.findById(id).orElse(null);

        if (album == null) {
            throw new GenericNotFoundException("Album is not present");
        }

        return album;
    }

    /**
     * TODO: Removal / Deletion of Song.
     *
     * @param id
     * @param album
     * @return
     */
    @Override
    public void updateAlbum(long id, Album album) {
        Album updateAlbum = findAlbum(id);
        updateAlbum.setName(album.getName());
        updateAlbum.setYearReleased(album.getYearReleased());
        updateAlbum.setArtists(album.getArtists());
        updateAlbum.setSongs(album.getSongs());
        updateAlbum.setCreated(album.getCreated());
        updateAlbum.setLastModified(new Date(System.currentTimeMillis()));

        if (updateAlbum.getSongs() == null) {
            updateAlbum.getSongs().clear();
        }/*else {
            for (Song s: updateAlbum.getSongs()) {
                s.setAlbum(updateAlbum);
            }
        }*/


        albumRepository.saveAndFlush(updateAlbum);
    }

    @Override
    public void deleteById(long id) {
        //First check if Albums is present or not
        Album album = albumRepository.findById(id).orElse(null);
        if (album == null) {
            throw new GenericNotFoundException("Album is not present");
        }

        albumRepository.deleteById(id);
    }

    public void delete(Album album) {

        Album a = albumRepository.findById(album.getId()).orElse(null);

        if (a == null) {
            throw new GenericNotFoundException("Album is not present");
        }

        albumRepository.delete(album);
    }


    public Set<Artist> findArtist(long albumId) {
        Album album = findAlbum(albumId);

        if (album == null) {
            throw new GenericNotFoundException("Album is not present");
        }

        return album.getArtists();
    }
}
