package com.mrsisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.entity.clinic.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

}
