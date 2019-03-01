package com.example.step3.trackrepositoryapi;

import com.example.step3.trackrepository.Track;
import com.example.step3.trackrepository.TrackId;
import com.example.step3.trackrepository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Rest controller publishing REST api with absolutely no security
 */
@RestController
@RequestMapping("/tracks")
public class TrackRepositoryController {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackRepositoryController(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @PostMapping(path = "add")
    public void add(@RequestBody Track track) {
        trackRepository.insert(track);
    }

    /**
     * No security !!! Everyone can remove all Tracks from Database
     * @return
     */
    @PostMapping(path = "removeall")
    public void removeAll() {
        trackRepository.removeAll();
    }

    @GetMapping(path = "find")
    public ResponseEntity<Track> findById(TrackId trackId)
    {
        var track = trackRepository.findById(trackId);

        if(track != null)
        {
            return ResponseEntity.ok(track);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "findHipsterWay")
    public ResponseEntity<Track> findHipsterWay(TrackId trackId)
    {
        // Hipster bonus bingo
        return Optional.ofNullable(trackRepository.findById(trackId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
