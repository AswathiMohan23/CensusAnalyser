package com.java;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
    static String CENSUS_FILE_PATH ="src/main/java/com/inputFiles/Census.csv";
    static String WRONG_CENSUS_FILE ="src/main/java/com/Census.csv";

    static CensusAnalyser censusAnalyser=new CensusAnalyser();
    @Test
    public void ifNoOfRecordMatchesReturnTrue() throws CensusAnalyserException {
        int numOfEntries=censusAnalyser.numberOfEntries(CENSUS_FILE_PATH);
        Assert.assertEquals(29,numOfEntries);
    }
    @Test
    public void ifWrongFileIsGivenThenShouldReturnException() throws CensusAnalyserException {
        try {
            int numOfEntries=censusAnalyser.loadIndiaCensusData(WRONG_CENSUS_FILE);
        }catch (CensusAnalyserException e){
            System.out.println(CensusAnalyserEnum.WRONG_FILE);
        }
    }


}
