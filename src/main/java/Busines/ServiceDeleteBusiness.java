package Busines;

import Domain.ResponseDto;
/**
 * Interfaz donde se definen las operaciones a implementar para el proceso eliminación de información de clientes
 *
 * @author santiago.alvarezp@udea.edu.co
 * @version 1.0
 */
public interface ServiceDeleteBusiness {

    /**
     *
     * @param idCliente Id del cliente a borrar
     * @return Objeto de respuesta
     */
    ResponseDto<String> deleteClient(int idCliente);

    /**
     *
     * @param clientId Id del cliente correspondiente a la foto a borrar
     * @return Objeto de respuesta
     */
    ResponseDto<String> deletePhoto(int clientId);

}
