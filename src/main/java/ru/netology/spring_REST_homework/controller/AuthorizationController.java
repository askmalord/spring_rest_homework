package ru.netology.spring_REST_homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    ResponseEntity<String> handleICE(InvalidCredentials exc) {
      return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity<String> handleUUE(UnauthorizedUser exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
