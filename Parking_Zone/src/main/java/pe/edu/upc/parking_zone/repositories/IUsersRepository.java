package pe.edu.upc.parking_zone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.parking_zone.entities.Users;

import java.util.List;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {
    public Users findOneByUsername(String username);

    @Query("Select u from Users u where u.username like %:nUsername%")
    public List<Users> buscarNombre(@Param("nUsername")String nUsername);
}
