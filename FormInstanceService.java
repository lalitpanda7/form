package com.homegenius.form.service;

import java.util.List;

import com.homegenius.form.bean.FormInstance;
import com.homegenius.form.dto.FormInstanceCreationRequest;
import com.homegenius.form.dto.FormInstanceDomain;
import com.homegenius.form.dto.FormInstancePreviewResponse;
import com.homegenius.form.dto.FormInstanceResponse;
import com.homegenius.form.dto.FormInstanceWorkflowIdResponse;
import com.homegenius.form.exception.InvalidInputException;
import com.homegenius.form.exception.RecordAlreadyExistsException;
import com.homegenius.form.exception.RecordNotFoundException;

public interface FormInstanceService {

	public FormInstance getFormInstanceById(String id);

	public boolean deleteFormInstanceById(String id);

	public FormInstance createFormInstance(FormInstanceDomain formInstanceDomain)
			throws InvalidInputException;

	public FormInstance updateFormInstance(FormInstance formInstance)
			throws InvalidInputException, RecordNotFoundException, RecordAlreadyExistsException;

	/**
	 * Method to create form instance
	 * 
	 * @param formInstanceCreationRequest
	 * @return
	 */
	public FormInstanceResponse createFormInstance(FormInstanceCreationRequest formInstanceCreationRequest);

	/**
	 * Method to fetch form instances for workflowId
	 * 
	 * @param workflowId
	 * @return
	 */
	public List<FormInstanceWorkflowIdResponse> getFormInstancesForWorkflowId(String workflowId);

	FormInstancePreviewResponse getFormPreview(String formId) throws RecordNotFoundException;

}
