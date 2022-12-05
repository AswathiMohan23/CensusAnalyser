package com.java;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {
    public static int numOfEntries = 0;
    public static int numOfStateEntries = 0;

    public int loadIndianCensusData(String csvFilePath) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();;
            while (censusCSVIterator.hasNext()) {
                numOfEntries++;
                IndiaCensusCSV censusData = censusCSVIterator.next();
            }
            return numOfEntries;
        } catch (NoSuchFileException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
        }catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.Incorrect_Delimiter_OR_wrong_Header);
        }
        catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
    public int loadStateCodeData(String csvFilePath) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<StateCodeCsv> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(StateCodeCsv.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<StateCodeCsv> csvToBean = csvToBeanBuilder.build();
            Iterator<StateCodeCsv> censusCSVIterator = csvToBean.iterator();;
            while (censusCSVIterator.hasNext()) {
                numOfStateEntries++;
                StateCodeCsv  censusData = censusCSVIterator.next();
            }
            return numOfStateEntries;
        } catch (NoSuchFileException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
        }catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.Incorrect_Delimiter_OR_wrong_Header);
        }
        catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    public int numberOfEntriesInIndianCensusData(String csvFile) throws CensusAnalyserException {
        try {
            loadIndianCensusData(csvFile);
            return numOfEntries;
        } catch (CensusAnalyserException e) {
            throw new CensusAnalyserException();
        }
    }
    public int numberOfEntriesInStateCodeData(String csvFile) throws CensusAnalyserException {
        try {
            loadStateCodeData(csvFile);
            return numOfStateEntries;
        } catch (CensusAnalyserException e) {
            throw new CensusAnalyserException();
        }
    }
}