package com.validus.service;

import com.validus.domain.Artist;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArtistService {
    List<Artist> findAll();
}
