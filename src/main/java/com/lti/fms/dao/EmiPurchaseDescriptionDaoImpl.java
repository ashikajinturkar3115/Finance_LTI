/**
 * 
 */
package com.lti.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.fms.entities.CustomerLogin;
import com.lti.fms.entities.EMICard;
import com.lti.fms.entities.EMIPurchaseDescription;
import com.lti.fms.entities.ProductPurchased;

/**
 * @author lntinfotech
 *
 */

@Repository
@Transactional
public class EmiPurchaseDescriptionDaoImpl implements EmiPurchaseDescriptionDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EMIPurchaseDescription createEmiPurchaseDescription(EMIPurchaseDescription eMIPurchaseDescription) {
		EMIPurchaseDescription emiPurchaseDescription2 = eMIPurchaseDescription;
		entityManager.persist(eMIPurchaseDescription);
		entityManager.flush();
		return emiPurchaseDescription2;
	}

	@Override
	public List<EMIPurchaseDescription> findAllEmiPurchaseDescriptionByEmiCard(String emiCard) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		AbstractQuery<EMIPurchaseDescription> cq1 = cb.createQuery(EMIPurchaseDescription.class);
		Root<EMIPurchaseDescription> custRoot = cq1.from(EMIPurchaseDescription.class);

		cq1.where(cb.equal(custRoot.get("emiCardNumber"), emiCard));

		CriteriaQuery<EMIPurchaseDescription> selectRecord = ((CriteriaQuery<EMIPurchaseDescription>) cq1)
				.select(custRoot);
		TypedQuery<EMIPurchaseDescription> tq1 = entityManager.createQuery(selectRecord);
		List<EMIPurchaseDescription> list = tq1.getResultList();

		return list;
	}

	@Override
	public EMICard findEmiCardByEmiCardId(String emiCardId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		AbstractQuery<EMICard> cq1 = cb.createQuery(EMICard.class);
		Root<EMICard> custRoot = cq1.from(EMICard.class);

		cq1.where(cb.equal(custRoot.get("emiCardNo"), emiCardId));

		CriteriaQuery<EMICard> selectRecord = ((CriteriaQuery<EMICard>) cq1).select(custRoot);
		TypedQuery<EMICard> tq1 = entityManager.createQuery(selectRecord);
		EMICard emiCard = tq1.getSingleResult();
		return emiCard;
	}

	@Override
	public EMIPurchaseDescription findEmiPurchaseDescriptionById(int emiDesId) {
		EMIPurchaseDescription eDescription = entityManager.find(EMIPurchaseDescription.class, emiDesId);
		return eDescription;
	}

	@Override
	public EMIPurchaseDescription updateEmiPurchaseDescription(EMIPurchaseDescription emiPurchaseDescription) {
		EMIPurchaseDescription emDescription = emiPurchaseDescription;
		entityManager.merge(emiPurchaseDescription);
		return emDescription ;
	}

	@Override
	public List<ProductPurchased> findProductIdByEMICardNo(String emiCardNo) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		AbstractQuery<ProductPurchased> cq1 = cb.createQuery(ProductPurchased.class);
		Root<ProductPurchased> custRoot = cq1.from(ProductPurchased.class);

		cq1.where(cb.equal(custRoot.get("emiCardNo"), emiCardNo));

		CriteriaQuery<ProductPurchased> selectRecord = ((CriteriaQuery<ProductPurchased>) cq1).select(custRoot);
		TypedQuery<ProductPurchased> tq1 = entityManager.createQuery(selectRecord);
		List<ProductPurchased> list = tq1.getResultList();
		return list;
		
	}

}
