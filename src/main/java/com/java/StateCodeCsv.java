package com.java;

public class StateCodeCsv {
    static  CensusAnalyser censusAnalyser=new CensusAnalyser();
    public void stateCensusData(String csvFile) throws CensusAnalyserException {
        censusAnalyser.loadCensusData(csvFile);

    }
}
