package com.mrsisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.entity.clinic.Room;
import com.mrsisa.service.clinic.RoomService;


@RestController
@RequestMapping("room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	//test
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Page<Room>> getAll(Pageable pageable){
		Page<Room> page = roomService.findAll(pageable);
		return new ResponseEntity<Page<Room>>(page, HttpStatus.OK);
	}
}

