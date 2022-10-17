package deqode.assessment.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import deqode.assessment.com.constants.EResponse;
import deqode.assessment.com.entity.Battery;
import deqode.assessment.com.service.BatteryService;
import deqode.assessment.com.utility.BaseResponse;

@RestController
@RequestMapping("/battery")
public class BatteryController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BatteryService batteryService;

	@PostMapping("/")
	public ResponseEntity<BaseResponse> addBatteryDetails(@RequestBody List<Battery> battery) {
		log.info("Inside addBatteryDetails");
		BaseResponse response = new BaseResponse();
		try {
			List<Battery> batteryDeatils = batteryService.addBatteryDetails(battery);
			response.setResponseCode(EResponse.SUCCESS.getCode());
			response.setResponseMessage(EResponse.SUCCESS.getMessage());
			response.setResponseBody(batteryDeatils);
		} catch (Exception e) {
			response.setResponseCode(EResponse.FAILED.getCode());
			response.setResponseMessage(EResponse.FAILED.getMessage());
			response.setResponseBody(e.getMessage());

		}
		log.info("Exit addBatteryDetails");
		return ResponseEntity.ok(response);
	}

	@GetMapping("/findbatterynames/{postcoderange}")
	public ResponseEntity<BaseResponse> findBatteries(@PathVariable("postcoderange") String postcoderange) {
		log.info("Inside findBatteries");
		BaseResponse response = new BaseResponse();
		try {
			List<Battery> names = batteryService.findNamesOfBattery(postcoderange);
			response.setResponseCode(EResponse.SUCCESS.getCode());
			response.setResponseMessage(EResponse.SUCCESS.getMessage());
			response.setResponseBody(names);
		} catch (Exception e) {
			response.setResponseCode(EResponse.FAILED.getCode());
			response.setResponseMessage(EResponse.FAILED.getMessage());
			response.setResponseBody(e.getMessage());

		}
		log.info("Exit findBatteries");
		return ResponseEntity.ok(response);
	}

}
