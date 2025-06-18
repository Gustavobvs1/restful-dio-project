package dio.restful_dio_project.domain.repository;

import dio.restful_dio_project.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByAccountNumber(String accountNumber);

    Boolean existsByCardNumber(String cardNumber);
}
