package bohdan.task_from_vova.dao;

import bohdan.task_from_vova.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDao extends JpaRepository<Card,Integer> {
    Card getByNumberCard(int number);
}
