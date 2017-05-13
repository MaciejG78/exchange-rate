package pl.com.bottega.exchangerate.infrastructure;

import org.hibernate.transform.RootEntityResultTransformer;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.NoRateException;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

/**
 * Created by maciek on 13.05.2017.
 */
public class JPAExchangeRateRepository implements ExchangeRateRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void put(ExchangeRate exchangeRate) {
        entityManager.persist(exchangeRate);
    }

    @Override
    public ExchangeRate get(String date, String currency) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ExchangeRate> criteriaQuery = criteriaBuilder.createQuery(ExchangeRate.class);
        Root<ExchangeRate> root = criteriaQuery.from(ExchangeRate.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("date"), date), criteriaBuilder.equal(root.get("currency"), currency));
        TypedQuery<ExchangeRate> query = entityManager.createQuery(criteriaQuery);
        ExchangeRate exchangeRate = query.getResultList().get(0);
        if (exchangeRate == null){
            throw new NoRateException("ExchangeRate", date.toString(), currency);
        }
        return exchangeRate;
    }


}
