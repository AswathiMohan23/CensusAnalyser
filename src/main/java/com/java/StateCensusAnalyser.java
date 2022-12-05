package com.java;

import java.io.IOException;

public class StateCensusAnalyser {
    static  CensusAnalyser censusAnalyser=new CensusAnalyser();
    public void stateCensusData(String csvFile) throws CensusAnalyserException, IOException {
        censusAnalyser.loadCensusData(csvFile);

    }
}
