package com.mrsisa.service.clinic;

import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.clinic.Room;
import com.mrsisa.repository.RoomRepository;

@Service
public class RoomService extends CRUDService<Room, Long>{

	public RoomService(RoomRepository repo) {
		super(repo);
	}
	
}
