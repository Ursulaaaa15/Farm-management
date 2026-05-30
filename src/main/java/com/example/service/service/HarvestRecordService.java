package com.example.service.service;

import com.example.service.model.HarvestRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.service.repository.HarvestRecordRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class HarvestRecordService {
    @Autowired
    private HarvestRecordRepository harvestRecordRepository;

    public void addHarvestRecord(HarvestRecord record) {
        harvestRecordRepository.save(record);
    }

    public List<HarvestRecord> getHarvestRecordsByDate(LocalDate date) {
        return harvestRecordRepository.findByDate(date);
    }
}
