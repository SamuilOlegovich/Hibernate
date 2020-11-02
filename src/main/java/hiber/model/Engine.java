package hiber.model;


import lombok.*;

//import javax.persistence.Id;

//import lombok.*;
import javax.persistence.*;


@Data                               // анотация выполяет роль замены гетеров и сетерв
@ToString
@EqualsAndHashCode
@NoArgsConstructor                  // анотация заменяет обязательное присутствие пустого конструктора
@AllArgsConstructor                 // анотация заменяет присутствие конструктора c параметрами
public class Engine {
    /**
     * если включены анотации по конструкторам, то нельзя делать ни какой другой конструктор вручную
     * название полей как и у базы
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String model;
    private int power;



    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
}