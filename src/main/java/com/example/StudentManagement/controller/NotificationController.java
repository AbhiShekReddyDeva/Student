package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.StudentDTO;
import com.example.StudentManagement.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationServices;

    @PostMapping("/send")
    public void sendNotification(@RequestBody StudentDTO studentDto)
    {
        notificationServices.sendNotification(studentDto);
    }
}
