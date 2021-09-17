package com.example.demo.service;
import com.example.demo.service.model.request.NetworkRequestDTO;
import com.example.demo.service.model.response.DataResponseDTO;
import com.example.demo.service.model.response.NetworkResponseDTO;
import com.example.demo.utils.Neurona;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NetworkService {
	
	final static Logger logger = Logger.getLogger(NetworkService.class);

	public DataResponseDTO executeNetworkMultiLayer(NetworkRequestDTO networkRequestDTO)  {

		Neurona n = new Neurona(networkRequestDTO.getInput(), networkRequestDTO.getError(),networkRequestDTO.getKnowledgeFactor());

		DataResponseDTO   dataResponseDTO= new DataResponseDTO( );
		NetworkResponseDTO networkResponseDTO = new NetworkResponseDTO(networkRequestDTO.getInput(), n.getWeight(), n.getTangent());
		dataResponseDTO.setData(networkResponseDTO);
		return dataResponseDTO;

	}
}