package ru.practicum.ewm.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.practicum.ewm.EndpointHit;
import ru.practicum.ewm.ViewStats;
import ru.practicum.ewm.ViewsStatsRequest;
import ru.practicum.ewm.service.StatsService;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StatsController.class)
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class StatsControllerTest {
    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockBean
    private final StatsService statsService;


    @Test
    public void testHit() throws Exception {
        ViewsStatsRequest viewsStatsRequest = ViewsStatsRequest.builder()
                .start(LocalDateTime.now())
                .end(LocalDateTime.now().plusHours(10))
                .uris(List.of("/uri1", "/uri2"))
                .application("test-app")
                .build();
        EndpointHit endpointHit = EndpointHit.builder()
                .app("test-app")
                .ip("127.0.0.1")
                .uri("/uri1")
                .build();
        mockMvc.perform(post("/hit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(viewsStatsRequest)))
                .andExpect(status().isCreated());

        verify(statsService, times(1)).saveHit(any(EndpointHit.class));
    }

    @Test
    public void testGetStats() throws Exception {
        ViewsStatsRequest viewsStatsRequest = ViewsStatsRequest.builder()
                .start(LocalDateTime.now())
                .end(LocalDateTime.now().plusHours(10))
                .uris(List.of("/uri1"))
                .application("test-app")
                .unique(false)
                .build();
        List<ViewStats> viewStatsList = List.of((ViewStats.builder().app("test-app").uri("/uri1").hits(1).build()));
        when(statsService.getViewStatsList(any(ViewsStatsRequest.class))).thenReturn(viewStatsList);

        mockMvc.perform(get("/stats")
                        .param("start", viewsStatsRequest.getStart().toString())
                        .param("end", viewsStatsRequest.getEnd().toString())
                        .param("uris", viewsStatsRequest.getUris().get(0))
                        .param("unique", String.valueOf(viewsStatsRequest.isUnique()))
                        .param("application", viewsStatsRequest.getApplication()))
                .andExpect(status().isOk());

        verify(statsService, times(1)).getViewStatsList(any(ViewsStatsRequest.class));
    }
}