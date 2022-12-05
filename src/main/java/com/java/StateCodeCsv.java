package com.java;

import com.opencsv.bean.CsvBindByName;

public class StateCodeCsv {

    @CsvBindByName(column = "State", required = true)
    public String state;

    @CsvBindByName(column = "Population", required = true)
    public int population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    public int areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public int densityPerSqKm;

    @CsvBindByName(column = "StateCode", required = true)
    public int stateCode;

    @Override
    public String toString() {
        return "StateCodeCsv{" +
                "state='" + state + '\'' +
                ", population=" + population +
                ", areaInSqKm=" + areaInSqKm +
                ", densityPerSqKm=" + densityPerSqKm +
                ", stateCode=" + stateCode +
                '}';
    }
}

