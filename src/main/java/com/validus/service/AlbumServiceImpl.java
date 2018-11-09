package com.validus.service;
import com.validus.domain.Album;
import com.validus.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Album updateAlbum(Album album) {
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
