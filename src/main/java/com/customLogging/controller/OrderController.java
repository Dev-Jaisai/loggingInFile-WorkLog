package com.customLogging.controller;

import com.customLogging.entity.Worklog;
import com.customLogging.repo.WorklogRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    private static final Logger worklogger = LoggerFactory.getLogger("worklog");

    @PostMapping("/update-order")
    public String updateOrder(@RequestParam String orderId, @RequestParam String user, @RequestParam String summary, @RequestParam(required = false) String details) {
        // Log the event using the custom appender
        String logMessage = orderId + "," + user + "," + summary + "," + details;
        worklogger.info(logMessage); // Logs to custom worklog appender
        return "Order updated and logged!";
    }

    @PostMapping("/logsFile")
    public String demoForStoringLogsInFile() {
        // Log an info message
        log.info("This is an info log for demonstration purposes.");

        // Log an error message
        log.error("This is an error log for demonstration purposes.");

        return "Info and error logs stored in separate files!";
    }
}
