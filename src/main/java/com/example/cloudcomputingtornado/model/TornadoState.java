package com.example.cloudcomputingtornado.model;
import com.example.cloudcomputingtornado.DangerLevel;
import lombok.Getter;
import lombok.Setter;

//TODO Customize to frontend
@Getter
@Setter
public class TornadoState {
    DangerLevel tornadoDangerlvl;
    Double deltaTemp;
    Double windSpeed;

    public TornadoState(DangerLevel tornadoDangerlvl, Double deltaTemp, Double windSpeed) {
        this.tornadoDangerlvl = tornadoDangerlvl;
        this.deltaTemp = deltaTemp;
        this.windSpeed = windSpeed;
    }
}
