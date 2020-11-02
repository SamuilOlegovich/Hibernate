package hiber.model;


import javax.persistence.Id;
import lombok.*;



@Data                               // анотация выполяет роль замены гетеров и сетерв
@ToString
@EqualsAndHashCode
//@NoArgsConstructor                  // анотация заменяет обязательное присутствие пустого конструктора
@AllArgsConstructor                 // анотация заменяет присутствие конструктора c параметрами
public class Engine {
    /**
     * название полей как и у базы  */
    @Id
    private String model;
    private int power;






    public Engine() { }

    public Engine(String model) {
        this.model = model;
    }



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