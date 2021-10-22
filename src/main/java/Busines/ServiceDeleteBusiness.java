package Busines;

import Domain.ResponseDto;

public interface ServiceDeleteBusiness {
    ResponseDto eliminarCliente(int idCliente);
    ResponseDto DeleteByClientId(int clientId);

}
