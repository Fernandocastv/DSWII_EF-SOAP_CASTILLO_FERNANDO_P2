package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.repository;

import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiembroRepository extends JpaRepository<Miembro,Integer> {
}
