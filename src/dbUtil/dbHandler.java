package dbUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class dbHandler {
    public dbHandler(){}
    public void addSolution(Resolution solution) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        System.out.println("Session opened");
        try {
            session.beginTransaction();
            session.save(solution);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();

        }
    }

    public String getSolution(String lvlid)
    {
        StringBuilder search= new StringBuilder(lvlid);
        while(search.length()<10)
        {
            search.append(" ");
        }
        ObservableList<Resolution> solutions= FXCollections.observableArrayList();
        Query<Resolution> query=HibernateUtil.getSessionFactory().openSession().createQuery("from Solutions");
        System.out.println(query.list().toString());
        Resolution solution=new Resolution();
        for (Resolution r:query.list()) {
            System.out.println("REQUESTED:"+lvlid.toUpperCase()+"SIZE:"+lvlid.length()+" CHECKING ON:"+r.getLevelName().toUpperCase()+"SIZE:"+r.getLevelName().length());
            if(r.getLevelName().equals(search.toString()))
            {
                System.out.println("FOUND SOLUTION!");
                HibernateUtil.getSessionFactory().getCurrentSession().close();
                return r.getSolution();
            }
        }
        HibernateUtil.getSessionFactory().getCurrentSession().close();
        return null;

    }


}
