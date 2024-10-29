package com.customLogging.logger;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.customLogging.config.SpringContext;
import com.customLogging.entity.Worklog;
import com.customLogging.repo.WorklogRepository;

public class WorklogAppender extends AppenderBase<ILoggingEvent> {
    @Override
    protected void append(ILoggingEvent eventObject) {
        System.out.println("WorklogAppender invoked!");  // Debugging to check if appender is called

        String message = eventObject.getFormattedMessage();
        String[] logData = message.split("<ngsdwlsep>");

        if (logData.length >= 3) {
            Worklog worklog = new Worklog();
            worklog.setOrderId(logData[0]);
            worklog.setCreatedBy(logData[1]);
            worklog.setSummary(logData[2]);
            worklog.setDetails(logData.length > 3 ? logData[3] : "");

            System.out.println("Saving worklog to the database...");

            // Retrieve the WorklogRepository bean from the Spring context
            WorklogRepository worklogRepository = SpringContext.getBean(WorklogRepository.class);

            if (worklogRepository != null) {
                System.out.println("WorklogRepository bean found!");  // Debugging to check if repository is retrieved
                worklogRepository.save(worklog);
            } else {
                System.out.println("WorklogRepository bean not found!");  // Error handling
            }
        } else {
            System.out.println("Log data not formatted correctly!");  // Debugging to check log format
        }

    }
}
