package Rest;

import Busines.ServiceDeleteBusiness;
import Domain.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class ServiceDeleteRest {

    private final ServiceDeleteBusiness serviceDeleteBusiness;
    @DeleteMapping("/photos/{title}")
    public ResponseDto BorrarfotoId(@PathVariable int title) {
        var response = serviceDeleteBusiness.DeleteByClientId(title);
        return response;
    }

    @DeleteMapping(value="/clientes/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto BorrarClienteId(@PathVariable("id") int id) {
        var response =serviceDeleteBusiness.eliminarCliente(id);
        return response;
    }



}
