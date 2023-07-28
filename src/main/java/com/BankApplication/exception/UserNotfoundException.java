package com.BankApplication.exception;

// define a class that extends the Runtime exception class
// the serialVersionUID attribute is an identifier that is used to
// serialize/deserialize an object of a Serializable class.
// visit https://www.baeldung.com/java-serial-version-uid for more info.
public class UserNotfoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}
