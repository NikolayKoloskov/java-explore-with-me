package ru.practicum;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ViewsStatsRequest {
    private String uri;
    private LocalDateTime start;
    private LocalDateTime end;
    private boolean unique;
    private String application;
}