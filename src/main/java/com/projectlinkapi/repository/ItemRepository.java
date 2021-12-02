package com.projectlinkapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectlinkapi.model.Item;
import com.projectlinkapi.model.User;

@Repository
public interface  ItemRepository extends JpaRepository<Item, Long>{

	List<Item> findAllByCreatedBy(User user);

}
