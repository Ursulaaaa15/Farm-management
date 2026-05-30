package com.example.service.tasks;

import com.example.service.model.HarvestRecord;
import com.example.service.service.EmailService;
import com.example.service.service.HarvestRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.List;

@Configuration
@EnableScheduling
public class ScheduledTasks {

    @Autowired
    private HarvestRecordService harvestRecordService;

    @Autowired
    private EmailService emailService;

    // Отправка отчета на почту каждый день в 18:00
    @Scheduled(cron = "0 0 18 * * *")
    public void sendDailyReport() {
        LocalDate currentDate = LocalDate.now();
        List<HarvestRecord> todayHarvestRecords = harvestRecordService.getHarvestRecordsByDate(currentDate);

        String report = "Отчет по собранным товарам за " + currentDate + ":\n";
        for (HarvestRecord record : todayHarvestRecords) {
            report += "Сотрудник: " + record.getEmployee().getFullName() +
                    ", Товар: " + record.getProduct().getName() +
                    ", Количество: " + record.getQuantity() + " " + record.getProduct().getUnitOfMeasurement() + "\n";
        }

        // Отправьте отчет на почту
        String subject = "Отчет по собранным товарам за " + currentDate;
        String recipient = "la17wd@gmail.com";
        emailService.sendEmail(recipient, subject, report);
    }
}