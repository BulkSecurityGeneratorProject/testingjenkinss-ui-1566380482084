package org.app.ui.service;

import org.app.ui.domain.Cust;
import org.app.ui.repository.CustRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Cust.
 */
@Service
@Transactional
public class CustService {

    private final Logger log = LoggerFactory.getLogger(CustService.class);

    private final CustRepository custRepository;

    public CustService(CustRepository custRepository) {
        this.custRepository = custRepository;
    }

    /**
     * Save a cust.
     *
     * @param cust the entity to save
     * @return the persisted entity
     */
    public Cust save(Cust cust) {
        log.debug("Request to save Cust : {}", cust);
        return custRepository.save(cust);
    }

    /**
     * Get all the custs.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Cust> findAll() {
        log.debug("Request to get all Custs");
        return custRepository.findAll();
    }


    /**
     * Get one cust by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Cust> findOne(Long id) {
        log.debug("Request to get Cust : {}", id);
        return custRepository.findById(id);
    }

    /**
     * Delete the cust by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Cust : {}", id);
        custRepository.deleteById(id);
    }
}
