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

}
