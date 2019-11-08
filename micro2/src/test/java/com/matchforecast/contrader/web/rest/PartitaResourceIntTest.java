package com.matchforecast.contrader.web.rest;

import com.matchforecast.contrader.Micro2App;

import com.matchforecast.contrader.domain.Partita;
import com.matchforecast.contrader.domain.Squadra;
import com.matchforecast.contrader.domain.Squadra;
import com.matchforecast.contrader.repository.PartitaRepository;
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
 * Test class for the PartitaResource REST controller.
 *
 * @see PartitaResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro2App.class)
public class PartitaResourceIntTest {

    private static final String DEFAULT_DATE = "AAAAAAAAAA";
    private static final String UPDATED_DATE = "BBBBBBBBBB";

    private static final Integer DEFAULT_WIN = 1;
    private static final Integer UPDATED_WIN = 2;

    private static final Integer DEFAULT_DRAW = 1;
    private static final Integer UPDATED_DRAW = 2;

    private static final Integer DEFAULT_LOSE = 1;
    private static final Integer UPDATED_LOSE = 2;

    @Autowired
    private PartitaRepository partitaRepository;


    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restPartitaMockMvc;

    private Partita partita;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final PartitaResource partitaResource = new PartitaResource(partitaRepository);
        this.restPartitaMockMvc = MockMvcBuilders.standaloneSetup(partitaResource)
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
    public static Partita createEntity(EntityManager em) {
        Partita partita = new Partita()
            .date(DEFAULT_DATE)
            .win(DEFAULT_WIN)
            .draw(DEFAULT_DRAW)
            .lose(DEFAULT_LOSE);
        // Add required entity
        Squadra squadra = SquadraResourceIntTest.createEntity(em);
        em.persist(squadra);
        em.flush();
        partita.setTeam1(squadra);
        // Add required entity
        partita.setSquadra(squadra);
        return partita;
    }

    @Before
    public void initTest() {
        partita = createEntity(em);
    }

