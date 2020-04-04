package br.com.estado.controller.swagger;

import br.com.estado.response.CityListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

/**
 * @author João Paulo Santarém
 */
@Api(value = "Cities", tags = "Information about cities")
public interface CityApi {

  @ApiOperation(value = "List all Cities",
      notes = "Operation to list all cities.",
      consumes = "application/json", produces = "application/json")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requested performed successfully.",
          response = CityListResponse.class)})
  ResponseEntity<CityListResponse> findAll();

}
