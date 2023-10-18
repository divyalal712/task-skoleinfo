package no.skole.task.exception;

import org.springframework.http.HttpStatusCode;

public class SkoleException extends RuntimeException {

    private final HttpStatusCode statusCode;

    public SkoleException(HttpStatusCode statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }
}
