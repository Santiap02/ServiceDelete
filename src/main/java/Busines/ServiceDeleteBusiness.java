package Busines;

import Domain.ResponseDto;

public interface ServiceDeleteBusiness {
    ResponseDto<String> deleteClient(int idCliente);
    ResponseDto<String> deletePhoto(int clientId);

}
