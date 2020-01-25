package com.lti.fms.service;

import java.util.List;

import com.lti.fms.entities.EMICard;
import com.lti.fms.entities.EMIPurchaseDescription;

public interface EmiPurchaseDescriptionService {

	public EMIPurchaseDescription createEmiPurchaseDescription(EMIPurchaseDescription eMIPurchaseDescription);

	public List<EMIPurchaseDescription> findAllEmiPurchaseDescriptionByEmiCard(String emiCard);
	
	public EMICard findEmiCardByEmiCardId(String emiCardId);
	
	public EMIPurchaseDescription findEmiPurchaseDescriptionById(int emiDesId);
	
	public EMIPurchaseDescription updateEmiPurchaseDescription(EMIPurchaseDescription emiPurchaseDescription);

}
