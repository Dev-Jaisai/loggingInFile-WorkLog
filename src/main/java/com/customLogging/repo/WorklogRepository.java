package com.customLogging.repo;

import com.customLogging.entity.Worklog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorklogRepository extends JpaRepository<Worklog, Long> {
}