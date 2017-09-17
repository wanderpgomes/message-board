package ca.wglabs.messageboard.repository;

import ca.wglabs.messageboard.model.Message;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Iterable<Message> findAllByOrderByIdAsc();

    @Transactional
    Long deleteByText(String text);

}
