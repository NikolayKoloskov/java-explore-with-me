package ru.practicum.ewm.repository;

import ru.practicum.ewm.Endpoint;
import ru.practicum.ewm.ViewStats;
import ru.practicum.ewm.ViewsStatsRequest;

import java.util.List;

public interface StatsRepository {
    void saveHit(Endpoint hit);

    List<ViewStats> getStats(ViewsStatsRequest request);

    List<ViewStats> getUniqueStats(ViewsStatsRequest request);
}

