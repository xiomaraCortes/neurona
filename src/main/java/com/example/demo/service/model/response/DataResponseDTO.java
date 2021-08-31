package com.example.demo.service.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataResponseDTO {

    private NetworkResponseDTO data;

    public DataResponseDTO() {
    }

    public DataResponseDTO(NetworkResponseDTO data) {
        this.data = data;
    }

    public NetworkResponseDTO getData() {
        return data;
    }

    public void setData(NetworkResponseDTO data) {
        this.data = data;
    }
}
