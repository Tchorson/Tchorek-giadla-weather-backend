package com.example.cloudcomputinggiadlatchorek.logic;

import com.example.cloudcomputinggiadlatchorek.TornadoCategory;
import com.fuzzylite.*;
import com.fuzzylite.imex.FllImporter;
import com.fuzzylite.variable.InputVariable;
import com.fuzzylite.variable.OutputVariable;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static java.lang.Math.ceil;

@Component
public class FuzzyLogic {

    private Engine engine;

    private InputVariable humidity;
    private InputVariable temperature;
    private InputVariable windSpeed;
    private OutputVariable dangerlvl;

    /**
     * Initialization engine of fuzzy logic
     */
    public FuzzyLogic() throws IOException, RuntimeException, URISyntaxException {
        URL res = getClass().getClassLoader().getResource("fuzzylogic.fll");
        File file = Paths.get(res.toURI()).toFile();
        StringBuilder status = new StringBuilder();
        try {
            this.engine = new FllImporter().fromFile(file);
            engine.isReady(status);
        } catch (IOException | RuntimeException e1) {
            System.err.println("Engine can not start.");
        }

        //System.out.println(engine.getOutputVariables().toString());

        humidity = engine.getInputVariable("humidity");
        temperature = engine.getInputVariable("temperature");
        windSpeed = engine.getInputVariable("windSpeed");

        dangerlvl = engine.getOutputVariable("dangerlvl");
    }

    public TornadoCategory inference(Double humidity, Double temperature, Double windSpeed) {
        this.humidity.setValue(humidity);
        this.temperature.setValue(temperature);
        this.windSpeed.setValue(windSpeed);

        this.engine.process();

        double value = this.dangerlvl.getValue();

        for (TornadoCategory tornadoCat: TornadoCategory.values()) {
            if (tornadoCat.getValue() == ceil(value)) {
                return tornadoCat;
            }
        }
        return TornadoCategory.UNKNOWN;
    }
}
