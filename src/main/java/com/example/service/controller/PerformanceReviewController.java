package com.example.service.controller;

import com.example.service.model.PerformanceReview;
import com.example.service.service.PerformanceReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/performance-reviews")
public class PerformanceReviewController {
    private final PerformanceReviewService performanceReviewService;

    public PerformanceReviewController(PerformanceReviewService performanceReviewService) {
        this.performanceReviewService = performanceReviewService;
    }

    @PostMapping("/add")
    public void addPerformanceReview(@RequestBody PerformanceReview review) {
        performanceReviewService.addPerformanceReview(review);
    }
}