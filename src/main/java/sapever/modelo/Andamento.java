package sapever.modelo;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Table(name = "SAPE_ANDAMENTO", schema = "ADMSUPRE2TESTE")
@Data
@Immutable
public class Andamento {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @Column(name = "NUM_ANDAMENTO")
    int numero;

    @Column(name = "DES_ANDAMENTO")
    String descricao;

    @Column(name = "DETALHAMENTO")
    String detalhamento;

    /**
     * Número hexadecimal para a cor
     */
    String cor;

    /**
     * Determina se pendências devem ser verificadas para este andamento
     */
    boolean verificaPendencias;

    /**
     * Determina se este é o último andamento possivel
     */
    boolean ultimo;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_GRUPO_ANDAMENTO", referencedColumnName = "COD_OBJETO")
    GrupoAndamento grupoAndamento;
}
