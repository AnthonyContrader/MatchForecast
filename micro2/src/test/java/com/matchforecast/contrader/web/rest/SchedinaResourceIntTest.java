package com.matchforecast.contrader.web.rest;

import com.matchforecast.contrader.Micro2App;

import com.matchforecast.contrader.domain.Schedina;
import com.matchforecast.contrader.domain.Partita;
import com.matchforecast.contrader.repository.SchedinaRepository;
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
 * Test class for the SchedinaResource REST controller.
 *
 * @see SchedinaResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro2App.class)
public class SchedinaResourceIntTest {

    private static final Double DEFAULT_QUOTA_1 = 1D;
    private static final Double UPDATED_QUOTA_1 = 2D;

    private static final Double DEFAULT_QUOTA_X = 1D;
    private static final Double UPDATED_QUOTA_X = 2D;

    private static final Double DEFAULT_QUOTA_2 = 1D;
    private static final Double UPDATED_QUOTA_2 = 2D;

    @Autowired
    private SchedinaRepository schedinaRepository;


    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restSchedinaMockMvc;

    private Schedina schedina;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SchedinaResource schedinaResource = new SchedinaResource(schedinaRepository);
        this.restSchedinaMockMvc = MockMvcBuilders.standaloneSetup(schedinaResource)
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
    public static Schedina createEntity(EntityManager em) {
        Schedina schedina = new Schedina()
            .quota1(DEFAULT_QUOTA_1)
            .quotaX(DEFAULT_QUOTA_X)
            .quota2(DEFAULT_QUOTA_2);
        // Add required entity
        Partita partita = PartitaResourceIntTest.createEntity(em);
        em.persist(partita);
        em.flush();
        schedina.setPartita(partita);
        return schedina;
    }

    @Before
    public void initTest() {
        schedina = createEntity(em);
    }

