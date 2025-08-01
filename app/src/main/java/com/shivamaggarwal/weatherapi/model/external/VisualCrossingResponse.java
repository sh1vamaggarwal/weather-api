package com.shivamaggarwal.weatherapi.model.external;

import java.util.List;

import lombok.Data;

@Data
public class VisualCrossingResponse {
    private int queryCost;
    private double latitude;
    private double longitude;
    private String resolvedAddress;
    private String address;
    private String timezone;
    private double tzoffset;
    private String description;
    private List<Day> days;
    private List<Object> alerts;
    private Stations stations;
    private CurrentConditions currentConditions;

    @Data
    public static class Day {
        private String datetime;
        private long datetimeEpoch;
        private double tempmax;
        private double tempmin;
        private double temp;
        private double feelslikemax;
        private double feelslikemin;
        private double feelslike;
        private double dew;
        private double humidity;
        private double precip;
        private double precipprob;
        private double precipcover;
        private List<String> preciptype;
        private double snow;
        private double snowdepth;
        private double windgust;
        private double windspeed;
        private double winddir;
        private double pressure;
        private double cloudcover;
        private double visibility;
        private double solarradiation;
        private double solarenergy;
        private double uvindex;
        private double severerisk;
        private String sunrise;
        private long sunriseEpoch;
        private String sunset;
        private long sunsetEpoch;
        private double moonphase;
        private String conditions;
        private String icon;
        private String description;
        private List<String> stations;
        private String source;
        private List<Hour> hours;
    }

    @Data
    public static class Hour {
        private String datetime;
        private long datetimeEpoch;
        private double temp;
        private double feelslike;
        private double humidity;
        private double dew;
        private double precip;
        private double precipprob;
        private double snow;
        private double snowdepth;
        private List<String> preciptype;
        private double windgust;
        private double windspeed;
        private double winddir;
        private double pressure;
        private double visibility;
        private double cloudcover;
        private double solarradiation;
        private double solarenergy;
        private double uvindex;
        private double severerisk;
        private String conditions;
        private String icon;
        private List<String> stations;
        private String source;
    }

    @Data
    public static class Stations {
        private StationDetail VIDP;
        private StationDetail AV559;
    }

    @Data
    public static class StationDetail {
        private double distance;
        private double latitude;
        private double longitude;
        private int useCount;
        private String id;
        private String name;
        private int quality;
        private double contribution;
    }

    @Data
    public static class CurrentConditions {
        private String datetime;
        private long datetimeEpoch;
        private Double temp;
        private Double feelslike;
        private Double humidity;
        private Double dew;
        private Double precip;
        private Double precipprob;
        private Double snow;
        private Double snowdepth;
        private List<String> preciptype;
        private Double windgust;
        private Double windspeed;
        private Double winddir;
        private Double pressure;
        private Double visibility;
        private Double cloudcover;
        private Double solarradiation;
        private Double solarenergy;
        private Double uvindex;
        private String conditions;
        private String icon;
        private List<String> stations;
        private String source;
        private String sunrise;
        private long sunriseEpoch;
        private String sunset;
        private long sunsetEpoch;
        private double moonphase;
    }
}
