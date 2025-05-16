package nicoprojects.zona_fit.repositorio;

import nicoprojects.zona_fit.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> { //Tipo de dato con el que se esta trabajando , el tipo de la llave primaria

}
