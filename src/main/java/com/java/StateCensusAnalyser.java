package com.java;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    public static int numOfEntries = 0;

    public int loadStateCensusData(String csvFilePath) throws CensusAnalyserException {
        StateCodeCsv censusData = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<StateCodeCsv> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(StateCodeCsv.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<StateCodeCsv> csvToBean = csvToBeanBuilder.build();
            Iterator<StateCodeCsv> censusCSVIterator = csvToBean.iterator();;
            while (censusCSVIterator.hasNext()) {
                numOfEntries++;
                censusData = censusCSVIterator.next();
            }
            return numOfEntries;
        } catch (IOException e) {
            throw new CensusAnalyserException();
        }
    }

    public int numberOfEntries(String csvFile) throws CensusAnalyserException {
        try {
            loadStateCensusData(csvFile);
            return numOfEntries;
        } catch (CensusAnalyserException e) {
            throw new CensusAnalyserException();
        }
    }
}
