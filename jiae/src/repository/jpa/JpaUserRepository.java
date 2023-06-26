package repository.jpa;

import java.util.Optional;
import repository.domain.User;

/**
 * JpaRepository 관련 인터페이스
 */
public interface JpaUserRepository //extends JpaRepository<repository.domain.User, Long>
{

  User save(User user);

  Optional<User> findById(Long id);

  User findByEmail(String email);

  void deleteById(Long id);
}
