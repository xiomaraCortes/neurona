package com.example.demo.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
        String dto = "-1.0,-1.0,-1.0,-1.0,-1.0\n"
                + "-1.0,-1.0,-1.0,1.0,-1.0\n"
                + "-1.0,-1.0,1.0,-1.0,-1.0\n"
                + "-1.0,-1.0,1.0,1.0,-1.0\n"
                + "-1.0,1.0,-1.0,-1.0,-1.0\n"
                + "-1.0,1.0,-1.0,1.0,-1.0\n"
                + "-1.0,1.0,1.0,-1.0,-1.0\n"
                + "-1.0,1.0,1.0,1.0,-1.0\n"
                + "1.0,-1.0,-1.0,-1.0,-1.0\n"
                + "1.0,-1.0,-1.0,1.0,1.0\n"
                + "1.0,-1.0,1.0,-1.0,1.0\n"
                + "1.0,-1.0,1.0,1.0,1.0\n"
                + "1.0,1.0,-1.0,-1.0,1.0\n"
                + "1.0,1.0,-1.0,1.0,1.0\n"
                + "1.0,1.0,1.0,-1.0,1.0\n"
                + "1.0,1.0,1.0,1.0,1.0";

        Double[][] fieldsArray = new Double[16][5];

        String[] fields = dto.split("\n");

        for (int i = 0; i < fields.length; i++) {
            String[] tmp = fields[i].split(",");
            for (int j = 0; j < tmp.length; j++) {
                fieldsArray[i][j] = Double.parseDouble(tmp[j]);
            }
        }

        List<String> position = new ArrayList<>();

        for (Double input1 : input) {
            for (int column = 0; column < 16; column++) {
                if (Objects.equals(fieldsArray[column][0], input1)) {
                    position.add(0 + "," + column);
                }
            }
            break;
        }

        for (int i = 0; i < position.size(); i++) {
            String item = position.get(i);
            Integer columnItem = Integer.parseInt(item.split(",")[1]);
            Integer rowItem = Integer.parseInt(item.split(",")[0]);
            if (checkFirstItem(input, fieldsArray, columnItem, rowItem) != -999.9) {
                return checkFirstItem(input, fieldsArray, columnItem, rowItem);
            }

        }
        return resolver(input.get(0));
    }

    private  Double checkFirstItem(List<Double> input, Double[][] fieldsArray, Integer columItem, Integer rowItem) {
        if (Objects.equals(input.get(0), fieldsArray[columItem][rowItem])
                && Objects.equals(input.get(1), fieldsArray[columItem][rowItem + 1])
                && Objects.equals(input.get(2), fieldsArray[columItem][rowItem + 2])
                && Objects.equals(input.get(3), fieldsArray[columItem][rowItem + 3])) {
            return fieldsArray[columItem][rowItem + 4];
        }
        return -999.9;
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
