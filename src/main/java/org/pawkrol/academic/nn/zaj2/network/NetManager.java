package org.pawkrol.academic.nn.zaj2.network;

import org.pawkrol.academic.nn.common.functions.ActivationFunction;
import org.pawkrol.academic.nn.common.Perceptron;

public class NetManager {

    private ActivationFunction function;
    private Layer[] layers;
    private int hiddenLayersNumber;
    private int netInputsNumber;
    private float eta;

    // structure ex. {3, 2, 1} where 3 and 2 are numbers of perceptrons in hidden layers
    // and 1 is a number of perceptrons in output layer
    public NetManager(int netInputsNumber, int[] structure, float eta, ActivationFunction function){
        this.hiddenLayersNumber = structure.length - 1;
        this.netInputsNumber = netInputsNumber;
        this.eta = eta;
        this.function = function;

        createLayers(structure);
        createPerceptrons();
    }

    public NetManager propagateInput(float[] inputValue){
        float[] input = inputValue.clone();

        for (Layer l : layers){
            l.passInput(input);
            input = l.getOutputs().clone();
        }

        return this;
    }

    public Layer getOutputLayer(){
        return layers[layers.length - 1];
    }

    public float[] getOutputs(){
        return getOutputLayer().getOutputs();
    }

    public void calculateOutputDeltas(float[] expectedOutput){
        Layer outputLayer = getOutputLayer();
        PerceptronContainer[] containers = outputLayer.getPerceptronContainers();

        Perceptron p;
        float delta, y;
        for (int i = 0; i < containers.length; i++){
            p = containers[i].getPerceptron();
            y = p.getOutput();

            delta = y * (1 - y) * (expectedOutput[i] - y);

            containers[i].setDelta(delta);
        }
    }

    public void calculateHiddenDeltas(){
        Layer layer, prevLayer = getOutputLayer();
        PerceptronContainer[] containers, prevContainer;
        float delta, y, sum = 0;

        for (int i = layers.length - 2; i >= 0; i--){
            layer = layers[i];
            containers = layer.getPerceptronContainers();
            prevContainer = prevLayer.getPerceptronContainers();

            for (int j = 0; j < containers.length; j++){
                for (PerceptronContainer pc : prevContainer){
                    sum += pc.getDelta() * pc.getPerceptron().getWeights()[j];
                }

                y = containers[i].getPerceptron().getOutput();
                delta = y * (1 - y) * sum;
                containers[i].setDelta(delta);
            }

            prevLayer = layer;
        }
    }

    public void updateWeights(float[] inputValue){
        float[] input = inputValue.clone();

        for (Layer l : layers){
            l.updateWeights(input);
            input = l.getOutputs().clone();
        }
    }

    public float getError(){
        return getOutputLayer().getError();
    }

    private void createLayers(int[] structure){
        layers = new Layer[hiddenLayersNumber + 1]; //plus output layer

        for (int i = 0; i < layers.length; i++){
            layers[i] = new Layer(structure[i]);
        }
    }

    private void createPerceptrons(){
        int perceptronInputs = netInputsNumber;

        for (Layer layer : layers) {
            layer.createPerceptrons(perceptronInputs, eta, function);
            perceptronInputs = layer.getSize();
        }
    }
}
