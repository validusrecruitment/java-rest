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
        return (List<Song>)songRepository.findAll();
    }
}
