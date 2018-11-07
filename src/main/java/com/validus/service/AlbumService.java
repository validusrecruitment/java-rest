package com.validus.service;

import com.validus.domain.Album;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AlbumService {
    List<Album> findAll();
}
