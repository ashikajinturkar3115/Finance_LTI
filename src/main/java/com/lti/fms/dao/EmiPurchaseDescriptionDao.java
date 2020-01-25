/**
 * 
 */
package com.lti.fms.dao;

import java.util.List;

import com.lti.fms.entities.EMICard;
import com.lti.fms.entities.EMIPurchaseDescription;

/**
 * @author lntinfotech
 *
 */
public interface EmiPurchaseDescriptionDao {

	public EMIPurchaseDescription createEmiPurchaseDescription(EMIPurchaseDescription eMIPurchaseDescription);

	public List<EMIPurchaseDescription> findAllEmiPurchaseDescriptionByEmiCard(String emiCard);

	public EMICard findEmiCardByEmiCardId(String emiCardId);
	
	public EMIPurchaseDescription findEmiPurchaseDescriptionById(int emiDesId);
	
	public EMIPurchaseDescription updateEmiPurchaseDescription(EMIPurchaseDescription emiPurchaseDescription);
}
