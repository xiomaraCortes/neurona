package com.example.demo.service.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkResponseDTO {

    private List<Double> input;

    private List<Double> height;

    private Double tangent;

    public NetworkResponseDTO() {
    }

    public NetworkResponseDTO(List<Double> input, List<Double> height, Double tangent) {
        this.input = input;
        this.height = height;
        this.tangent = tangent;
    }

    public List<Double> getInput() {
        return input;
    }

    public void setInput(List<Double> input) {
        this.input = input;
    }

    public List<Double> getHeight() {
        return height;
    }

    public void setHeight(List<Double> height) {
        this.height = height;
    }

    public Double getTangent() {
        return tangent;
    }

    public void setTangent(Double tangent) {
        this.tangent = tangent;
    }
}