package br.com.estado.controller.swagger;

import br.com.estado.response.StateListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

}
