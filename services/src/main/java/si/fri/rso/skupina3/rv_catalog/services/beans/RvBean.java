package si.fri.rso.skupina3.rv_catalog.services.beans;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import si.fri.rso.skupina3.lib.Rv;
import si.fri.rso.skupina3.rv_catalog.models.converters.RvConverter;
import si.fri.rso.skupina3.rv_catalog.models.entities.RvEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RequestScoped
public class RvBean {

    private final Logger log = Logger.getLogger(RvBean.class.getName());

    @Inject
    private EntityManager em;

    public List<Rv> getRvs(UriInfo uriInfo) {

        QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery()).defaultOffset(0)
                .build();

        return JPAUtils.queryEntities(em, RvEntity.class, queryParameters).stream()
                .map(RvConverter::toDto).collect(Collectors.toList());

    }

    public Rv getRv(Integer rvId) {
        RvEntity rvEntity = em.find(RvEntity.class, rvId);

        if (rvEntity == null) {
            throw new NotFoundException();
        }

        return RvConverter.toDto(rvEntity);
    }

    public Rv createRv(Rv rv) {

        rv.setRating(0.0f);
        rv.setNum_of_reviews(0);
        RvEntity rvEntity = RvConverter.toEntity(rv);

        try {
            beginTx();
            rvEntity.setNum_of_reviews(0);
            em.persist(rvEntity);
            commitTx();
        }
        catch (Exception e) {
            rollbackTx();
        }

        if (rvEntity.getRv_id() == null) {
            throw new RuntimeException("Entity was not persisted");
        }

        return RvConverter.toDto(rvEntity);
    }

    public Rv updateRv(Integer rvId, Rv rv) {

        RvEntity rvEntity = em.find(RvEntity.class, rvId);

        if (rvEntity == null) {
            return null;
        }

        RvEntity updatedRvEntity = RvConverter.toEntity(rv);

        try {
            beginTx();
            updatedRvEntity.setRv_id(rv.getRv_id());
            em.merge(updatedRvEntity);
            commitTx();
        }
        catch (Exception e) {
            rollbackTx();
        }

        return RvConverter.toDto(updatedRvEntity);
    }

    public boolean deleteRv(Integer rvId) {

        RvEntity rvEntity = em.find(RvEntity.class, rvId);

        if (rvEntity != null) {
            try {
                beginTx();
                em.remove(rvEntity);
                commitTx();
            }
            catch (Exception e) {
                rollbackTx();
            }
        }
        else {
            return false;
        }

        return true;
    }

    public Rv updateRvRating(Integer rvId, Integer newScore) {

        RvEntity rvEntity = em.find(RvEntity.class, rvId);

        if (rvEntity == null) {
            return null;
        }

        Float newRating = (rvEntity.getRating() * rvEntity.getNum_of_reviews() + newScore) / (rvEntity.getNum_of_reviews() + 1);

        try {
            beginTx();
            rvEntity.setNum_of_reviews(rvEntity.getNum_of_reviews() + 1);
            rvEntity.setRating(newRating);
            em.merge(rvEntity);
            commitTx();
        }
        catch (Exception e) {
            rollbackTx();
        }

        return RvConverter.toDto(rvEntity);
    }

    private void beginTx() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    private void commitTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }
}
