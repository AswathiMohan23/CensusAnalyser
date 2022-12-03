package com.java;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
    static String CENSUS_FILE_PATH ="src/main/java/com/java/Census.csv";
    static CensusAnalyser censusAnalyser=new CensusAnalyser();
    @Test
    public void ifNoOfRecordMatchesReturnTrue() throws CensusAnalyserException {
        int numOfEntries=censusAnalyser.loadIndiaCensusData(CENSUS_FILE_PATH);
        Assert.assertEquals(29,numOfEntries);
    }
    @Test
    public void ifNoOfRecordDoesNotMatchReturnFalse() throws CensusAnalyserException {
            try {
                int numOfEntries=censusAnalyser.loadIndiaCensusData(CENSUS_FILE_PATH);
                Assert.assertEquals(40,numOfEntries);
            }catch (CensusAnalyserException e){
                System.out.println(CensusAnalyserEnum.FALSE_ENTRY);
        }
    }

}
