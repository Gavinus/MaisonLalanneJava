package com.example.maisonlalanne.model.repository;

import com.example.maisonlalanne.model.beans.BedroomBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BedroomRepository extends JpaRepository<BedroomBean, Long> {
    List<BedroomBean> findByNameAndDescription(String name, String description);
    List<BedroomBean> findByName(String name);

    Optional<BedroomBean> findById(Long id);

    List<BedroomBean> findByPicture(String picture);
    List<BedroomBean> findAll();

    List<BedroomBean> findByNameLikeIgnoreCase(String name);

    List<BedroomBean> findByDescription(String description);

    List<BedroomBean> findByNameLikeIgnoreCaseAndDescription(String name, String description);
}
