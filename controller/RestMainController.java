package gntp.bbulsora.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gntp.bbulsora.project.service.HomeService;

@RestController("restMainController")
public class RestMainController {
	@Autowired
	private HomeService homeService;
	
	public ResponseEntity<String> idCheck(@RequestParam("id") String id) {
		boolean flag = false;
		flag = homeService.idCheck(id);
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}
}
