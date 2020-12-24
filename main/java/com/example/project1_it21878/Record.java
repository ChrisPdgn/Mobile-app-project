package com.example.project1_it21878;

public class Record {
    private String userId;
    private float longitude;
    private float latitude;
    private String dt;

    public Record(String userId, float longitude, float latitude) {
        this.userId = userId;
        this.longitude = longitude;
        this.latitude = latitude;
        Long tsLong = System.currentTimeMillis()/1000;
        this.dt = tsLong.toString();
    }

    public String getUserId() {
        return userId;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getDt() {
        return dt;
    }
}
