package com.matchforecast.contrader.web.rest;

import com.matchforecast.contrader.Micro2App;

import com.matchforecast.contrader.domain.Squadra;
import com.matchforecast.contrader.repository.SquadraRepository;
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
 * Test class for the SquadraResource REST controller.
 *
 * @see SquadraResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro2App.class)
public class SquadraResourceIntTest {

    private static final String DEFAULT_NAME_TEAM = "AAAAAAAAAA";
    private static final String UPDATED_NAME_TEAM = "BBBBBBBBBB";

    private static final Integer DEFAULT_NUM_PLAYERS = 1;
    private static final Integer UPDATED_NUM_PLAYERS = 2;

    private static final Integer DEFAULT_RATING = 1;
    private static final Integer UPDATED_RATING = 2;

    private static final Integer DEFAULT_WINS = 1;
    private static final Integer UPDATED_WINS = 2;

    private static final Integer DEFAULT_DEFEATS = 1;
    private static final Integer UPDATED_DEFEATS = 2;

    private static final Integer DEFAULT_DRAWS = 1;
    private static final Integer UPDATED_DRAWS = 2;

    private static final Integer DEFAULT_TOTALGOAL = 1;
    private static final Integer UPDATED_TOTALGOAL = 2;

    @Autowired
    private SquadraRepository squadraRepository;


    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restSquadraMockMvc;

    private Squadra squadra;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SquadraResource squadraResource = new SquadraResource(squadraRepository);
        this.restSquadraMockMvc = MockMvcBuilders.standaloneSetup(squadraResource)
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
    public static Squadra createEntity(EntityManager em) {
        Squadra squadra = new Squadra()
            .nameTeam(DEFAULT_NAME_TEAM)
            .numPlayers(DEFAULT_NUM_PLAYERS)
            .rating(DEFAULT_RATING)
            .wins(DEFAULT_WINS)
            .defeats(DEFAULT_DEFEATS)
            .draws(DEFAULT_DRAWS)
            .totalgoal(DEFAULT_TOTALGOAL);
        return squadra;
    }

    @Before
    public void initTest() {
        squadra = createEntity(em);
    }

    @Test
    @Transactional
    public void createSquadra() throws Exception {
        int databaseSizeBeforeCreate = squadraRepository.findAll().size();

        // Create the Squadra
        restSquadraMockMvc.perform(post("/api/squadras")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(squadra)))
            .andExpect(status().isCreated());

