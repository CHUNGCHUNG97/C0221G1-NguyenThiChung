package caseStudy.FuramaResort.Exceptions;

public class GenderException extends Exception{
    public GenderException() {
        super("phải nhập vào Male, Female hoặc Unknow");
    }
}
