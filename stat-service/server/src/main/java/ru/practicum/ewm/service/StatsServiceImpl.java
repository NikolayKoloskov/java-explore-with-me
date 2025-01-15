package ru.practicum.ewm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.Endpoint;
import ru.practicum.ewm.ViewStats;
import ru.practicum.ewm.ViewsStatsRequest;
import ru.practicum.ewm.exceptions.BadRequestException;
import ru.practicum.ewm.repository.StatsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {
    private final StatsRepository statRepository;

    @Override
    public void saveHit(Endpoint hit) {
        statRepository.saveHit(hit);
    }

    @Override
    public List<ViewStats> getViewStatsList(ViewsStatsRequest request) {
        if (request.getStart().isAfter(request.getEnd()) || request.getStart().isEqual(request.getEnd())) {
            throw new BadRequestException("Дата старта поиска не может быть больше даты окончания");
        }
        if (request.isUnique()) {
            return statRepository.getUniqueStats(request);
        }

        return statRepository.getStats(request);
    }
}
