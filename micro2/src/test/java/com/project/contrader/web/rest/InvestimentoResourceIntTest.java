package com.project.contrader.web.rest;

import com.project.contrader.Micro2App;

import com.project.contrader.domain.Investimento;
import com.project.contrader.repository.InvestimentoRepository;
import com.project.contrader.service.InvestimentoService;
import com.project.contrader.service.dto.InvestimentoDTO;
import com.project.contrader.service.mapper.InvestimentoMapper;
import com.project.contrader.web.rest.errors.ExceptionTranslator;

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


import static com.project.contrader.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the InvestimentoResource REST controller.
 *
 * @see InvestimentoResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro2App.class)
public class InvestimentoResourceIntTest {

    private static final Integer DEFAULT_BUDGET = 1;
    private static final Integer UPDATED_BUDGET = 2;

    private static final Integer DEFAULT_DURATA = 1;
    private static final Integer UPDATED_DURATA = 2;

    private static final Integer DEFAULT_RISCHIO = 1;
    private static final Integer UPDATED_RISCHIO = 2;

    @Autowired
    private InvestimentoRepository investimentoRepository;


    @Autowired
    private InvestimentoMapper investimentoMapper;
    

    @Autowired
    private InvestimentoService investimentoService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restInvestimentoMockMvc;

    private Investimento investimento;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final InvestimentoResource investimentoResource = new InvestimentoResource(investimentoService);
        this.restInvestimentoMockMvc = MockMvcBuilders.standaloneSetup(investimentoResource)
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
    public static Investimento createEntity(EntityManager em) {
        Investimento investimento = new Investimento()
            .budget(DEFAULT_BUDGET)
            .durata(DEFAULT_DURATA)
            .rischio(DEFAULT_RISCHIO);
        return investimento;
    }

    @Before
    public void initTest() {
        investimento = createEntity(em);
    }

