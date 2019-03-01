package com.example.step1.trackrepository;

public class Track {

    /**
     * Unique Track Id
     */
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
}