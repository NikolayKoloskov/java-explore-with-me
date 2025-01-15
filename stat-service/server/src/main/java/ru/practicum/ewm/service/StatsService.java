package ru.practicum.ewm.service;

import ru.practicum.ewm.Endpoint;
import ru.practicum.ewm.ViewStats;
import ru.practicum.ewm.ViewsStatsRequest;

import java.util.List;

public interface StatsService {
    void saveHit(Endpoint hit);

    List<ViewStats> getViewStatsList(ViewsStatsRequest request);
}

