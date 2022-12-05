package com.java;

public class StateCodeCsv {
    static  StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
    public void stateCensusData(String csvFile) throws CensusAnalyserException {
        stateCensusAnalyser.loadStateCensusData(csvFile);

    }
}
