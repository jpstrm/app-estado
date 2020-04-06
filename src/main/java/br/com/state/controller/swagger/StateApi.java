package br.com.state.controller.swagger;

import br.com.state.request.StateRequest;
import br.com.state.response.StateListResponse;
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
@Api(value = "State", tags = "StateApi")
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
      @ApiParam @RequestBody StateRequest stateRequest);

  @ApiOperation(value = "List all States",
      notes = "Operation to list all states.",
      consumes = "application/json", produces = "application/json")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requested performed successfully.",
          response = Void.class)})
  ResponseEntity<Void> update(
      @ApiParam(example = "1", required = true) @PathVariable Long stateId,
      @ApiParam(required = true) @RequestBody StateRequest stateRequest);

}
