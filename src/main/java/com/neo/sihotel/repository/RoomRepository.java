package com.neo.sihotel.repository;

import com.neo.sihotel.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {

}