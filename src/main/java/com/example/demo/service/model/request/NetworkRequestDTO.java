package com.example.demo.service.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkRequestDTO {

    private List<Double> input;
    private Double  e;
    private Double knowledgeFactor;
    public NetworkRequestDTO() {
    }

    public NetworkRequestDTO(List<Double> input, Double e, Double knowledgeFactor) {
        this.input = input;
        this.e = e;
        this.knowledgeFactor = knowledgeFactor;
    }

    public List<Double> getInput() {
        return input;
    }

    public void setInput(List<Double> input) {
        this.input = input;
    }

    public Double getError() {
        return e;
    }

    public void setError(Double e) {
        this.e = e;
    }

    public Double getKnowledgeFactor() {
        return knowledgeFactor;
    }

    public void setKnowledgeFactor(Double knowledgeFactor) {
        this.knowledgeFactor = knowledgeFactor;
    }
}
