package com.validus.controller;

import com.validus.domain.Album;
import com.validus.service.AlbumService;
import com.validus.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
@RestController
public class AlbumController {


    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = "/albums", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Album> findAll() {
        return albumService.findAll();
    }

    @RequestMapping(value = "/albums", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Album createAlbum(@RequestBody Album album) {
        return albumService.createAlbum(album);
    }

    @RequestMapping(value = "/albums/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Album getAlbum(@PathVariable long id) {
        return albumService.findAlbum(id);
    }

    @RequestMapping(value = "/albums/{id}", method = RequestMethod.PUT, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbum(@PathVariable long id, @RequestBody Album album) {
        albumService.updateAlbum(id, album);
    }

    @RequestMapping(value = "/albums/{id}", method = RequestMethod.DELETE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAlbum(@PathVariable long id) {
        albumService.deleteById(id);
    }



/*
    @RequestMapping(value = "/albums/{id}/artists", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Set<Artist> getAlbumArtists(@PathVariable long id) {
        return albumService.findArtist(id);
    }
*/


    // For more control one can use ResponseEntity


}
