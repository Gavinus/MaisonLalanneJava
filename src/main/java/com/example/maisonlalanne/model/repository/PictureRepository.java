package com.example.maisonlalanne.model.repository;
import com.example.maisonlalanne.model.beans.PictureBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<PictureBean, Long> {

    //repository pour trouver les chambres avec l'id
    List<PictureBean> findByBedroomId(Long bedroomId);
}
