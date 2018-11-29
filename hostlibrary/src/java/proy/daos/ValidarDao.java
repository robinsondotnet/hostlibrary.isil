package proy.daos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import proy.entidades.EmpleadoLog;
import proy.service.LoginService;


public class ValidarDao implements LoginService{
      EntityManagerFactory emf;
    EntityManager em;
    
    public ValidarDao(){
        emf = Persistence.createEntityManagerFactory("HostLibraryPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public EmpleadoLog validar(String user, String password) {
        EmpleadoLog admin;
        
        Query q= em.createNamedQuery("validarLogin");
        q.setParameter("us",user);
        q.setParameter("ps", password);
        try{
            admin= (EmpleadoLog)q.getSingleResult();
        }catch(NoResultException ex){
            admin=null;
        }
        
        return admin;
    }

    @Override
    public int registrar(EmpleadoLog user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return 1;
    }
    
}
