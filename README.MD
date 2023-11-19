# Example for Request Validation with JSR380 Annotations

The examples is implemented by two simple REST-Controller that expose the Account- and AccountStatement-Endpoints.

To validate an object, put the validation annotation on the field in the domain class:
```
@NotNull( message = "email cannot be null")
private EmailAddress emailAddress;
```

Since Spring Boot 3, these annotation need to be from the Jakarta EE package.
```
import jakarta.validation.constraints.NotNull;
```

To activate the validation, you need the @Valid annotation on the method of the controller:
```
import jakarta.validation.Valid;
....
@PostMapping
   public Account postAccount(@Valid @RequestBody Account account){
       return accountService.postAccount(account);
}
```

To return the validation error as a JSON object, you need to transfer them from the exception to the response object. This can be done globally or in the controlle by an ExceptionHandler that catches the MethodArgumentNotValidException:
```
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException.class)
public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage()));
    return errors;
}
```