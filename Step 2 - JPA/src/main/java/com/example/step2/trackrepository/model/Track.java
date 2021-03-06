package com.example.step2.trackrepository.model;

import com.example.step2.trackrepository.Gradient;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;


@Entity
public class Track {

    /**
     * Unique Track Id
     */
    @EmbeddedId
    private TrackId trackId = new TrackId();

    /**
     * Track length in cm
     */
    private int l_sp;

    /**
     * Track gadient
     */
    private Gradient gradient;

    public Track() {
    }

    public Track(TrackId trackId, int l_sp, Gradient gradient) {
        this.trackId = trackId;
        this.l_sp = l_sp;
        this.gradient = gradient;
    }

    public TrackId getTrackId() {
        return trackId;
    }

    public void setTrackId(TrackId trackId) {
        this.trackId = trackId;
    }

    public int getL_sp() {
        return l_sp;
    }

    public void setL_sp(int l_sp) {
        this.l_sp = l_sp;
    }

    public Gradient getGradient() {
        return gradient;
    }

    public void setGradient(Gradient gradient) {
        this.gradient = gradient;
    }

    public com.example.step2.trackrepository.Track toTrack()
    {
        return new com.example.step2.trackrepository.Track(
                new com.example.step2.trackrepository.TrackId(this.trackId.getNid_c(), this.trackId.getNid_sp()),
                l_sp,
                gradient
        );
    }

    public static Track fromTrack(com.example.step2.trackrepository.Track track)
    {
        Objects.requireNonNull(track);
        Objects.requireNonNull(track.getTrackId());

        return new Track(
                new TrackId(track.getTrackId().getNid_c(), track.getTrackId().getNid_sp()),
                track.getL_sp(),
                track.getGradient()
        );
    }
}