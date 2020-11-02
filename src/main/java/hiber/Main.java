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
            // записываем в базу

//            factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Engine, String> engineDAO = new EngineDAO(factory);

            final Engine engine = new Engine();
            engine.setModel("engine_model_03");
            engine.setPower(12345);

            engineDAO.create(engine);

            // читаем из базы

//            final Engine result = engineDAO.read("engine_model_03");
//            System.out.println("Created : " + result);
//            System.out.println();
//
//            result.setPower(54321);
//            engineDAO.update(result);
//
//            final Engine update = engineDAO.read("engine_model_03");
//            System.out.println("Updated : " + update);
//            System.out.println();
//
//            engineDAO.delete(new Engine("engine_model_03", 54321));
//
//            System.out.println("Deleted(empty obj) : " + engineDAO.read("engine_model_03"));

        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}