    @Test
    @Transactional
    public void createInvestimento() throws Exception {
        int databaseSizeBeforeCreate = investimentoRepository.findAll().size();

        // Create the Investimento
        InvestimentoDTO investimentoDTO = investimentoMapper.toDto(investimento);
        restInvestimentoMockMvc.perform(post("/api/investimentos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(investimentoDTO)))
            .andExpect(status().isCreated());

        // Validate the Investimento in the database
        List<Investimento> investimentoList = investimentoRepository.findAll();
        assertThat(investimentoList).hasSize(databaseSizeBeforeCreate + 1);
        Investimento testInvestimento = investimentoList.get(investimentoList.size() - 1);
        assertThat(testInvestimento.getBudget()).isEqualTo(DEFAULT_BUDGET);
        assertThat(testInvestimento.getDurata()).isEqualTo(DEFAULT_DURATA);
        assertThat(testInvestimento.getRischio()).isEqualTo(DEFAULT_RISCHIO);
    }

    @Test
    @Transactional
    public void createInvestimentoWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = investimentoRepository.findAll().size();

        // Create the Investimento with an existing ID
        investimento.setId(1L);
        InvestimentoDTO investimentoDTO = investimentoMapper.toDto(investimento);

        // An entity with an existing ID cannot be created, so this API call must fail
        restInvestimentoMockMvc.perform(post("/api/investimentos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(investimentoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Investimento in the database
        List<Investimento> investimentoList = investimentoRepository.findAll();
        assertThat(investimentoList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkBudgetIsRequired() throws Exception {
        int databaseSizeBeforeTest = investimentoRepository.findAll().size();
        // set the field null
        investimento.setBudget(null);

        // Create the Investimento, which fails.
        InvestimentoDTO investimentoDTO = investimentoMapper.toDto(investimento);

        restInvestimentoMockMvc.perform(post("/api/investimentos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(investimentoDTO)))
            .andExpect(status().isBadRequest());

        List<Investimento> investimentoList = investimentoRepository.findAll();
        assertThat(investimentoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDurataIsRequired() throws Exception {
        int databaseSizeBeforeTest = investimentoRepository.findAll().size();
        // set the field null
        investimento.setDurata(null);

        // Create the Investimento, which fails.
        InvestimentoDTO investimentoDTO = investimentoMapper.toDto(investimento);

        restInvestimentoMockMvc.perform(post("/api/investimentos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(investimentoDTO)))
            .andExpect(status().isBadRequest());

        List<Investimento> investimentoList = investimentoRepository.findAll();
        assertThat(investimentoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkRischioIsRequired() throws Exception {
        int databaseSizeBeforeTest = investimentoRepository.findAll().size();
        // set the field null
        investimento.setRischio(null);

        // Create the Investimento, which fails.
        InvestimentoDTO investimentoDTO = investimentoMapper.toDto(investimento);

        restInvestimentoMockMvc.perform(post("/api/investimentos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(investimentoDTO)))
            .andExpect(status().isBadRequest());

        List<Investimento> investimentoList = investimentoRepository.findAll();
        assertThat(investimentoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllInvestimentos() throws Exception {
        // Initialize the database
        investimentoRepository.saveAndFlush(investimento);

        // Get all the investimentoList
        restInvestimentoMockMvc.perform(get("/api/investimentos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(investimento.getId().intValue())))
            .andExpect(jsonPath("$.[*].budget").value(hasItem(DEFAULT_BUDGET)))
            .andExpect(jsonPath("$.[*].durata").value(hasItem(DEFAULT_DURATA)))
            .andExpect(jsonPath("$.[*].rischio").value(hasItem(DEFAULT_RISCHIO)));
    }
    

    @Test
    @Transactional
    public void getInvestimento() throws Exception {
        // Initialize the database
        investimentoRepository.saveAndFlush(investimento);

        // Get the investimento
        restInvestimentoMockMvc.perform(get("/api/investimentos/{id}", investimento.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(investimento.getId().intValue()))
            .andExpect(jsonPath("$.budget").value(DEFAULT_BUDGET))
            .andExpect(jsonPath("$.durata").value(DEFAULT_DURATA))
            .andExpect(jsonPath("$.rischio").value(DEFAULT_RISCHIO));
    }
    @Test
    @Transactional
    public void getNonExistingInvestimento() throws Exception {
        // Get the investimento
        restInvestimentoMockMvc.perform(get("/api/investimentos/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateInvestimento() throws Exception {
        // Initialize the database
        investimentoRepository.saveAndFlush(investimento);

        int databaseSizeBeforeUpdate = investimentoRepository.findAll().size();

        // Update the investimento
        Investimento updatedInvestimento = investimentoRepository.findById(investimento.getId()).get();
        // Disconnect from session so that the updates on updatedInvestimento are not directly saved in db
        em.detach(updatedInvestimento);
        updatedInvestimento
            .budget(UPDATED_BUDGET)
            .durata(UPDATED_DURATA)
            .rischio(UPDATED_RISCHIO);
        InvestimentoDTO investimentoDTO = investimentoMapper.toDto(updatedInvestimento);

        restInvestimentoMockMvc.perform(put("/api/investimentos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(investimentoDTO)))
            .andExpect(status().isOk());

        // Validate the Investimento in the database
        List<Investimento> investimentoList = investimentoRepository.findAll();
        assertThat(investimentoList).hasSize(databaseSizeBeforeUpdate);
        Investimento testInvestimento = investimentoList.get(investimentoList.size() - 1);
        assertThat(testInvestimento.getBudget()).isEqualTo(UPDATED_BUDGET);
        assertThat(testInvestimento.getDurata()).isEqualTo(UPDATED_DURATA);
        assertThat(testInvestimento.getRischio()).isEqualTo(UPDATED_RISCHIO);
    }

    @Test
    @Transactional
    public void updateNonExistingInvestimento() throws Exception {
        int databaseSizeBeforeUpdate = investimentoRepository.findAll().size();

        // Create the Investimento
        InvestimentoDTO investimentoDTO = investimentoMapper.toDto(investimento);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restInvestimentoMockMvc.perform(put("/api/investimentos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(investimentoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Investimento in the database
        List<Investimento> investimentoList = investimentoRepository.findAll();
        assertThat(investimentoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteInvestimento() throws Exception {
        // Initialize the database
        investimentoRepository.saveAndFlush(investimento);

        int databaseSizeBeforeDelete = investimentoRepository.findAll().size();

        // Get the investimento
        restInvestimentoMockMvc.perform(delete("/api/investimentos/{id}", investimento.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Investimento> investimentoList = investimentoRepository.findAll();
        assertThat(investimentoList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Investimento.class);
        Investimento investimento1 = new Investimento();
        investimento1.setId(1L);
        Investimento investimento2 = new Investimento();
        investimento2.setId(investimento1.getId());
        assertThat(investimento1).isEqualTo(investimento2);
        investimento2.setId(2L);
        assertThat(investimento1).isNotEqualTo(investimento2);
        investimento1.setId(null);
        assertThat(investimento1).isNotEqualTo(investimento2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(InvestimentoDTO.class);
        InvestimentoDTO investimentoDTO1 = new InvestimentoDTO();
        investimentoDTO1.setId(1L);
        InvestimentoDTO investimentoDTO2 = new InvestimentoDTO();
        assertThat(investimentoDTO1).isNotEqualTo(investimentoDTO2);
        investimentoDTO2.setId(investimentoDTO1.getId());
        assertThat(investimentoDTO1).isEqualTo(investimentoDTO2);
        investimentoDTO2.setId(2L);
        assertThat(investimentoDTO1).isNotEqualTo(investimentoDTO2);
        investimentoDTO1.setId(null);
        assertThat(investimentoDTO1).isNotEqualTo(investimentoDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(investimentoMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(investimentoMapper.fromId(null)).isNull();
    }
}
