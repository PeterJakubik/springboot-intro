package com.example.step1.trackrepository;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class TrackRepository {

    /**
     * @return all tracks or empty collection
     */
    public Collection<Track>  getAll()
    {
        return Collections.emptyList();
    }

    /**
     * Find Track by its TrackId
     * @param trackId Unique Track id
     * @return Track if or {@code null} if not found
     */
    public Track findById(TrackId trackId)
    {
        return null;
    }

    /**
     * Insert new Track
     * @param track Track to insert
     */
    public void insert(Track track)
    {}

    /**
     * Remove all Tracks
     */
    public void removeAll()
    {}
}
