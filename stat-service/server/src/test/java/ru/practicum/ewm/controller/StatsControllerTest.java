package ru.practicum.ewm.controller;


import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import ru.practicum.ewm.ViewStats;
import ru.practicum.ewm.ViewsStatsRequest;
import ru.practicum.ewm.mapper.ViewStatsMapper;
import ru.practicum.ewm.service.StatsServiceImpl;

@WebMvcTest(StatsController.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = {"db.name=test"})
public class StatsControllerTest {

    @Autowired
    private ViewStatsMapper mapper;

    @MockBean
    private StatsServiceImpl statsService;

    @Autowired
    private MockMvc mockMvc;

    private ViewsStatsRequest request;
    private ViewStats stats;

    @BeforeEach
    public void setup() {
//        request = new ViewsStatsRequest.
//        stats = new ViewStats().builder()
//                .app("ewm-main-service")
//                .uri("/events/1")
//        .hits(1).build();
    }


}