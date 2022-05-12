package com.tbs.theatre.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "theatre")
public class TheatreInfo {

    private Integer theatreId;
    private String theatreName;
    private AddressInfo address;
    private List<ShowDetails> shows;

    public Integer getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Integer theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public AddressInfo getAddress() {
        return address;
    }

    public void setAddress(AddressInfo address) {
        this.address = address;
    }

    public List<ShowDetails> getShows() {
        return shows;
    }

    public void setShows(List<ShowDetails> shows) {
        this.shows = shows;
    }

}
