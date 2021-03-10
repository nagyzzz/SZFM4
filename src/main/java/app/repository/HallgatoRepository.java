package app.repository;

import app.entity.Hallgato;
import app.entitymanager.CustomEntityManager;

import javax.persistence.EntityManager;

public class HallgatoRepository {
    private static EntityManager entityManager;

    static {
        entityManager = CustomEntityManager.getInstance();
    }


    public void save (Hallgato hallgato){
        entityManager.getTransaction().begin();
        entityManager.persist(hallgato);
        entityManager.getTransaction().commit();
    }
    public boolean HallgatoHozzaadasa(String nev, int ev, String neptunkod) {
        try {
            entityManager.createQuery(("SELECT h FROM Hallgato h WHERE h.nev = :nev AND h.szuletesi_ev = :ev AND h.neptun_kod = neptun_kod"))
                    .setParameter("nev", nev)
                    .setParameter("szuletesiev", ev)
                    .setParameter("neptunkod", neptunkod)
                    .getSingleResult();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

    }

}