    @Test
    @Transactional
    public void createPartita() throws Exception {
        int databaseSizeBeforeCreate = partitaRepository.findAll().size();

        // Create the Partita
        restPartitaMockMvc.perform(post("/api/partitas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(partita)))
            .andExpect(status().isCreated());

        // Validate the Partita in the database
        List<Partita> partitaList = partitaRepository.findAll();
        assertThat(partitaList).hasSize(databaseSizeBeforeCreate + 1);
        Partita testPartita = partitaList.get(partitaList.size() - 1);
        assertThat(testPartita.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testPartita.getWin()).isEqualTo(DEFAULT_WIN);
        assertThat(testPartita.getDraw()).isEqualTo(DEFAULT_DRAW);
        assertThat(testPartita.getLose()).isEqualTo(DEFAULT_LOSE);
    }

    @Test
    @Transactional
    public void createPartitaWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = partitaRepository.findAll().size();

        // Create the Partita with an existing ID
        partita.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPartitaMockMvc.perform(post("/api/partitas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(partita)))
            .andExpect(status().isBadRequest());

        // Validate the Partita in the database
        List<Partita> partitaList = partitaRepository.findAll();
        assertThat(partitaList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = partitaRepository.findAll().size();
        // set the field null
        partita.setDate(null);

        // Create the Partita, which fails.

        restPartitaMockMvc.perform(post("/api/partitas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(partita)))
            .andExpect(status().isBadRequest());

        List<Partita> partitaList = partitaRepository.findAll();
        assertThat(partitaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkWinIsRequired() throws Exception {
        int databaseSizeBeforeTest = partitaRepository.findAll().size();
        // set the field null
        partita.setWin(null);

        // Create the Partita, which fails.

        restPartitaMockMvc.perform(post("/api/partitas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(partita)))
            .andExpect(status().isBadRequest());

        List<Partita> partitaList = partitaRepository.findAll();
        assertThat(partitaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDrawIsRequired() throws Exception {
        int databaseSizeBeforeTest = partitaRepository.findAll().size();
        // set the field null
        partita.setDraw(null);

        // Create the Partita, which fails.

        restPartitaMockMvc.perform(post("/api/partitas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(partita)))
            .andExpect(status().isBadRequest());

        List<Partita> partitaList = partitaRepository.findAll();
        assertThat(partitaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLoseIsRequired() throws Exception {
        int databaseSizeBeforeTest = partitaRepository.findAll().size();
        // set the field null
        partita.setLose(null);

        // Create the Partita, which fails.

        restPartitaMockMvc.perform(post("/api/partitas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(partita)))
            .andExpect(status().isBadRequest());

        List<Partita> partitaList = partitaRepository.findAll();
        assertThat(partitaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllPartitas() throws Exception {
        // Initialize the database
        partitaRepository.saveAndFlush(partita);

        // Get all the partitaList
        restPartitaMockMvc.perform(get("/api/partitas?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(partita.getId().intValue())))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())))
            .andExpect(jsonPath("$.[*].win").value(hasItem(DEFAULT_WIN)))
            .andExpect(jsonPath("$.[*].draw").value(hasItem(DEFAULT_DRAW)))
            .andExpect(jsonPath("$.[*].lose").value(hasItem(DEFAULT_LOSE)));
    }
    

    @Test
    @Transactional
    public void getPartita() throws Exception {
        // Initialize the database
        partitaRepository.saveAndFlush(partita);

        // Get the partita
        restPartitaMockMvc.perform(get("/api/partitas/{id}", partita.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(partita.getId().intValue()))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()))
            .andExpect(jsonPath("$.win").value(DEFAULT_WIN))
            .andExpect(jsonPath("$.draw").value(DEFAULT_DRAW))
            .andExpect(jsonPath("$.lose").value(DEFAULT_LOSE));
    }
    @Test
    @Transactional
    public void getNonExistingPartita() throws Exception {
        // Get the partita
        restPartitaMockMvc.perform(get("/api/partitas/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePartita() throws Exception {
        // Initialize the database
        partitaRepository.saveAndFlush(partita);

        int databaseSizeBeforeUpdate = partitaRepository.findAll().size();

        // Update the partita
        Partita updatedPartita = partitaRepository.findById(partita.getId()).get();
        // Disconnect from session so that the updates on updatedPartita are not directly saved in db
        em.detach(updatedPartita);
        updatedPartita
            .date(UPDATED_DATE)
            .win(UPDATED_WIN)
            .draw(UPDATED_DRAW)
            .lose(UPDATED_LOSE);

        restPartitaMockMvc.perform(put("/api/partitas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedPartita)))
            .andExpect(status().isOk());

        // Validate the Partita in the database
        List<Partita> partitaList = partitaRepository.findAll();
        assertThat(partitaList).hasSize(databaseSizeBeforeUpdate);
        Partita testPartita = partitaList.get(partitaList.size() - 1);
        assertThat(testPartita.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testPartita.getWin()).isEqualTo(UPDATED_WIN);
        assertThat(testPartita.getDraw()).isEqualTo(UPDATED_DRAW);
        assertThat(testPartita.getLose()).isEqualTo(UPDATED_LOSE);
    }

    @Test
    @Transactional
    public void updateNonExistingPartita() throws Exception {
        int databaseSizeBeforeUpdate = partitaRepository.findAll().size();

        // Create the Partita

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restPartitaMockMvc.perform(put("/api/partitas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(partita)))
            .andExpect(status().isBadRequest());

        // Validate the Partita in the database
        List<Partita> partitaList = partitaRepository.findAll();
        assertThat(partitaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePartita() throws Exception {
        // Initialize the database
        partitaRepository.saveAndFlush(partita);

        int databaseSizeBeforeDelete = partitaRepository.findAll().size();

        // Get the partita
        restPartitaMockMvc.perform(delete("/api/partitas/{id}", partita.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Partita> partitaList = partitaRepository.findAll();
        assertThat(partitaList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Partita.class);
        Partita partita1 = new Partita();
        partita1.setId(1L);
        Partita partita2 = new Partita();
        partita2.setId(partita1.getId());
        assertThat(partita1).isEqualTo(partita2);
        partita2.setId(2L);
        assertThat(partita1).isNotEqualTo(partita2);
        partita1.setId(null);
        assertThat(partita1).isNotEqualTo(partita2);
    }
}
