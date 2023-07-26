package com.example.maisonlalanne.model.repository;
import com.example.maisonlalanne.model.beans.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Long> {
    UserBean findByName(String name);
    UserBean findByFirstname(String firstname);
    UserBean findByEmail(String email);
    UserBean findByPhonenumber(String phonenumber);

    UserBean findByEmailAndPasswordEqualsIgnoreCase(String email, String password);
    UserBean findByPasswordEqualsIgnoreCase(String email);

    UserBean findByNameEqualsIgnoreCase(String name);

    UserBean findByIdsession(String idsession);
}
