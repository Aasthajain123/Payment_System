package com.PB1b.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PB1b.service.ACHService;
import com.PB1b.dto.Master_Biller;
import com.PB1b.dto.Registered_Billers;
import com.PB1b.dto.Bills;

@RestController
public class ACHController {

	@Autowired
	ACHService service;
	//View Billers available
	@GetMapping("/ViewMasterBillers")
	public List<Master_Biller> ViewMasterBillers(){
		return service.FindAllMasterBillers();
	}
	
	@GetMapping("/ViewRegBillers")
	public List<Registered_Billers> ViewRegBillers(){
		return service.FindAllRegisteredBillers();
	}
	
	@PostMapping("/RegBiller")
	public String RegisterBiller(@RequestBody Registered_Billers obj) {
		String status;
		status = "Biller Register";
		service.SaveRegisteredBiller(obj);	
		return status;
	}
	
	@DeleteMapping("DelRegBiller")
	public String DeleteRegBiller(@RequestBody Registered_Billers rbiller) {
		boolean flag = service.DeleteRegisteredBiller(rbiller.getRegId());
		if(flag) {
			return "Biller deleted Successfully";
		}else
		{
			return "Biller not deleted Successfully";
		}
	}
	
	@GetMapping("ViewBills")
	public List<Bills> ViewBills() {
		service.
	}
	
	@PostMapping("PayBill")
	public String PayBill(@RequestBody Bills bill) {
		
	}
	
	@GetMapping("/GetPaidBills/{Biller}")
	public String GetPaidBills(@PathVariable String Biller) {
		
	}
	
	
}
