package com.example.maisonlalanne.model.repository;

import com.example.maisonlalanne.model.beans.BedroomBean;
import com.example.maisonlalanne.model.beans.ReservationBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BedroomRepository extends JpaRepository<BedroomBean, Long> {
    List<BedroomBean> findByNameAndDescription(String name, String description);
    List<BedroomBean> findByName(String name);

    List<BedroomBean> findAll();

    List<BedroomBean> findByNameLikeIgnoreCase(String name);

    List<BedroomBean> findByDescription(String description);

    List<BedroomBean> findByNameLikeIgnoreCaseAndDescription(String name, String description);
}
