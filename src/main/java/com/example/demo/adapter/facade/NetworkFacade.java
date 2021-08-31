package com.example.demo.adapter.facade;

import com.example.demo.service.NetworkService;
import com.example.demo.service.model.request.NetworkRequestDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NetworkFacade {


    final static Logger logger = Logger.getLogger(NetworkFacade.class);

    private NetworkService networkService;

    @Autowired
    public NetworkFacade(NetworkService networkService) {
    	this.networkService = networkService;
    }

    @Async
    public Object executeNetworkMultiLayer(NetworkRequestDTO networkRequestDTO){
         return this.networkService.executeNetworkMultiLayer(networkRequestDTO);
    }
}
