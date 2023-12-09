package com.innowise.notificationmicroservice.controller;

import avro.NotificationRequest;
import com.innowise.notificationmicroservice.service.impl.NotificationServiceImpl;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
@Validated
public class NotificationController {

    private final NotificationServiceImpl notificationService;

    @GetMapping("/")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<NotificationRequest>> getNotifications(
            @RequestParam(required = false, defaultValue = "0") @Size(min = 0) Integer offset,
            @RequestParam(required = false, defaultValue = "20") @Size(min = 1, max = 100) Integer limit) {
        return ResponseEntity.ok().body(notificationService.getNotifications(offset, limit));
    }

    @GetMapping("/{notificationId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<NotificationRequest> getNotificationById(@PathVariable Long notificationId) throws Exception {
        return ResponseEntity.ok().body(notificationService.getNotificationById(notificationId));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
