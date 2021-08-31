package com.example.demo.service.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkRequestDTO {

    private List<Integer> input;

    public NetworkRequestDTO() {
    }

    public NetworkRequestDTO(List<Integer> input) {
        this.input = input;
    }

    public List<Integer> getInput() {
        return input;
    }

    public void setInput(List<Integer> input) {
        this.input = input;
    }
}
