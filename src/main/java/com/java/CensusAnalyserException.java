package com.java;

public class CensusAnalyserException extends Exception {

    public CensusAnalyserException() {
        super();
    }

    enum ExceptionType {
        Incorrect_Delimiter_OR_wrong_Header, WRONG_FILE_TYPE, CENSUS_FILE_PROBLEM
    }

    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
