package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.StudentDTO;

public interface NotificationService {
    void sendNotification(StudentDTO studentDto);
}
