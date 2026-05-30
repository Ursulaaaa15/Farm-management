package com.example.service.controller;

import com.example.service.model.HarvestRecord;
import com.example.service.service.HarvestRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/harvest-records")
public class HarvestRecordController {
    private final HarvestRecordService harvestRecordService;

    public HarvestRecordController(HarvestRecordService harvestRecordService) {
        this.harvestRecordService = harvestRecordService;
    }

    @PostMapping("/add")
    public void addHarvestRecord(@RequestBody HarvestRecord record) {
        harvestRecordService.addHarvestRecord(record);
    }
}
