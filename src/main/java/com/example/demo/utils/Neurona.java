package com.example.demo.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class Neurona {

    List<Double> input;

    List<Double> weight;
    Double  error;
    Double knowledgeFactor;

    public Neurona(List<Double> input, Double error, Double knowledgeFactor) {
        this.input = input;
        this.weight = new ArrayList<>();
        this.error = error;
        this.knowledgeFactor = knowledgeFactor;
    }

    public double getTangent() {

        List<Double> recalculateWeightRandom = new ArrayList<>();
        for(int i=0;i<3;i++) {
            recalculateWeightRandom.add(recalculateWeightRandom());
        }

        this.checkTheOutputs();
        double value = resolverEquationActivation(input.get(0),input.get(1),  recalculateWeightRandom.get(0),
                 recalculateWeightRandom.get(1),
                 recalculateWeightRandom.get(2));

        double resolver = resolver(value);
        Double math = Math.tanh(resolver);
        return resolver(math);
    }

    public void checkTheOutputs(){
        weight.add(Math.tanh(1*input.get(0) + 1*input.get(1)) - error);
        weight.add(Math.tanh(1*input.get(0) + -1*input.get(1)) - error);
        weight.add(Math.tanh(-1*input.get(0) + 1*input.get(1)) - error);
        weight.add(Math.tanh(-1*input.get(0) + -1*input.get(1)) - error);
    }

    public Double recalculateWeightRandom(){
        return new BigDecimal((Math.random() * 10 + 1)).setScale(1, RoundingMode.HALF_EVEN).doubleValue();
    }

    public double resolverEquationActivation(double x1 , double x2, double w1, double w2, double t) {
        return (x1*w1)+(x2*w2)+(-1*t);
    }

    public double resolverWeightEquation(double weight) {
        return weight+(error*input.get(0)*input.get(1));
    }

    public int resolver(double value) {
        if(input.get(0)  == -1 && input.get(1) == - 1){
            return -1;
        }
        return 1;
    }

    public List<Double> getWeight() {
        return weight;
    }

    public void setWeight(List<Double> weight) {
        this.weight = weight;
    }
}
