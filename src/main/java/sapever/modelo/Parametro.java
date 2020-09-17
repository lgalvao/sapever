package sapever.modelo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Parametro {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @Column(name = "NOM_PARAMETRO")
    String nome;

    @Column(name = "VAL_PARAMETRO")
    String valor;
}
