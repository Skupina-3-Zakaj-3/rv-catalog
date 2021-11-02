package si.fri.rso.skupina3.rv_catalog.services.beans;

import si.fri.rso.skupina3.lib.Rv;
import si.fri.rso.skupina3.rv_catalog.models.converters.RvConverter;
import si.fri.rso.skupina3.rv_catalog.models.entities.RvEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RequestScoped
public class RvBean {

    private Logger log = Logger.getLogger(RvBean.class.getName());

    @Inject
    private EntityManager em;

    public List<Rv> getRv() {

        TypedQuery<RvEntity> query = em.createNamedQuery(
                "RvEntity.getAll", RvEntity.class);

        List<RvEntity> resultList = query.getResultList();

        return resultList.stream().map(RvConverter::toDto).collect(Collectors.toList());

    }
}
