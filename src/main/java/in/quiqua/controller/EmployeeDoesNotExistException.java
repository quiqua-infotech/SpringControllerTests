package in.quiqua.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeDoesNotExistException extends RuntimeException {

    EmployeeDoesNotExistException(Long id) {
        super(String.format("An employee with ID '%d' doesn't exist!", id));
    }
}
