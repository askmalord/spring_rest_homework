package ru.netology.spring_REST_homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.spring_REST_homework.Authorities;
import ru.netology.spring_REST_homework.exception.InvalidCredentials;
import ru.netology.spring_REST_homework.exception.UnauthorizedUser;
import ru.netology.spring_REST_homework.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        try {
            List<Authorities> authorities = service.getAuthorities(user, password);
            return authorities;
        } catch (InvalidCredentials exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        } catch (UnauthorizedUser exc) {
            System.out.println(exc.getMessage());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, exc.getMessage(), exc);
        }
    }
}
