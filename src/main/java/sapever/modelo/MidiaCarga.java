package sapever.modelo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SAPE_MIDIA_CARGA", schema = "ADMSUPRE2TESTE")
@Data
public class MidiaCarga {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    String codFlash;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_PLEITO", referencedColumnName = "COD_OBJETO")
    Pleito pleito;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_ZONA", referencedColumnName = "COD_OBJETO")
    Zona zona;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_MUNICIPIO", referencedColumnName = "COD_OBJETO")
    Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_ETAPA_GERACAO", referencedColumnName = "COD_OBJETO")
    Etapa etapa;

    @OneToMany
    @JoinTable(name = "SAPE_MIDIA_CARGA_SECAO",
            joinColumns = {@JoinColumn(name = "COD_OBJETO_SECAO")},
            inverseJoinColumns = {@JoinColumn(name = "COD_OBJETO_MIDIA_CARGA")})
    List<Secao> secoes;
}
