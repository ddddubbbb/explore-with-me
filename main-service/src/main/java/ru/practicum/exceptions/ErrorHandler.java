package ru.practicum.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.practicum.category.CategoryController;
import ru.practicum.compilation.CompilationController;
import ru.practicum.event.EventController;
import ru.practicum.request.ParticipationRequestController;
import ru.practicum.user.UserController;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice(assignableTypes = {
        UserController.class,
        CategoryController.class,
        EventController.class,
        ParticipationRequestController.class,
        CompilationController.class})
public class ErrorHandler {

    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @ExceptionHandler({MethodArgumentNotValidException.class,
            ValidationRequestException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(Exception e) {
        return new ApiError("BAD_REQUEST", "Incorrectly made request.",
                e.getMessage(), LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
    }

    @ExceptionHandler({
            UserNotFoundException.class,
            CategoryNotFoundException.class,
            EventNotFoundException.class,
            RequestNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleObjectNotFoundException(EntityNotFoundException e) {
        return new ApiError("NOT_FOUND", "The required object was not found.",
                e.getMessage(), LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
    }

    @ExceptionHandler({
            DataIntegrityViolationException.class,
            ConstraintViolationException.class,
            ForbiddenException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleValidationException(ConstraintViolationException e) {
        return new ApiError("CONFLICT", "Integrity constraint has been violated.",
                e.getMessage(), LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handlerOtherException(Throwable e) {
        return new ApiError("INTERNAL SERVER ERROR", "An unexpected error has occurred.",
                e.getMessage(), LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
    }
}