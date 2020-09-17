package sapever.modelo;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Table(name = "SAPE_SECAO_TR", schema = "ADMSUPRE2TESTE")
@Data
@Immutable
public class SecaoTransmissaoRemota {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_PONTO_TR", referencedColumnName = "COD_OBJETO")
    PontoTransmissaoRemota pontoTransmissaoRemota;

    @OneToOne
    @JoinColumn(name = "COD_OBJETO_SECAO", referencedColumnName = "COD_OBJETO")
    Secao secao;
}
