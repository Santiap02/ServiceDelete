package Busines;

import Domain.ResponseDto;
import Repository.ClientRepository;
import Repository.PhotoRepository;
import Util.ServiceConstants;
import exception.ServiceGetException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceDeleteBusinessImp implements ServiceDeleteBusiness {
    
    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceDeleteBusinessImp.class);
    /** Objeto para acceder a la capa de datos de clientes */
    private final ClientRepository clientRepository;
    /** Objeto para acceder a la capa de datos de fotos */
    private final PhotoRepository photoRepository;

    @Override
    public ResponseDto<String> deleteClient(int idCliente) {
        LOGGER.debug("Se inicia deleteClient");
        ResponseDto<String> response;
        try {
            var result =clientRepository.findById(idCliente).orElseThrow(() -> new ServiceGetException(HttpStatus.NOT_FOUND.value(),
                    ServiceConstants.SA005, ServiceConstants.SA005M));
            clientRepository.deleteById(idCliente);
            response = new ResponseDto<>(HttpStatus.OK.value(), ServiceConstants.SA004, ServiceConstants.SA004M, result.getIdCliente().toString());
        }catch (ServiceGetException e) {
            LOGGER.error("Error in deleteClient", e);
            response = new ResponseDto<>(e.getStatus(), e.getCode(), e.getMessage());
        }catch (Exception e){
        LOGGER.error("Error in deleteClient", e);
        response = new ResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ServiceConstants.SA100, ServiceConstants.SA100M);
    }
        LOGGER.debug("deleteClient retorna: {}",response);
        return response;
    }

    @Override
    public ResponseDto<String> deletePhoto(int clientId) {
        LOGGER.debug("Se inicia deletePhoto");
        ResponseDto<String> response;
        try {
            var result= photoRepository.findByClientId(clientId).orElseThrow(() -> new ServiceGetException(HttpStatus.NOT_FOUND.value(),
                    ServiceConstants.SA005, ServiceConstants.SA005M));
            photoRepository.deleteByClientId(clientId);
            response = new ResponseDto<>(HttpStatus.OK.value(), ServiceConstants.SA004, ServiceConstants.SA004M, result.getId());
        }catch (ServiceGetException e){
            LOGGER.error("Error in deletePhoto", e);
            response = new ResponseDto<>(e.getStatus(), e.getCode(), e.getMessage());
        }
            catch (Exception e){
            LOGGER.error("Error in deletePhoto", e);
            response = new ResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ServiceConstants.SA100, ServiceConstants.SA100M);
        }
        LOGGER.debug("deletePhoto retorna: {}",response);
        return response;
    }

}
