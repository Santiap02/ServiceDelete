package Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Clase que define un objeto de respuesta generico para todos las Apis
 *
 * @author santiago.alvarezp@udea.edu.co
 *
 * @param <T>
 */

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto<T> implements Serializable {

    private int status;
    private String responseCode;
    private String responseMessage;
    private T data;

    public ResponseDto(int status, String responseCode, String responseMessage, T data) {
        this.status = status;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.data = data;
    }

    public ResponseDto(int status, String responseCode, String responseMessage) {
        this(status, responseCode, responseMessage, null);
    }

}
