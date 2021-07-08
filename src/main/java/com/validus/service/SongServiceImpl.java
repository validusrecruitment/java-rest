package com.validus.service;

import com.validus.domain.Song;
import com.validus.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    public List<Song> findAll() {
        return (List<Song>) songRepository.findAll();
    }

    @Override
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song findSong(long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public Song updateSong(long id, Song song) {
        //TODO : Fetch & update.

        return songRepository.save(song);
    }

    @Override
    public void deleteById(long id) {
        songRepository.deleteById(id);
    }

    @Override
    public void delete(Song song) {
        songRepository.delete(song);
    }
}
