package com.example.step1.trackrepository;

public class TrackId {

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
}
