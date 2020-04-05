package br.com.state.controller.swagger;

import br.com.state.request.StateRequest;
import br.com.state.response.StateListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

/**
 * @author João Paulo Santarém
 */
@Api(value = "State", tags = "Information about states")
public interface StateApi {

  @ApiOperation(value = "List all States",
      notes = "Operation to list all states.",
      consumes = "application/json", produces = "application/json")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requested performed successfully.",
          response = StateListResponse.class)})
  ResponseEntity<StateListResponse> findAll();

  @ApiOperation(value = "Create a State",
      notes = "Operation to create a state.",
      consumes = "application/json", produces = "application/json")
  @ApiResponses({
      @ApiResponse(code = 201, message = "Requested performed successfully.",
          response = Void.class)})
  ResponseEntity<Void> save(
      @ApiParam(name = "Request") StateRequest stateRequest);

  @ApiOperation(value = "List all States",
      notes = "Operation to list all states.",
      consumes = "application/json", produces = "application/json")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requested performed successfully.",
          response = Void.class)})
  ResponseEntity<Void> update(
      @ApiParam(name = "State id", example = "1") Long stateId,
      @ApiParam(name = "Request") StateRequest stateRequest);

}
