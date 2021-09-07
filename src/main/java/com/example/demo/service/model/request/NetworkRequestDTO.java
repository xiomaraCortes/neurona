package com.example.demo.service.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkRequestDTO {

    private List<Double> input;

    public NetworkRequestDTO() {
    }

    public NetworkRequestDTO(List<Double> input) {
        this.input = input;
    }

    public List<Double> getInput() {
        return input;
    }

    public void setInput(List<Double> input) {
        this.input = input;
    }
}
