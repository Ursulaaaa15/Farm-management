package com.example.service.controller;

import com.example.service.model.StatisticsResponse;
import com.example.service.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics/daily")
    public ResponseEntity<?> getDailyStatistics(@RequestParam LocalDate date) {
        StatisticsResponse dailyStatistics = statisticsService.getDailyStatistics(date);
        return ResponseEntity.ok(dailyStatistics);
    }

    @GetMapping("/statistics/weekly")
    public ResponseEntity<?> getWeeklyStatistics(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        StatisticsResponse weeklyStatistics = (StatisticsResponse) statisticsService.getWeeklyStatistics(startDate, endDate);
        return ResponseEntity.ok(weeklyStatistics);
    }

    @GetMapping("/statistics/monthly")
    public ResponseEntity<?> getMonthlyStatistics(@RequestParam int year, @RequestParam int month) {
        StatisticsResponse monthlyStatistics = statisticsService.getMonthlyStatistics(year, month);
        return ResponseEntity.ok(monthlyStatistics);
    }

    @GetMapping("/statistics/yearly")
    public ResponseEntity<?> getYearlyStatistics(@RequestParam int year) {
        StatisticsResponse yearlyStatistics = statisticsService.getYearlyStatistics(year);
        return ResponseEntity.ok(yearlyStatistics);
    }
}

