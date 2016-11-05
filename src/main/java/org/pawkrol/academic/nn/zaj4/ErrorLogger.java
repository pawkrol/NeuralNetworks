package org.pawkrol.academic.nn.zaj4;

import org.pawkrol.academic.nn.common.ErrorTimePair;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ErrorLogger {

    private List<ErrorTimePair> errorTimePairs;

    public ErrorLogger(){
        errorTimePairs = new ArrayList<>();
    }

    public void log(long time, float error){
        errorTimePairs.add(new ErrorTimePair(error, time));
    }

    public void saveLog(){
        Path file = Paths.get("output_kohonen.txt");
        List<String> lines = new ArrayList<>();

        for (ErrorTimePair etp : errorTimePairs){
            lines.add(String.format("%d;%f", etp.getTime(), etp.getError()));
        }

        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
