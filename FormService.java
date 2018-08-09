package com.homegenius.form.service;

import java.util.List;

import com.homegenius.form.bean.Form;
import com.homegenius.form.dto.FormCreationRequest;
import com.homegenius.form.dto.FormDomain;
import com.homegenius.form.dto.FormInstancePreviewResponse;
import com.homegenius.form.dto.FormResponse;
import com.homegenius.form.dto.FormSearchResponse;
import com.homegenius.form.dto.FormUpdationRequest;
import com.homegenius.form.exception.InvalidInputException;
import com.homegenius.form.exception.RecordAlreadyExistsException;
import com.homegenius.form.exception.RecordNotFoundException;

public interface FormService {

	public Form getFormById(String id);

	public boolean deleteFormById(String id);

	public Form createForm(FormDomain formDomain) throws InvalidInputException;

	public Form updateForm(Form form)
			throws InvalidInputException, RecordNotFoundException, RecordAlreadyExistsException;

	/**
	 * Method to get paginated list of forms
	 * @param offset
	 * @param size
	 * @return
	 */
	public List<FormResponse> getPaginatedFormsList(int offset, int size);
	
	/**
	 * Method to get Form by formId
	 * @param formId
	 * @return
	 */
	public FormResponse getFormByFormId(String formId);
	
	/**
	 * Method to create a form
	 * @param formCreationRequest
	 * @return
	 */
	public FormResponse createForm(FormCreationRequest formCreationRequest);
	
	/**
	 * Method to update form mapping
	 * @param formUpdationRequest
	 * @return
	 */
	public FormResponse updateFormMapping(FormUpdationRequest formUpdationRequest);
	
	public List<FormSearchResponse> SearchForm(String searchText,String formCategory,String formMls);

	
	

}
