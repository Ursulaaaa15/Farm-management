package com.example.service.service;

import com.example.service.model.PerformanceReview;
import com.example.service.repository.PerformanceReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceReviewService {
    @Autowired
    private PerformanceReviewRepository performanceReviewRepository;

    public void addPerformanceReview(PerformanceReview review) {
        performanceReviewRepository.save(review);
    }
}