package com.projectbasicapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectbasicapi.model.Item;
import com.projectbasicapi.model.User;

@Repository
public interface  ItemRepository extends JpaRepository<Item, Long>{

	List<Item> findAllByCreatedBy(User user);

}
