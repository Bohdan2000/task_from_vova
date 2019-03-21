package bohdan.task_from_vova.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numberCard;
    private int pinCode;
    private double cash;

    public Card(int numberCard, int pinCode, double cash) {
        this.numberCard = numberCard    ;
        this.pinCode = pinCode;
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", numberCard='" + numberCard + '\'' +
                ", pinCode=" + pinCode +
                ", cash=" + cash +
                '}';
    }
}
