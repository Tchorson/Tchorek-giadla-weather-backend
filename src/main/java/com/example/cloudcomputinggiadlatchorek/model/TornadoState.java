package com.example.cloudcomputinggiadlatchorek.model;

import com.example.cloudcomputinggiadlatchorek.TornadoCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tornadostate")
@IdClass(TornadoState.class)
public class TornadoState implements Serializable {

    @Id
    @NonNull
    @Column(name = "datemeasure")
    private Long date;

    @Id
    @NonNull
    @Column(name = "location")
    private String location;

    @NonNull
    @Column(name = "dtemp")
    private Double dTemp;

    @NonNull
    @Column(name = "windspeed")
    private Double windSpeed;

    @NonNull
    @Column(name = "latitude")
    private Double latitude;

    @NonNull
    @Column(name = "longitude")
    private Double longitude;
    
    @NonNull
    @Column(name = "humidity")
    private Double humidity;

    @Enumerated(EnumType.STRING)
    @NonNull
    @Column(name = "tornadolvl")
    private TornadoCategory tornadoLvl;

    public TornadoState() {
        this.date = 0L;
        this.location = "";
        this.latitude = 0.0;
        this.longitude= 0.0;
        this.dTemp = 0.0;
        this.windSpeed = 0.0;
        this.humidity = 0.0;
        tornadoLvl = TornadoCategory.F0;
    }

    public TornadoState(@NonNull String location, @NonNull Long date, @NonNull Double latitude, @NonNull Double longitude,
                        @NonNull Double delta, @NonNull Double wind, @NonNull Double humidity, @NonNull TornadoCategory category) {
        this.date = date;
        this.location = location;
        this.latitude = latitude;
        this.longitude= longitude;
        this.dTemp = delta;
        this.windSpeed = wind;
        this.humidity = humidity;
        tornadoLvl = category;
    }

}
