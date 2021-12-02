package com.projectlinkapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectlinkapi.model.Link;
import com.projectlinkapi.model.User;

@Repository
public interface  LinkRepository extends JpaRepository<Link, Long>{

	List<Link> findAllByCreatedBy(User user);

}
