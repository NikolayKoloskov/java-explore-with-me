package ru.practicum.ewm;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ViewsStatsRequest {
    private List<String> uris;
    @Builder.Default
    private LocalDateTime start = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
    @Builder.Default
    private LocalDateTime end = LocalDateTime.now();
    private boolean unique;
    private String application;
}