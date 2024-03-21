package com.example.StudentManagement.service.impl;

import com.example.StudentManagement.dto.StudentDTO;
import com.example.StudentManagement.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationServices implements NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServices.class);
    @Override
    public void sendNotification(StudentDTO studentDto)
    {
        logger.info("Received "+studentDto.toString());
    }
}
