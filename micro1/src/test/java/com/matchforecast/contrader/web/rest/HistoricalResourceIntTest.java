package com.matchforecast.contrader.web.rest;

import com.matchforecast.contrader.Micro1App;

import com.matchforecast.contrader.domain.Historical;
import com.matchforecast.contrader.repository.HistoricalRepository;
import com.matchforecast.contrader.service.HistoricalService;
import com.matchforecast.contrader.service.dto.HistoricalDTO;
import com.matchforecast.contrader.service.mapper.HistoricalMapper;
import com.matchforecast.contrader.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static com.matchforecast.contrader.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the HistoricalResource REST controller.
 *
 * @see HistoricalResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro1App.class)
public class HistoricalResourceIntTest {

    private static final Integer DEFAULT_WINS = 1;
    private static final Integer UPDATED_WINS = 2;

    private static final Integer DEFAULT_LOSE = 1;
    private static final Integer UPDATED_LOSE = 2;

    @Autowired
    private HistoricalRepository historicalRepository;


    @Autowired
    private HistoricalMapper historicalMapper;
    

    @Autowired
    private HistoricalService historicalService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restHistoricalMockMvc;

    private Historical historical;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final HistoricalResource historicalResource = new HistoricalResource(historicalService);
        this.restHistoricalMockMvc = MockMvcBuilders.standaloneSetup(historicalResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Historical createEntity(EntityManager em) {
        Historical historical = new Historical()
            .wins(DEFAULT_WINS)
            .lose(DEFAULT_LOSE);
        return historical;
    }

    @Before
    public void initTest() {
        historical = createEntity(em);
    }

    @Test
    @Transactional
    public void createHistorical() throws Exception {
        int databaseSizeBeforeCreate = historicalRepository.findAll().size();

        // Create the Historical
        HistoricalDTO historicalDTO = historicalMapper.toDto(historical);
        restHistoricalMockMvc.perform(post("/api/historicals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(historicalDTO)))
            .andExpect(status().isCreated());

        // Validate the Historical in the database
        List<Historical> historicalList = historicalRepository.findAll();
        assertThat(historicalList).hasSize(databaseSizeBeforeCreate + 1);
        Historical testHistorical = historicalList.get(historicalList.size() - 1);
        assertThat(testHistorical.getWins()).isEqualTo(DEFAULT_WINS);
        assertThat(testHistorical.getLose()).isEqualTo(DEFAULT_LOSE);
    }

    @Test
    @Transactional
    public void createHistoricalWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = historicalRepository.findAll().size();

        // Create the Historical with an existing ID
        historical.setId(1L);
        HistoricalDTO historicalDTO = historicalMapper.toDto(historical);

        // An entity with an existing ID cannot be created, so this API call must fail
        restHistoricalMockMvc.perform(post("/api/historicals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(historicalDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Historical in the database
        List<Historical> historicalList = historicalRepository.findAll();
        assertThat(historicalList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkWinsIsRequired() throws Exception {
        int databaseSizeBeforeTest = historicalRepository.findAll().size();
        // set the field null
        historical.setWins(null);

        // Create the Historical, which fails.
        HistoricalDTO historicalDTO = historicalMapper.toDto(historical);

        restHistoricalMockMvc.perform(post("/api/historicals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(historicalDTO)))
            .andExpect(status().isBadRequest());

        List<Historical> historicalList = historicalRepository.findAll();
        assertThat(historicalList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLoseIsRequired() throws Exception {
        int databaseSizeBeforeTest = historicalRepository.findAll().size();
        // set the field null
        historical.setLose(null);

        // Create the Historical, which fails.
        HistoricalDTO historicalDTO = historicalMapper.toDto(historical);

        restHistoricalMockMvc.perform(post("/api/historicals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(historicalDTO)))
            .andExpect(status().isBadRequest());

        List<Historical> historicalList = historicalRepository.findAll();
        assertThat(historicalList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllHistoricals() throws Exception {
        // Initialize the database
        historicalRepository.saveAndFlush(historical);

        // Get all the historicalList
        restHistoricalMockMvc.perform(get("/api/historicals?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(historical.getId().intValue())))
            .andExpect(jsonPath("$.[*].wins").value(hasItem(DEFAULT_WINS)))
            .andExpect(jsonPath("$.[*].lose").value(hasItem(DEFAULT_LOSE)));
    }
    

    @Test
    @Transactional
    public void getHistorical() throws Exception {
        // Initialize the database
        historicalRepository.saveAndFlush(historical);

        // Get the historical
        restHistoricalMockMvc.perform(get("/api/historicals/{id}", historical.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(historical.getId().intValue()))
            .andExpect(jsonPath("$.wins").value(DEFAULT_WINS))
            .andExpect(jsonPath("$.lose").value(DEFAULT_LOSE));
    }
    @Test
    @Transactional
    public void getNonExistingHistorical() throws Exception {
        // Get the historical
        restHistoricalMockMvc.perform(get("/api/historicals/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateHistorical() throws Exception {
        // Initialize the database
        historicalRepository.saveAndFlush(historical);

        int databaseSizeBeforeUpdate = historicalRepository.findAll().size();

        // Update the historical
        Historical updatedHistorical = historicalRepository.findById(historical.getId()).get();
        // Disconnect from session so that the updates on updatedHistorical are not directly saved in db
        em.detach(updatedHistorical);
        updatedHistorical
            .wins(UPDATED_WINS)
            .lose(UPDATED_LOSE);
        HistoricalDTO historicalDTO = historicalMapper.toDto(updatedHistorical);

        restHistoricalMockMvc.perform(put("/api/historicals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(historicalDTO)))
            .andExpect(status().isOk());

        // Validate the Historical in the database
        List<Historical> historicalList = historicalRepository.findAll();
        assertThat(historicalList).hasSize(databaseSizeBeforeUpdate);
        Historical testHistorical = historicalList.get(historicalList.size() - 1);
        assertThat(testHistorical.getWins()).isEqualTo(UPDATED_WINS);
        assertThat(testHistorical.getLose()).isEqualTo(UPDATED_LOSE);
    }

    @Test
    @Transactional
    public void updateNonExistingHistorical() throws Exception {
        int databaseSizeBeforeUpdate = historicalRepository.findAll().size();

        // Create the Historical
        HistoricalDTO historicalDTO = historicalMapper.toDto(historical);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restHistoricalMockMvc.perform(put("/api/historicals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(historicalDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Historical in the database
        List<Historical> historicalList = historicalRepository.findAll();
        assertThat(historicalList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteHistorical() throws Exception {
        // Initialize the database
        historicalRepository.saveAndFlush(historical);

        int databaseSizeBeforeDelete = historicalRepository.findAll().size();

        // Get the historical
        restHistoricalMockMvc.perform(delete("/api/historicals/{id}", historical.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Historical> historicalList = historicalRepository.findAll();
        assertThat(historicalList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Historical.class);
        Historical historical1 = new Historical();
        historical1.setId(1L);
        Historical historical2 = new Historical();
        historical2.setId(historical1.getId());
        assertThat(historical1).isEqualTo(historical2);
        historical2.setId(2L);
        assertThat(historical1).isNotEqualTo(historical2);
        historical1.setId(null);
        assertThat(historical1).isNotEqualTo(historical2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(HistoricalDTO.class);
        HistoricalDTO historicalDTO1 = new HistoricalDTO();
        historicalDTO1.setId(1L);
        HistoricalDTO historicalDTO2 = new HistoricalDTO();
        assertThat(historicalDTO1).isNotEqualTo(historicalDTO2);
        historicalDTO2.setId(historicalDTO1.getId());
        assertThat(historicalDTO1).isEqualTo(historicalDTO2);
        historicalDTO2.setId(2L);
        assertThat(historicalDTO1).isNotEqualTo(historicalDTO2);
        historicalDTO1.setId(null);
        assertThat(historicalDTO1).isNotEqualTo(historicalDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(historicalMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(historicalMapper.fromId(null)).isNull();
    }
}
