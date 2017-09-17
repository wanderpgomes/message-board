package ca.wglabs.messageboard.repository;

import ca.wglabs.messageboard.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByOrderByIdAsc();

    @Transactional
    Long deleteByName(String name);

}
