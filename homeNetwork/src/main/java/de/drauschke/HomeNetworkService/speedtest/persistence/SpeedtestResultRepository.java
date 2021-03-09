package de.drauschke.HomeNetworkService.speedtest.persistence;

import org.springframework.data.repository.CrudRepository;

/**
 * This repository will be automatically implemented by Spring into a bean called
 * SpeedtestResultRepository. CRUD refers to Create, Read, Update, Delete
 */
public interface SpeedtestResultRepository extends CrudRepository<SpeedtestResult, Integer> {}
