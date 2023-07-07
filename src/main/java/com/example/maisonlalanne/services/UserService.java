package com.example.maisonlalanne.services;

import com.example.maisonlalanne.model.beans.UserBean;
import com.example.maisonlalanne.model.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userrepository;


    public List<UserBean> getAllUser() {
        System.out.println("userService");
        return userrepository.findAll();
    }

    public UserBean getById(Long id) {
        if (id == null) {
            return null;
        }

        return userrepository.findById(id).orElse(null);
    }

    public UserBean getUserByIdSession(String idSession) {
        return userrepository.findByIdsession(idSession);
    }

    //Si l'utilisateur n'existe aps l'insert sinon vérifie son mdp
    //Et met à jour sa session
    public UserBean checkUserSession(UserBean userBean, HttpSession session) throws Exception {

        //userBean.setEmail(userBean.getEmail().trim());

        UserBean userRegister = userrepository.findByEmailAndPasswordEqualsIgnoreCase(userBean.getEmail(), userBean.getPassword());


        if (userRegister == null) {
            //insert
            userBean.setIdsession(session.getId());
            userrepository.save(userBean);
            return userBean;
        } else {
            //Verif de mot de passe
            if (!userRegister.getEmail().equals(userBean.getEmail())) {
                throw new Exception("email incorrect");
            } else if (!userRegister.getPassword().equals(userBean.getPassword())){
                //retour incorrect
                throw new Exception("Mot de passe incorrect");
            } else {
                //je mets à jour son idsession
                userRegister.setIdsession(session.getId());
                userrepository.save(userRegister);
                return userRegister;
            }
        }
    }

    public void addOrUpdateUser(UserBean toSave) throws Exception {
        //Controle des données
        if (toSave == null) {
            throw new Exception("user missing");
        } else if (toSave.getName() == null || toSave.getName().length() == 0) {
            throw new Exception("Name missing");
        } else if (toSave.getFirstname() == null || toSave.getFirstname().length() == 0) {
            throw new Exception("FirstName missing");
        } else if (toSave.getEmail() == null || toSave.getEmail().length() == 0) {
            throw new Exception("Email incorrecte");
        } else if (toSave.getPhonenumber() == null || toSave.getPhonenumber().length() == 0 || toSave.getPhonenumber().length() < 10) {
            throw new Exception("Numero telephone incorrecte");
        }

        //Si on a le même code on modifie pour le name
        UserBean fromBaseName = userrepository.findByName(toSave.getName());
        if (fromBaseName != null) {
            //Si ce code est déjà en base
            toSave.setId(fromBaseName.getId());
        }
        //Si on a le même code on modifie pour le firstname
        UserBean fromBaseFirstName = userrepository.findByFirstname(toSave.getFirstname());
        if (fromBaseFirstName != null) {
            //Si ce code est déjà en base
            toSave.setId(fromBaseFirstName.getId());
        }
        //Si on a le même code on modifie pour le email
        UserBean fromBaseEmail = userrepository.findByEmail(toSave.getEmail());
        if (fromBaseEmail != null) {
            //Si ce code est déjà en base
            toSave.setId(fromBaseEmail.getId());
        }
        //Si on a le même code on modifie pour le telephone
        UserBean fromBaseTel = userrepository.findByPhonenumber(toSave.getPhonenumber());
        if (fromBaseTel != null) {
            //Si ce code est déjà en base
            toSave.setId(fromBaseTel.getId());
        }

        userrepository.save(toSave);
    }

}
