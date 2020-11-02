package hiber;

import hiber.dao.DAO;
import hiber.dao.EngineDAO;
import hiber.model.Engine;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {

    public static void main(String[] args) {

        SessionFactory factory = null;

        try {
//            factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            factory = new Configuration().configure().buildSessionFactory();

            DAO<Engine, String> engineDAO = new EngineDAO(factory);

            /**
             * записываем в базу */
            final Engine engine = new Engine();
            engine.setModel("engine_model_03");
            engine.setPower(12345);
            engineDAO.create(engine);

            /**
             *  читаем из базы  */
            final Engine result = engineDAO.read("engine_model_03");
            System.out.println("\n  Created : " + result + "\n");

            /**
             * обновляем данные в базе (прежде надо достать обновляемые данные) */
            result.setPower(54321);
            engineDAO.update(result);
            /**
             * и выводим результат обновления   */
            final Engine update = engineDAO.read("engine_model_03");
            System.out.println("\n  Updated : " + update + "\n");

            /**
             * удаляем из базы данных   */
            Engine engineDelete = new Engine();
            engineDelete.setModel("engine_model_03");
            engineDAO.delete(engineDelete);
            // теперь пытаемся вытащить что-то по удаленному ключу, будет - Engine(model=null, power=null)
            System.out.println("\n  Deleted(empty obj) : " + engineDAO.read("engine_model_03") + "\n");
        } finally {
            if (factory != null) {
                System.out.println("null");
                factory.close();
            }
        }
    }
}