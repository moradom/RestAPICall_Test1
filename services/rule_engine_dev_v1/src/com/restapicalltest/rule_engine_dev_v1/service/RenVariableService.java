/*Copyright (c) 2017-2018 preito.com All Rights Reserved.
 This software is the confidential and proprietary information of preito.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with preito.com*/
package com.restapicalltest.rule_engine_dev_v1.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.restapicalltest.rule_engine_dev_v1.RenVariable;

/**
 * Service object for domain model class {@link RenVariable}.
 */
public interface RenVariableService {

    /**
     * Creates a new RenVariable. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RenVariable if any.
     *
     * @param renVariable Details of the RenVariable to be created; value cannot be null.
     * @return The newly created RenVariable.
     */
	RenVariable create(@Valid RenVariable renVariable);


	/**
	 * Returns RenVariable by given id if exists.
	 *
	 * @param renvariableId The id of the RenVariable to get; value cannot be null.
	 * @return RenVariable associated with the given renvariableId.
     * @throws EntityNotFoundException If no RenVariable is found.
	 */
	RenVariable getById(Integer renvariableId) throws EntityNotFoundException;

    /**
	 * Find and return the RenVariable by given id if exists, returns null otherwise.
	 *
	 * @param renvariableId The id of the RenVariable to get; value cannot be null.
	 * @return RenVariable associated with the given renvariableId.
	 */
	RenVariable findById(Integer renvariableId);

    /**
	 * Find and return the RenVariable for given name  if exists.
	 *
	 * @param name value of name; value cannot be null.
	 * @return RenVariable associated with the given inputs.
     * @throws EntityNotFoundException if no matching RenVariable found.
	 */
    RenVariable getByName(String name)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing RenVariable. It replaces all fields of the existing RenVariable with the given renVariable.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on RenVariable if any.
     *
	 * @param renVariable The details of the RenVariable to be updated; value cannot be null.
	 * @return The updated RenVariable.
	 * @throws EntityNotFoundException if no RenVariable is found with given input.
	 */
	RenVariable update(@Valid RenVariable renVariable) throws EntityNotFoundException;

    /**
	 * Deletes an existing RenVariable with the given id.
	 *
	 * @param renvariableId The id of the RenVariable to be deleted; value cannot be null.
	 * @return The deleted RenVariable.
	 * @throws EntityNotFoundException if no RenVariable found with the given id.
	 */
	RenVariable delete(Integer renvariableId) throws EntityNotFoundException;

	/**
	 * Find all RenVariables matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RenVariables.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<RenVariable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all RenVariables matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RenVariables.
     *
     * @see Pageable
     * @see Page
	 */
    Page<RenVariable> findAll(String query, Pageable pageable);

    /**
	 * Exports all RenVariables matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the RenVariables in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the RenVariable.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}

