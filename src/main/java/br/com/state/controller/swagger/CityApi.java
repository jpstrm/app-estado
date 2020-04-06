package br.com.state.controller.swagger;

import br.com.state.request.CityListRequest;
import br.com.state.request.CityRequest;
import br.com.state.response.CityListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author João Paulo Santarém
 */
@Api(value = "Cities", tags = "CityApi")
public interface CityApi {

  @ApiOperation(value = "List all Cities",
      notes = "Operation to list all cities.",
      consumes = "application/json", produces = "application/json")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requested performed successfully.",
          response = CityListResponse.class)})
  ResponseEntity<CityListResponse> findAll();

  @ApiOperation(value = "Create a City",
      notes = "Operation to create a city.",
      consumes = "application/json", produces = "application/json")
  @ApiResponses({
      @ApiResponse(code = 201, message = "Requested performed successfully.",
          response = Void.class)})
  ResponseEntity<Void> save(
      @ApiParam(name = "Request", required = true) @RequestBody CityRequest cityRequest);

  @ApiOperation(value = "Create list of Cities",
      notes = "Operation to create a list of cities.",
      consumes = "application/json", produces = "application/json")
  @ApiResponses({
      @ApiResponse(code = 201, message = "Requested performed successfully.",
          response = Void.class)})
  ResponseEntity<Void> saveAll(
      @ApiParam(required = true) @RequestBody CityListRequest cityListRequest);

  @ApiOperation(value = "List all Cities",
      notes = "Operation to list all cities.",
      consumes = "application/json", produces = "application/json")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requested performed successfully.",
          response = Void.class)})
  ResponseEntity<Void> update(
      @ApiParam(example = "1", required = true) @PathVariable Long cityId,
      @ApiParam(required = true) @RequestBody CityRequest cityRequest);

  @ApiOperation(value = "List all Cities by State id",
      notes = "Operation to list all cities by state id.",
      consumes = "application/json", produces = "application/json")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requested performed successfully.",
          response = CityListResponse.class)})
  ResponseEntity<CityListResponse> findByStateId(
      @ApiParam(example = "1", required = true) @PathVariable Long stateId);

  @ApiOperation(value = "Delete by id",
      notes = "Operation to delete a city by id.",
      consumes = "application/json", produces = "application/json")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requested performed successfully.",
          response = Void.class)})
  ResponseEntity<Void> deleteById(
      @ApiParam(example = "1", required = true) @PathVariable Long cityId);

}
