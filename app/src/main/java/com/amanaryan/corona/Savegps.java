package com.amanaryan.corona;

class Savegps  {
    private double longitude,latitude;
    public Savegps(double longitude, double latitude) {
    this.longitude=longitude;
    this.latitude=latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
