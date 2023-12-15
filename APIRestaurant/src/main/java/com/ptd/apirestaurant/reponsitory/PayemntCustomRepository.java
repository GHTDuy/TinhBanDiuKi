package com.ptd.apirestaurant.reponsitory;


import com.ptd.apirestaurant.entity.Order;
import com.ptd.apirestaurant.entity.Payment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class PayemntCustomRepository {

    @Autowired
    EntityManager em;

    public List<Object[]> totalPaymentInRange(Map<String,String> param){
        SimpleDateFormat f = new SimpleDateFormat();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object> q = cb.createQuery(Object.class);
        Root<Payment> paymentRoot = q.from(Payment.class);
        Root<Order> orderRoot = q.from(Order.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(paymentRoot.get("orderId"),orderRoot.get("orderId")));
        String fromDate = param.get("fromDate");
        if(fromDate != null && !fromDate.isEmpty()){
            try {
                predicates.add(cb.greaterThanOrEqualTo(orderRoot.get("date"),f.parse(fromDate)));
            }catch (ParseException exception){
                Logger.getLogger(PaymentRepository.class.getName()).log(Level.SEVERE,null,exception);
            }
        }
        String toDate = param.get("toDate");
        if (toDate != null && !toDate.isEmpty()){
            try {
                predicates.add(cb.lessThanOrEqualTo(orderRoot.get("date"),f.parse(toDate)));
            }catch (ParseException exception){
                Logger.getLogger(PaymentRepository.class.getName()).log(Level.SEVERE,null,exception);
            }
        }
        q.where(predicates.toArray(Predicate[]::new));
        Query query = em.createQuery(q);
        return query.getResultList();
    }
}
