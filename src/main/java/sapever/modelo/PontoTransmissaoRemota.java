package sapever.modelo;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import sapever.modelo.enums.TipoPontoTransmissaoRemota;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SAPE_PONTO_TR", schema = "ADMSUPRE2TESTE")
@Data
@Immutable
public class PontoTransmissaoRemota {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @Column(name = "NUM_PONTO_TR")
    int numero;

    @Column(name = "DES_PONTO_TR")
    String descricao;

    @Enumerated(EnumType.STRING)
    TipoPontoTransmissaoRemota tipo;

    String latitude;
    String longitude;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_PLEITO", referencedColumnName = "COD_OBJETO")
    Pleito pleito;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_MUNICIPIO_SEDE", referencedColumnName = "COD_OBJETO")
    Municipio municipioSede;

    @OneToMany(mappedBy = "pontoTransmissaoRemota")
    List<SecaoTransmissaoRemota> secoesTransmissaoRemota;
}
