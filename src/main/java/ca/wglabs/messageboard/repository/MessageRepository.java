package ca.wglabs.messageboard.repository;

import ca.wglabs.messageboard.model.Message;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findAllByOrderByIdAsc();

    List<Message> findByUserId(Long userId);


    @Transactional
    Long deleteByText(String text);

}
