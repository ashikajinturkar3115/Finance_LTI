/**
 * 
 */
package com.lti.fms.dao;

import java.util.List;

import com.lti.fms.entities.EMICard;
import com.lti.fms.entities.EMIPurchaseDescription;
import com.lti.fms.entities.ProductPurchased;

/**
 * @author lntinfotech
 *
 */
public interface EmiPurchaseDescriptionDao {

	public EMIPurchaseDescription createEmiPurchaseDescription(EMIPurchaseDescription eMIPurchaseDescription);

	public List<EMIPurchaseDescription> findAllEmiPurchaseDescriptionByEmiCard(String emiCard);

	public EMICard findEmiCardByEmiCardId(String emiCardId);
	
	public EMIPurchaseDescription findEmiPurchaseDescriptionById(int emiDesId);
	
	public List<ProductPurchased> findProductIdByEMICardNo(String emiCardNo);
	public EMIPurchaseDescription updateEmiPurchaseDescription(EMIPurchaseDescription emiPurchaseDescription);
}
