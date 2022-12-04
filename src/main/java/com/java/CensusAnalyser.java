package com.java;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {
    public static int numOfEntries = 0;
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
        IndiaCensusCSV censusData = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();;
            while (censusCSVIterator.hasNext()) {
                numOfEntries++;
                censusData = censusCSVIterator.next();
                System.out.println(censusData);

            }
            return numOfEntries;
        } catch (IOException e) {
            throw new CensusAnalyserException();
        }
   }

   public int numberOfEntries(String csvFile) throws CensusAnalyserException {
       try {
           loadIndiaCensusData(csvFile);
           return numOfEntries;
       } catch (CensusAnalyserException e) {
           throw new CensusAnalyserException();
       }
    }
}
