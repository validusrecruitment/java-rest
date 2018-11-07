package com.validus.service;

import com.validus.domain.Song;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SongService {
    List<Song> findAll();
}
