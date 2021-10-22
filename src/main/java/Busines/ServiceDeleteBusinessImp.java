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

import java.util.Optional;

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
    public ResponseDto eliminarCliente(int idCliente) {
        LOGGER.debug("Se inicia agregarCliente");
        var response = new ResponseDto<>();
        try {
            var result =clientRepository.findById(idCliente).orElseThrow(() -> new ServiceGetException(HttpStatus.BAD_REQUEST.value(),
                    ServiceConstants.SA005, ServiceConstants.SA005M));
            LOGGER.debug("Se borra el cliente "+result);
            clientRepository.deleteById(idCliente);
            response = new ResponseDto<>(HttpStatus.OK.value(), ServiceConstants.SA004, ServiceConstants.SA004M);
        }catch (ServiceGetException e) {
            LOGGER.error("Error in eliminarCliente", e);
            response = new ResponseDto<>(e.getStatus(), e.getCode(), e.getMessage());
        }catch (Exception e){
        LOGGER.error("Error in eliminarCliente", e);
        response = new ResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ServiceConstants.SA100, ServiceConstants.SA100M);
    }
        LOGGER.debug("eliminarCliente retorna "+response);
        return response;
    }

    @Override
    public ResponseDto DeleteByClientId(int clientId) {
        LOGGER.debug("Se inicia agregarCliente");
        var response = new ResponseDto<>();
        try {
            var result= Optional.ofNullable(photoRepository.findByClientId(clientId)).orElseThrow(() -> new ServiceGetException(HttpStatus.BAD_REQUEST.value(),
                    ServiceConstants.SA005, ServiceConstants.SA005M));
            LOGGER.debug("Se borra la foto "+result);
            photoRepository.deleteByClientId(clientId);
        }catch (ServiceGetException e){
            LOGGER.error("Error in getPhotoByClientId", e);
            response = new ResponseDto<>(e.getStatus(), e.getCode(), e.getMessage());
        }
            catch (Exception e){
            LOGGER.error("Error in getPhotoByClientId", e);
            response = new ResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ServiceConstants.SA100, ServiceConstants.SA100M);
        }
        return response;
    }
}
