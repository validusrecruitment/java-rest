package com.validus.controller;

import com.validus.domain.Album;
import com.validus.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = "/albums", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public List<Album> findAll() {
        return albumService.findAll();
    }

    @RequestMapping(value = "/albums", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
    //@PostMapping(value = "/albums")
    public Album createAlbum(@RequestBody Album album) {
        return albumService.createAlbum(album);
    }

    @RequestMapping(value = "/albums/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public Album getAlbum(@PathVariable long id) {
        return albumService.findAlbum(id);
    }

    public  Album updateAlbum(@PathVariable long id, @RequestBody Album album) {
            return albumService.updateAlbum(id, album);
    }

}
