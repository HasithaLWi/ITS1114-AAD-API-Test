package lk.ijse.AAD.repository;

import lk.ijse.AAD.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT u FROM Users u WHERE (?1 IS NULL OR u.firstName LIKE %?1%) " +
            "AND (?2 IS NULL OR u.lastName LIKE %?2%)")
    List<Users> findByFirstNameAndLastName(String firstName, String lastName);
}
