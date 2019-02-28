package com.example.demo.trackrepository.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TrackId implements Serializable  {


    private short nid_c;

    private int nid_sp;

    public TrackId() {
    }

    public TrackId(short nid_c, int nid_sp) {
        this.nid_c = nid_c;
        this.nid_sp = nid_sp;
    }

    public short getNid_c() {
        return nid_c;
    }

    public void setNid_c(short nid_c) {
        this.nid_c = nid_c;
    }

    public int getNid_sp() {
        return nid_sp;
    }

    public void setNid_sp(int nid_sp) {
        this.nid_sp = nid_sp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackId trackId = (TrackId) o;
        return nid_c == trackId.nid_c &&
                nid_sp == trackId.nid_sp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nid_c, nid_sp);
    }
}
