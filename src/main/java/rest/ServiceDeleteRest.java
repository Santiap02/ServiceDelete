package rest;

import Busines.ServiceDeleteBusiness;
import Domain.ResponseDto;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class ServiceDeleteRest {

    private final ServiceDeleteBusiness serviceDeleteBusiness;

    @Operation(summary = "Borrar un cliente", description = "Permite borrar un cliente con su Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente borrado", response = ResponseDto.class),
            @ApiResponse(code = 400, message = "No se encuentra información para borrar", response = ResponseDto.class),
            @ApiResponse(code = 500, message = "Error inesperado durante el proceso", response = ResponseDto.class) })
    @DeleteMapping("/photos/{clientId}")
    public ResponseDto<String> deletePhotoById(@Parameter(name = "id", required = true, description = "Id del cliente a borrar", schema = @Schema(implementation = int.class), in = ParameterIn.PATH) @PathVariable int clientId) {
        return serviceDeleteBusiness.deletePhoto(clientId);
    }

    @Operation(summary = "Borrar un cliente", description = "Permite borrar un cliente con su Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente borrado", response = ResponseDto.class),
            @ApiResponse(code = 400, message = "No se encuentra información para borrar", response = ResponseDto.class),
            @ApiResponse(code = 500, message = "Error inesperado durante el proceso", response = ResponseDto.class) })
    @DeleteMapping(value="/clientes/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<String> deleteClientById(@Parameter(name = "id", required = true, description = "Id del cliente a borrar", schema = @Schema(implementation = int.class), in = ParameterIn.PATH) @PathVariable("id") int clientId) {
        return serviceDeleteBusiness.deleteClient(clientId);
    }

}
