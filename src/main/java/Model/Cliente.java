package Model;
/**
 * Modelo para la conexion a la base de datos "clientes".
 *
 * @author santiago.alvarezp@udea.edu.co
 *
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="clientes")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    private Integer idCliente;
    private String nombres;
    private String apellidos;
    private String docType;
    private Integer edad;
    private String ciudad;


}