        // Validate the Squadra in the database
        List<Squadra> squadraList = squadraRepository.findAll();
        assertThat(squadraList).hasSize(databaseSizeBeforeCreate + 1);
        Squadra testSquadra = squadraList.get(squadraList.size() - 1);
        assertThat(testSquadra.getNameTeam()).isEqualTo(DEFAULT_NAME_TEAM);
        assertThat(testSquadra.getNumPlayers()).isEqualTo(DEFAULT_NUM_PLAYERS);
        assertThat(testSquadra.getRating()).isEqualTo(DEFAULT_RATING);
        assertThat(testSquadra.getWins()).isEqualTo(DEFAULT_WINS);
        assertThat(testSquadra.getDefeats()).isEqualTo(DEFAULT_DEFEATS);
        assertThat(testSquadra.getDraws()).isEqualTo(DEFAULT_DRAWS);
        assertThat(testSquadra.getTotalgoal()).isEqualTo(DEFAULT_TOTALGOAL);
    }

    @Test
    @Transactional
    public void createSquadraWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = squadraRepository.findAll().size();

        // Create the Squadra with an existing ID
        squadra.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSquadraMockMvc.perform(post("/api/squadras")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(squadra)))
            .andExpect(status().isBadRequest());

        // Validate the Squadra in the database
        List<Squadra> squadraList = squadraRepository.findAll();
        assertThat(squadraList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkNameTeamIsRequired() throws Exception {
        int databaseSizeBeforeTest = squadraRepository.findAll().size();
        // set the field null
        squadra.setNameTeam(null);

        // Create the Squadra, which fails.

        restSquadraMockMvc.perform(post("/api/squadras")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(squadra)))
            .andExpect(status().isBadRequest());

        List<Squadra> squadraList = squadraRepository.findAll();
        assertThat(squadraList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNumPlayersIsRequired() throws Exception {
        int databaseSizeBeforeTest = squadraRepository.findAll().size();
        // set the field null
        squadra.setNumPlayers(null);

        // Create the Squadra, which fails.

        restSquadraMockMvc.perform(post("/api/squadras")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(squadra)))
            .andExpect(status().isBadRequest());

        List<Squadra> squadraList = squadraRepository.findAll();
        assertThat(squadraList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkRatingIsRequired() throws Exception {
        int databaseSizeBeforeTest = squadraRepository.findAll().size();
        // set the field null
        squadra.setRating(null);

        // Create the Squadra, which fails.

        restSquadraMockMvc.perform(post("/api/squadras")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(squadra)))
            .andExpect(status().isBadRequest());

        List<Squadra> squadraList = squadraRepository.findAll();
        assertThat(squadraList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkWinsIsRequired() throws Exception {
        int databaseSizeBeforeTest = squadraRepository.findAll().size();
        // set the field null
        squadra.setWins(null);

        // Create the Squadra, which fails.

        restSquadraMockMvc.perform(post("/api/squadras")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(squadra)))
            .andExpect(status().isBadRequest());

        List<Squadra> squadraList = squadraRepository.findAll();
        assertThat(squadraList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDefeatsIsRequired() throws Exception {
        int databaseSizeBeforeTest = squadraRepository.findAll().size();
        // set the field null
        squadra.setDefeats(null);

        // Create the Squadra, which fails.

        restSquadraMockMvc.perform(post("/api/squadras")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(squadra)))
            .andExpect(status().isBadRequest());

        List<Squadra> squadraList = squadraRepository.findAll();
        assertThat(squadraList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDrawsIsRequired() throws Exception {
        int databaseSizeBeforeTest = squadraRepository.findAll().size();
        // set the field null
        squadra.setDraws(null);

        // Create the Squadra, which fails.

        restSquadraMockMvc.perform(post("/api/squadras")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(squadra)))
            .andExpect(status().isBadRequest());

        List<Squadra> squadraList = squadraRepository.findAll();
        assertThat(squadraList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTotalgoalIsRequired() throws Exception {
        int databaseSizeBeforeTest = squadraRepository.findAll().size();
        // set the field null
        squadra.setTotalgoal(null);

        // Create the Squadra, which fails.

        restSquadraMockMvc.perform(post("/api/squadras")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(squadra)))
            .andExpect(status().isBadRequest());

        List<Squadra> squadraList = squadraRepository.findAll();
        assertThat(squadraList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSquadras() throws Exception {
        // Initialize the database
        squadraRepository.saveAndFlush(squadra);

        // Get all the squadraList
        restSquadraMockMvc.perform(get("/api/squadras?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(squadra.getId().intValue())))
            .andExpect(jsonPath("$.[*].nameTeam").value(hasItem(DEFAULT_NAME_TEAM.toString())))
            .andExpect(jsonPath("$.[*].numPlayers").value(hasItem(DEFAULT_NUM_PLAYERS)))
            .andExpect(jsonPath("$.[*].rating").value(hasItem(DEFAULT_RATING)))
            .andExpect(jsonPath("$.[*].wins").value(hasItem(DEFAULT_WINS)))
            .andExpect(jsonPath("$.[*].defeats").value(hasItem(DEFAULT_DEFEATS)))
            .andExpect(jsonPath("$.[*].draws").value(hasItem(DEFAULT_DRAWS)))
            .andExpect(jsonPath("$.[*].totalgoal").value(hasItem(DEFAULT_TOTALGOAL)));
    }
    

    @Test
    @Transactional
    public void getSquadra() throws Exception {
        // Initialize the database
        squadraRepository.saveAndFlush(squadra);

        // Get the squadra
        restSquadraMockMvc.perform(get("/api/squadras/{id}", squadra.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(squadra.getId().intValue()))
            .andExpect(jsonPath("$.nameTeam").value(DEFAULT_NAME_TEAM.toString()))
            .andExpect(jsonPath("$.numPlayers").value(DEFAULT_NUM_PLAYERS))
            .andExpect(jsonPath("$.rating").value(DEFAULT_RATING))
            .andExpect(jsonPath("$.wins").value(DEFAULT_WINS))
            .andExpect(jsonPath("$.defeats").value(DEFAULT_DEFEATS))
            .andExpect(jsonPath("$.draws").value(DEFAULT_DRAWS))
            .andExpect(jsonPath("$.totalgoal").value(DEFAULT_TOTALGOAL));
    }
    @Test
    @Transactional
    public void getNonExistingSquadra() throws Exception {
        // Get the squadra
        restSquadraMockMvc.perform(get("/api/squadras/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSquadra() throws Exception {
        // Initialize the database
        squadraRepository.saveAndFlush(squadra);

        int databaseSizeBeforeUpdate = squadraRepository.findAll().size();

        // Update the squadra
        Squadra updatedSquadra = squadraRepository.findById(squadra.getId()).get();
        // Disconnect from session so that the updates on updatedSquadra are not directly saved in db
        em.detach(updatedSquadra);
        updatedSquadra
            .nameTeam(UPDATED_NAME_TEAM)
            .numPlayers(UPDATED_NUM_PLAYERS)
            .rating(UPDATED_RATING)
            .wins(UPDATED_WINS)
            .defeats(UPDATED_DEFEATS)
            .draws(UPDATED_DRAWS)
            .totalgoal(UPDATED_TOTALGOAL);

        restSquadraMockMvc.perform(put("/api/squadras")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedSquadra)))
            .andExpect(status().isOk());

        // Validate the Squadra in the database
        List<Squadra> squadraList = squadraRepository.findAll();
        assertThat(squadraList).hasSize(databaseSizeBeforeUpdate);
        Squadra testSquadra = squadraList.get(squadraList.size() - 1);
        assertThat(testSquadra.getNameTeam()).isEqualTo(UPDATED_NAME_TEAM);
        assertThat(testSquadra.getNumPlayers()).isEqualTo(UPDATED_NUM_PLAYERS);
        assertThat(testSquadra.getRating()).isEqualTo(UPDATED_RATING);
        assertThat(testSquadra.getWins()).isEqualTo(UPDATED_WINS);
        assertThat(testSquadra.getDefeats()).isEqualTo(UPDATED_DEFEATS);
        assertThat(testSquadra.getDraws()).isEqualTo(UPDATED_DRAWS);
        assertThat(testSquadra.getTotalgoal()).isEqualTo(UPDATED_TOTALGOAL);
    }

    @Test
    @Transactional
    public void updateNonExistingSquadra() throws Exception {
        int databaseSizeBeforeUpdate = squadraRepository.findAll().size();

        // Create the Squadra

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restSquadraMockMvc.perform(put("/api/squadras")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(squadra)))
            .andExpect(status().isBadRequest());

        // Validate the Squadra in the database
        List<Squadra> squadraList = squadraRepository.findAll();
        assertThat(squadraList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSquadra() throws Exception {
        // Initialize the database
        squadraRepository.saveAndFlush(squadra);

        int databaseSizeBeforeDelete = squadraRepository.findAll().size();

        // Get the squadra
        restSquadraMockMvc.perform(delete("/api/squadras/{id}", squadra.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Squadra> squadraList = squadraRepository.findAll();
        assertThat(squadraList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Squadra.class);
        Squadra squadra1 = new Squadra();
        squadra1.setId(1L);
        Squadra squadra2 = new Squadra();
        squadra2.setId(squadra1.getId());
        assertThat(squadra1).isEqualTo(squadra2);
        squadra2.setId(2L);
        assertThat(squadra1).isNotEqualTo(squadra2);
        squadra1.setId(null);
        assertThat(squadra1).isNotEqualTo(squadra2);
    }
}
