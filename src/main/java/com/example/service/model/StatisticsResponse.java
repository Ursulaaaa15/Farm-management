package com.example.service.model;

import java.time.LocalDate;

public class StatisticsResponse {
    private int totalHarvested;
    private LocalDate date;

    public int getTotalHarvested() {
        return totalHarvested;
    }

    public void setTotalHarvested(int totalHarvested) {
        this.totalHarvested = totalHarvested;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}