# Example for Request Validation with JSR380 Annotations

To validate an object, put the validation annotation on the field:
```
@NotNull( message = "email cannot be null")
private EmailAddress emailAddress;
```
Fot Spring Boot 3, these annotation need to be from the Jakarta EE package:
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
To return the validation error as JSON, you need to transfer them into the response object. This can be done globaly or in the controller:
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