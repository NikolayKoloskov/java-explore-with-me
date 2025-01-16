package ru.practicum;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ViewsStatsRequest {
    private String uris;
    @Builder.Default
    private LocalDateTime start = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
    @Builder.Default
    private LocalDateTime end = LocalDateTime.now();
    private boolean unique;
    private String application;
}