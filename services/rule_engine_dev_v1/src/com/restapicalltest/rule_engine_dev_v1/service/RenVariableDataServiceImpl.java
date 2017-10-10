/*Copyright (c) 2017-2018 preito.com All Rights Reserved.
 This software is the confidential and proprietary information of preito.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with preito.com*/
package com.restapicalltest.rule_engine_dev_v1.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.restapicalltest.rule_engine_dev_v1.RenVariableData;


/**
 * ServiceImpl object for domain model class RenVariableData.
 *
 * @see RenVariableData
 */
@Service("rule_engine_dev_v1.RenVariableDataService")
@Validated
public class RenVariableDataServiceImpl implements RenVariableDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RenVariableDataServiceImpl.class);


    @Autowired
    @Qualifier("rule_engine_dev_v1.RenVariableDataDao")
    private WMGenericDao<RenVariableData, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RenVariableData, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "rule_engine_dev_v1TransactionManager")
    @Override
	public RenVariableData create(RenVariableData renVariableData) {
        LOGGER.debug("Creating a new RenVariableData with information: {}", renVariableData);
        RenVariableData renVariableDataCreated = this.wmGenericDao.create(renVariableData);
        return renVariableDataCreated;
    }

	@Transactional(readOnly = true, value = "rule_engine_dev_v1TransactionManager")
	@Override
	public RenVariableData getById(Integer renvariabledataId) throws EntityNotFoundException {
        LOGGER.debug("Finding RenVariableData by id: {}", renvariabledataId);
        RenVariableData renVariableData = this.wmGenericDao.findById(renvariabledataId);
        if (renVariableData == null){
            LOGGER.debug("No RenVariableData found with id: {}", renvariabledataId);
            throw new EntityNotFoundException(String.valueOf(renvariabledataId));
        }
        return renVariableData;
    }

    @Transactional(readOnly = true, value = "rule_engine_dev_v1TransactionManager")
	@Override
	public RenVariableData findById(Integer renvariabledataId) {
        LOGGER.debug("Finding RenVariableData by id: {}", renvariabledataId);
        return this.wmGenericDao.findById(renvariabledataId);
    }

    @Transactional(readOnly = true, value = "rule_engine_dev_v1TransactionManager")
    @Override
    public RenVariableData getByRenVariableIdAndVersion(int renVariableId, int version) {
        Map<String, Object> renVariableIdAndVersionMap = new HashMap<>();
        renVariableIdAndVersionMap.put("renVariableId", renVariableId);
        renVariableIdAndVersionMap.put("version", version);

        LOGGER.debug("Finding RenVariableData by unique keys: {}", renVariableIdAndVersionMap);
        RenVariableData renVariableData = this.wmGenericDao.findByUniqueKey(renVariableIdAndVersionMap);

        if (renVariableData == null){
            LOGGER.debug("No RenVariableData found with given unique key values: {}", renVariableIdAndVersionMap);
            throw new EntityNotFoundException(String.valueOf(renVariableIdAndVersionMap));
        }

        return renVariableData;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "rule_engine_dev_v1TransactionManager")
	@Override
	public RenVariableData update(RenVariableData renVariableData) throws EntityNotFoundException {
        LOGGER.debug("Updating RenVariableData with information: {}", renVariableData);
        this.wmGenericDao.update(renVariableData);

        Integer renvariabledataId = renVariableData.getId();

        return this.wmGenericDao.findById(renvariabledataId);
    }

    @Transactional(value = "rule_engine_dev_v1TransactionManager")
	@Override
	public RenVariableData delete(Integer renvariabledataId) throws EntityNotFoundException {
        LOGGER.debug("Deleting RenVariableData with id: {}", renvariabledataId);
        RenVariableData deleted = this.wmGenericDao.findById(renvariabledataId);
        if (deleted == null) {
            LOGGER.debug("No RenVariableData found with id: {}", renvariabledataId);
            throw new EntityNotFoundException(String.valueOf(renvariabledataId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "rule_engine_dev_v1TransactionManager")
	@Override
	public Page<RenVariableData> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RenVariableDatas");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "rule_engine_dev_v1TransactionManager")
    @Override
    public Page<RenVariableData> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RenVariableDatas");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "rule_engine_dev_v1TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service rule_engine_dev_v1 for table RenVariableData to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "rule_engine_dev_v1TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "rule_engine_dev_v1TransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}
