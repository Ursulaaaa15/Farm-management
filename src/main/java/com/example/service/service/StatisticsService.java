package com.example.service.service;

import com.example.service.model.HarvestRecord;
import com.example.service.model.StatisticItem;
import com.example.service.model.StatisticsResponse;
import com.example.service.repository.HarvestRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {

    public StatisticsResponse getDailyStatistics(LocalDate date) {
        List<HarvestRecord> harvestRecords = harvestRecordRepository.findByDate(date);

        int totalHarvested = 0;
        for (HarvestRecord record : harvestRecords) {
            totalHarvested += record.getQuantity();
        }

        StatisticsResponse statisticsResponse = new StatisticsResponse();
        statisticsResponse.setTotalHarvested(totalHarvested);
        statisticsResponse.setDate(date);

        return statisticsResponse;
    }
    private final HarvestRecordRepository harvestRecordRepository;

    public StatisticsService(HarvestRecordRepository harvestRecordRepository) {
        this.harvestRecordRepository = harvestRecordRepository;
    }


    public List<StatisticItem> getWeeklyStatistics(LocalDate startDate, LocalDate endDate) {
        List<HarvestRecord> harvestRecords = harvestRecordRepository.findByDateBetween(startDate, endDate);
        List<StatisticItem> statistics = convertToStatisticItems(harvestRecords);

        return statistics;
    }

    public StatisticsResponse getMonthlyStatistics(int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);

        List<HarvestRecord> records = harvestRecordRepository.findByDateBetween(startDate, endDate);

        double totalHarvested = 0;
        for (HarvestRecord record : records) {
            totalHarvested += record.getQuantity();
        }

        StatisticsResponse response = new StatisticsResponse();
        response.setTotalHarvested((int) totalHarvested);

        return response;
    }

    public StatisticsResponse getYearlyStatistics(int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = startDate.plusYears(1).minusDays(1);

        List<HarvestRecord> records = harvestRecordRepository.findByDateBetween(startDate, endDate);

        double totalHarvested = 0;
        for (HarvestRecord record : records) {
            totalHarvested += record.getQuantity();
        }

        StatisticsResponse response = new StatisticsResponse();
        response.setTotalHarvested((int) totalHarvested);

        return response;
    }

    public List<StatisticItem> convertToStatisticItems(List<HarvestRecord> harvestRecords) {
        List<StatisticItem> statisticItems = new ArrayList<>();

        for (HarvestRecord record : harvestRecords) {
            StatisticItem statisticItem = new StatisticItem();
            statisticItem.setEmployee(record.getEmployee());
            statisticItem.setProduct(record.getProduct());
            statisticItem.setQuantity(record.getQuantity());

            statisticItems.add(statisticItem);
        }

        return statisticItems;
    }
}
