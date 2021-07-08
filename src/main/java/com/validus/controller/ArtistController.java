package com.validus.controller;


import com.validus.domain.Artist;
import com.validus.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;


    @RequestMapping(value = "/artists", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Artist> fetchAll() {
        return artistService.findAll();
    }


}
