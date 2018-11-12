package com.validus.controller;

import com.validus.domain.Song;
import com.validus.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
public class SongController {

    @Autowired
    private SongService songService;


    @RequestMapping(value = "/songs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Song> fetchAll() {
        return songService.findAll();
    }
}
