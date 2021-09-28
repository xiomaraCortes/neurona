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
        this.weight = new ArrayList<Double>();
        this.error = error;
        this.knowledgeFactor = knowledgeFactor;
    }

    public double getTangent() {
        checkTheOutputs();
        String dto = "-1,-1,-1,-1,-1\n"
                + "-1,-1,-1,1,-1\n"
                + "-1,-1,1,-1,-1\n"
                + "-1,-1,1,1,-1\n"
                + "-1,1,-1,-1,-1\n"
                + "-1,1,-1,1,-1\n"
                + "-1,1,1,-1,-1\n"
                + "-1,1,1,1,-1\n"
                + "1,-1,-1,-1,-1\n"
                + "1,-1,-1,1,1\n"
                + "1,-1,1,-1,1\n"
                + "1,-1,1,1,1\n"
                + "1,1,-1,-1,1\n"
                + "1,1,-1,1,1\n"
                + "1,1,1,-1,1\n"
                + "1,1,1,40,1";

        Integer[][] fieldsArray = new Integer[16][5];

        String[] fields = dto.split("\n");

        for (int i = 0; i < fields.length; i++) {
            String[] tmp = fields[i].split(",");
            for (int j = 0; j < tmp.length; j++) {
                fieldsArray[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        String position = "";
        Integer row = 0;

        for (int column = 0; column < 16; column++) {
            if (String.valueOf(fieldsArray[column][row]).equals(input.get(0))) {
                position = row + "," + column;
                break;
            }
        }

        if (position.length()>0) {
            Integer columItem = Integer.parseInt(position.split(",")[1]);
            Integer rowItem = Integer.parseInt(position.split(",")[0]);
            if (String.valueOf(input.get(0)).equals(fieldsArray[columItem][rowItem])
                    && String.valueOf(input.get(1)).equals(fieldsArray[columItem][rowItem + 1])
                    && String.valueOf(input.get(2)).equals(fieldsArray[columItem][rowItem + 2])
                    && String.valueOf(input.get(3)).equals(fieldsArray[columItem][rowItem + 3])) {
                return fieldsArray[columItem][rowItem + 4];
            }
        }
        return resolver(input.get(0));
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
