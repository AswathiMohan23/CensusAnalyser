package com.java;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class CensusAnalyserTest {
    static String CENSUS_FILE_PATH ="src/main/java/com/inputFiles/Census.csv";
    static String STATE_CODE_FILE_PATH ="src/main/java/com/inputFiles/StateCode.csv";
    static String WRONG_CENSUS_FILE ="src/main/java/com/Census.csv";
    static String WRONG_STATE_CODE_FILE ="src/main/java/com/Code.csv";
    static String WRONG_DELIMITER ="src/main/java/com/inputFiles/WrongDelimiter.csv";
    static String WRONG_DELIMITER_STATE ="src/main/java/com/inputFiles/StateCodeWrongDelimiter.csv";
    static String WRONG_HEADER ="src/main/java/com/inputFiles/WrongHeader.csv";
    static String STATE_CODE_WRONG_HEADER ="src/main/java/com/inputFiles/StateCodeWrongHeader.csv";

    static CensusAnalyser censusAnalyser=new CensusAnalyser();
    @Test
    public void ifNoOfRecordMatchesReturnTrue() throws CensusAnalyserException {
        int numOfEntries=censusAnalyser.numberOfEntriesInIndianCensusData(CENSUS_FILE_PATH);
        Assert.assertEquals(29,numOfEntries);
    }
    @Test
    public void givenIndiaCensusDataWithWrongFileTypeShouldThrowException () {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndianCensusData(WRONG_CENSUS_FILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }

    @Test
    public void givenIndiaCensusDataWithWrongDelimiterShouldThrowException () throws CensusAnalyserException {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndianCensusData(WRONG_DELIMITER );
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.Incorrect_Delimiter_OR_wrong_Header, e.type);
        }

    }
    @Test
    public void givenIndiaCensusDataWithWrongHeaderShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndianCensusData(WRONG_HEADER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.Incorrect_Delimiter_OR_wrong_Header, e.type);
        }
    }
   @Test
   public void ifNoOfStateCodeRecordsMatchesReturnTrue() throws CensusAnalyserException {
       int numOfEntries=censusAnalyser.numberOfEntriesInStateCodeData(STATE_CODE_FILE_PATH);
       Assert.assertEquals(29,numOfEntries);
   }
    @Test
    public void givenStateCodeDataWithWrongDelimiterShouldThrowException () throws CensusAnalyserException {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadStateCodeData(WRONG_DELIMITER_STATE );
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.Incorrect_Delimiter_OR_wrong_Header, e.type);
        }
    }
    @Test
    public void givenStateCodeDataWithWrongHeaderShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadStateCodeData(STATE_CODE_WRONG_HEADER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.Incorrect_Delimiter_OR_wrong_Header, e.type);
        }
    }
    @Test
    public void givenStateCodeDataWithWrongFileTypeShouldThrowException () {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadStateCodeData(WRONG_STATE_CODE_FILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }
}
