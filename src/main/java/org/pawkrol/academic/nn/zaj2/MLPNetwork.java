package org.pawkrol.academic.nn.zaj2;

import org.pawkrol.academic.nn.common.ErrorTimePair;
import org.pawkrol.academic.nn.common.functions.SigmoidFunction;
import org.pawkrol.academic.nn.zaj2.network.Backpropagation;
import org.pawkrol.academic.nn.zaj2.network.NetManager;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MLPNetwork {

    public static void main(String[] args){
        NetManager netManager = new NetManager(2, new int[]{2, 1}, .6f, new SigmoidFunction());
        Backpropagation backpropagation = new Backpropagation(netManager);

        float[][] input = { {0, 0}, {0, 1}, {0, 1}, {1, 1}};
        float[][] output = { {0}, {1}, {1}, {0}};

        backpropagation.learn(input, output, 0.000001, 1000000);

        System.out.println("{0, 0} => " + Math.round(netManager.propagateInput(input[0]).getOutputs()[0]) + " ("
                + netManager.propagateInput(input[0]).getOutputs()[0] + ")");
        System.out.println("{0, 1} => " + Math.round(netManager.propagateInput(input[1]).getOutputs()[0]) + " ("
                + netManager.propagateInput(input[1]).getOutputs()[0] + ")");
        System.out.println("{1, 0} => " + Math.round(netManager.propagateInput(input[2]).getOutputs()[0]) + " ("
                + netManager.propagateInput(input[2]).getOutputs()[0] + ")");
        System.out.println("{1, 1} => " + Math.round(netManager.propagateInput(input[3]).getOutputs()[0]) + " ("
                + netManager.propagateInput(input[3]).getOutputs()[0] + ")");

        writeStatisticsToFile(backpropagation.getErrorTimePairs());

    }

    private static void writeStatisticsToFile(List<ErrorTimePair> errorTimePairs){
        Path file = Paths.get("output.txt");
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
