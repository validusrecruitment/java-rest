package com.validus.service;

import com.validus.domain.Artist;
import com.validus.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> findAll() {
        return (List<Artist>) artistRepository.findAll();
    }

    @Override
    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist findArtist(long id) {
        // May be empty Artist object will be good idea.
        return artistRepository.findById(id).orElse(null);
    }

    @Override
    public Artist updateArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public void deleteById(long id) {
        artistRepository.deleteById(id);
    }

    @Override
    public void delete(Artist artist) {
        artistRepository.delete(artist);
    }
}
