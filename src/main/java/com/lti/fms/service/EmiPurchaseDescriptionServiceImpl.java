/**
 * 
 */
package com.lti.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.fms.dao.EmiPurchaseDescriptionDao;
import com.lti.fms.entities.EMICard;
import com.lti.fms.entities.EMIPurchaseDescription;

/**
 * @author lntinfotech
 *
 */
@Service
@Transactional
public class EmiPurchaseDescriptionServiceImpl implements EmiPurchaseDescriptionService {

	@Autowired
	private EmiPurchaseDescriptionDao eMIPurchaseDescriptiondao;

	@Override
	public EMIPurchaseDescription createEmiPurchaseDescription(EMIPurchaseDescription eMIPurchaseDescription) {

		return eMIPurchaseDescriptiondao.createEmiPurchaseDescription(eMIPurchaseDescription);
	}

	@Override
	public List<EMIPurchaseDescription> findAllEmiPurchaseDescriptionByEmiCard(String emiCard) {
	
		return eMIPurchaseDescriptiondao.findAllEmiPurchaseDescriptionByEmiCard(emiCard);
	}

	@Override
	public EMICard findEmiCardByEmiCardId(String emiCardId) {
		
		return eMIPurchaseDescriptiondao.findEmiCardByEmiCardId(emiCardId);
	}

	@Override
	public EMIPurchaseDescription findEmiPurchaseDescriptionById(int emiDesId) {
		
		return eMIPurchaseDescriptiondao.findEmiPurchaseDescriptionById(emiDesId);
	}

	@Override
	public EMIPurchaseDescription updateEmiPurchaseDescription(EMIPurchaseDescription emiPurchaseDescription) {
		
		return eMIPurchaseDescriptiondao.updateEmiPurchaseDescription(emiPurchaseDescription);
	}

}