    @Test
    @Transactional
    public void createSchedina() throws Exception {
        int databaseSizeBeforeCreate = schedinaRepository.findAll().size();

        // Create the Schedina
        restSchedinaMockMvc.perform(post("/api/schedinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(schedina)))
            .andExpect(status().isCreated());

        // Validate the Schedina in the database
        List<Schedina> schedinaList = schedinaRepository.findAll();
        assertThat(schedinaList).hasSize(databaseSizeBeforeCreate + 1);
        Schedina testSchedina = schedinaList.get(schedinaList.size() - 1);
        assertThat(testSchedina.getQuota1()).isEqualTo(DEFAULT_QUOTA_1);
        assertThat(testSchedina.getQuotaX()).isEqualTo(DEFAULT_QUOTA_X);
        assertThat(testSchedina.getQuota2()).isEqualTo(DEFAULT_QUOTA_2);
    }

    @Test
    @Transactional
    public void createSchedinaWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = schedinaRepository.findAll().size();

        // Create the Schedina with an existing ID
        schedina.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSchedinaMockMvc.perform(post("/api/schedinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(schedina)))
            .andExpect(status().isBadRequest());

        // Validate the Schedina in the database
        List<Schedina> schedinaList = schedinaRepository.findAll();
        assertThat(schedinaList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkQuota1IsRequired() throws Exception {
        int databaseSizeBeforeTest = schedinaRepository.findAll().size();
        // set the field null
        schedina.setQuota1(null);

        // Create the Schedina, which fails.

        restSchedinaMockMvc.perform(post("/api/schedinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(schedina)))
            .andExpect(status().isBadRequest());

        List<Schedina> schedinaList = schedinaRepository.findAll();
        assertThat(schedinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkQuotaXIsRequired() throws Exception {
        int databaseSizeBeforeTest = schedinaRepository.findAll().size();
        // set the field null
        schedina.setQuotaX(null);

        // Create the Schedina, which fails.

        restSchedinaMockMvc.perform(post("/api/schedinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(schedina)))
            .andExpect(status().isBadRequest());

        List<Schedina> schedinaList = schedinaRepository.findAll();
        assertThat(schedinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkQuota2IsRequired() throws Exception {
        int databaseSizeBeforeTest = schedinaRepository.findAll().size();
        // set the field null
        schedina.setQuota2(null);

        // Create the Schedina, which fails.

        restSchedinaMockMvc.perform(post("/api/schedinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(schedina)))
            .andExpect(status().isBadRequest());

        List<Schedina> schedinaList = schedinaRepository.findAll();
        assertThat(schedinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSchedinas() throws Exception {
        // Initialize the database
        schedinaRepository.saveAndFlush(schedina);

        // Get all the schedinaList
        restSchedinaMockMvc.perform(get("/api/schedinas?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(schedina.getId().intValue())))
            .andExpect(jsonPath("$.[*].quota1").value(hasItem(DEFAULT_QUOTA_1.doubleValue())))
            .andExpect(jsonPath("$.[*].quotaX").value(hasItem(DEFAULT_QUOTA_X.doubleValue())))
            .andExpect(jsonPath("$.[*].quota2").value(hasItem(DEFAULT_QUOTA_2.doubleValue())));
    }
    

    @Test
    @Transactional
    public void getSchedina() throws Exception {
        // Initialize the database
        schedinaRepository.saveAndFlush(schedina);

        // Get the schedina
        restSchedinaMockMvc.perform(get("/api/schedinas/{id}", schedina.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(schedina.getId().intValue()))
            .andExpect(jsonPath("$.quota1").value(DEFAULT_QUOTA_1.doubleValue()))
            .andExpect(jsonPath("$.quotaX").value(DEFAULT_QUOTA_X.doubleValue()))
            .andExpect(jsonPath("$.quota2").value(DEFAULT_QUOTA_2.doubleValue()));
    }
    @Test
    @Transactional
    public void getNonExistingSchedina() throws Exception {
        // Get the schedina
        restSchedinaMockMvc.perform(get("/api/schedinas/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSchedina() throws Exception {
        // Initialize the database
        schedinaRepository.saveAndFlush(schedina);

        int databaseSizeBeforeUpdate = schedinaRepository.findAll().size();

        // Update the schedina
        Schedina updatedSchedina = schedinaRepository.findById(schedina.getId()).get();
        // Disconnect from session so that the updates on updatedSchedina are not directly saved in db
        em.detach(updatedSchedina);
        updatedSchedina
            .quota1(UPDATED_QUOTA_1)
            .quotaX(UPDATED_QUOTA_X)
            .quota2(UPDATED_QUOTA_2);

        restSchedinaMockMvc.perform(put("/api/schedinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedSchedina)))
            .andExpect(status().isOk());

        // Validate the Schedina in the database
        List<Schedina> schedinaList = schedinaRepository.findAll();
        assertThat(schedinaList).hasSize(databaseSizeBeforeUpdate);
        Schedina testSchedina = schedinaList.get(schedinaList.size() - 1);
        assertThat(testSchedina.getQuota1()).isEqualTo(UPDATED_QUOTA_1);
        assertThat(testSchedina.getQuotaX()).isEqualTo(UPDATED_QUOTA_X);
        assertThat(testSchedina.getQuota2()).isEqualTo(UPDATED_QUOTA_2);
    }

    @Test
    @Transactional
    public void updateNonExistingSchedina() throws Exception {
        int databaseSizeBeforeUpdate = schedinaRepository.findAll().size();

        // Create the Schedina

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restSchedinaMockMvc.perform(put("/api/schedinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(schedina)))
            .andExpect(status().isBadRequest());

        // Validate the Schedina in the database
        List<Schedina> schedinaList = schedinaRepository.findAll();
        assertThat(schedinaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSchedina() throws Exception {
        // Initialize the database
        schedinaRepository.saveAndFlush(schedina);

        int databaseSizeBeforeDelete = schedinaRepository.findAll().size();

        // Get the schedina
        restSchedinaMockMvc.perform(delete("/api/schedinas/{id}", schedina.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Schedina> schedinaList = schedinaRepository.findAll();
        assertThat(schedinaList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Schedina.class);
        Schedina schedina1 = new Schedina();
        schedina1.setId(1L);
        Schedina schedina2 = new Schedina();
        schedina2.setId(schedina1.getId());
        assertThat(schedina1).isEqualTo(schedina2);
        schedina2.setId(2L);
        assertThat(schedina1).isNotEqualTo(schedina2);
        schedina1.setId(null);
        assertThat(schedina1).isNotEqualTo(schedina2);
    }
}
