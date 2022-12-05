package com.java;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class CensusAnalyserTest {
    static String CENSUS_FILE_PATH ="src/main/java/com/inputFiles/Census.csv";
    static String STATE_CODE_FILE_PATH ="src/main/java/com/inputFiles/StateCode.csv";
    static String WRONG_CENSUS_FILE ="src/main/java/com/Census.csv";
    static String WRONG_DELIMITER ="src/main/java/com/inputFiles/WrongDelimiter.csv";
    static String WRONG_HEADER ="src/main/java/com/inputFiles/WrongHeader.csv";

    static CensusAnalyser censusAnalyser=new CensusAnalyser();
    @Test
    public void ifNoOfRecordMatchesReturnTrue() throws CensusAnalyserException {
        int numOfEntries=censusAnalyser.numberOfEntries(CENSUS_FILE_PATH);
        Assert.assertEquals(29,numOfEntries);
    }

    @Test
    public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException () {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadCensusData(WRONG_CENSUS_FILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
        } catch (NoSuchFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void ifWrongDelimiterShouldThrowException() throws CensusAnalyserException, CsvValidationException, IOException {
        try {
            censusAnalyser.loadIndianCensusData(WRONG_DELIMITER);
        } catch (CensusAnalyserException e) {
            System.out.println(CensusAnalyserEnum.WRONG_DELIMITER);
        }
    }


   @Test
   public void ifNoOfStateCodeRecordsMatchesReturnTrue() throws CensusAnalyserException {
       int numOfEntries=censusAnalyser.numberOfEntries(STATE_CODE_FILE_PATH);
       Assert.assertEquals(29,numOfEntries);
   }
}
