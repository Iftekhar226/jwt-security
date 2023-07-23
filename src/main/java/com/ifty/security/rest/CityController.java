package com.ifty.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ifty.security.model.City;
import com.ifty.security.model.MainResponce;
import com.ifty.security.model.Pagi;
import com.ifty.security.repo.CityRepo;

@RestController
public class CityController {
	@Autowired
	CityRepo repo;
	
	

	@PostMapping("/all")
	@CrossOrigin(origins="http://localhost:4200")
	public MainResponce getAll( @RequestBody() Pagi data){
		MainResponce res = new MainResponce();
		Pageable page = PageRequest.of(data.getOffset(),data.getLimit());
		System.out.println(data);
 Page<City> getww = this.repo.getww(data.getCc(),data.getPopulation(),page);
		//return this.repo.findAll(page).getContent();
 
  res.setCityList(getww.getContent());
  res.setCuurentPage("number ----  " +getww.getTotalElements());
  res.setTotalRecord(" size --- "+getww.getSize());
  res.setTotalElement("total ele ---- " + "   --> " +getww.getTotalPages() + " --- >  " +getww.getTotalElements());
 res.setNextPage(getww.getNumberOfElements());
  System.out.println(getww.toString());
  return res;
	}


	@PostMapping("/all/list")
	@CrossOrigin(origins="http://localhost:4200")
	public MainResponce getAllWithList( @RequestBody() Pagi data){
		MainResponce res = new MainResponce();
		Pageable page = PageRequest.of(data.getOffset(),data.getLimit());
		System.out.println(data);
 Page<City> getww = this.repo.getww(page,data.getCityL());
		//return this.repo.findAll(page).getContent();
 
  res.setCityList(getww.getContent());
  res.setCuurentPage("number ----  " +getww.getTotalElements());
  res.setTotalRecord(" size --- "+getww.getSize());
  res.setTotalElement("total ele ---- " + "   --> " +getww.getTotalPages() + " --- >  " +getww.getTotalElements());
 res.setNextPage(getww.getNumberOfElements());
  System.out.println(getww.toString());
  return res;
	}
	@GetMapping("/getdata")
	public Pagi getdata( @RequestBody() Pagi data) {
		return data;
	}
}
