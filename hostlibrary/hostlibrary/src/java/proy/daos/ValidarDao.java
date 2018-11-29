package proy.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import proy.entidades.EmpleadoLog;
import proy.service.LoginService;

public class ValidarDao implements LoginService{
      EntityManagerFactory emf;
    EntityManager em;
    
    public ValidarDao(){
        emf = Persistence.createEntityManagerFactory("libreriaPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public EmpleadoLog validar(String user, String password) {
         EmpleadoLog cliente;
        em.getTransaction().begin();
        Query q= em.createQuery("SELECT c from cliente c WHERE c.email = '"+user+"' and c.password = '"+ password +"'");
        cliente = (EmpleadoLog)q.getSingleResult();
        em.getTransaction().commit();
        return cliente;
    }

    @Override
    public int registrar(EmpleadoLog user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return 1;
    }
    
}
