package caseStudy.FuramaResort.Exceptions;

public class EmailException extends Exception {
    public EmailException() {
        super("Email phải đúng định dạng abc@abc.abc");
    }
}
