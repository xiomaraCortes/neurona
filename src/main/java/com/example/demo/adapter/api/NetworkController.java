package com.example.demo.adapter.api;

import com.example.demo.adapter.ApiConst;
import com.example.demo.adapter.facade.NetworkFacade;
import com.example.demo.service.model.request.NetworkRequestDTO;
import com.example.demo.utils.exception.ConstantErrors;
import com.example.demo.utils.exception.UMBErrorEnum;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = ApiConst.LOGIN_PATH)
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class NetworkController {

    final static Logger logger = Logger.getLogger(NetworkController.class);
    
    private NetworkFacade networkFacade;
    private Gson gson;
    
    @Autowired
    public NetworkController(NetworkFacade networkFacade, Gson gson) {
        this.networkFacade = networkFacade;
        this.gson = gson;
    }
    
	@GetMapping("/message")
	public String getMessage() {
		return "V20200914_01";
	}

	@RequestMapping(value = "/network/", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getNetworkMultiLayer(@RequestBody NetworkRequestDTO networkRequestDTO) {
		try {
			return new ResponseEntity<String>(this.gson.toJson(this.networkFacade.executeNetworkMultiLayer(networkRequestDTO)), HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error("Se presentaron problemas enviar la checkFields en el controller getBuses",e);
			return new ResponseEntity<String> (this.gson.toJson(ConstantErrors.ERRORS_STATES.get(UMBErrorEnum.GENERIC_ERROR.getCode())), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
