package ru.netology.spring_REST_homework.repository;

import org.springframework.stereotype.Repository;
import ru.netology.spring_REST_homework.Authorities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
//        new ArrayList<>(Arrays.asList(Authorities.READ));
        return Collections.emptyList();
    }
}
