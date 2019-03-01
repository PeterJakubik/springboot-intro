package com.example.step1.trackcalculator;

import com.example.step1.trackrepository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrackCalculator {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackCalculator(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    /**
     * Return sum of all Track lengths
     * @return
     */
    public int computeAllTrackLengths()
    {
        var allTracks = trackRepository.getAll();

        return allTracks.stream().mapToInt(t->t.getL_sp())
                .sum();
    }
}
