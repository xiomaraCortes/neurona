package com.example.demo.utils;

import java.util.List;

public class Neurona {

    List<Integer> input;

    List<Double> weight;

    public Neurona(List<Integer> input, List<Double> weight) {
        this.input = input;
        this.weight = weight;
    }

    public double getTangent() {
        double wx  = 0;


        for(int i =0; i < this.input.size() ; i++) {
            wx = wx + (this.input.get(i) * this.weight.get(i));
        }

        return Math.tanh(wx);
    }
}
