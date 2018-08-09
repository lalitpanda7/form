package com.homegenius.form.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homegenius.form.bean.FormInstance;
import com.homegenius.form.controller.ErrorCodes;
import com.homegenius.form.dto.FormInstanceCreationRequest;
import com.homegenius.form.dto.FormInstanceDomain;
import com.homegenius.form.dto.FormInstancePreviewResponse;
import com.homegenius.form.dto.FormInstanceResponse;
import com.homegenius.form.dto.FormInstanceWorkflowIdResponse;
import com.homegenius.form.exception.InvalidInputException;
import com.homegenius.form.exception.RecordAlreadyExistsException;
import com.homegenius.form.exception.RecordNotFoundException;
import com.homegenius.form.repository.FormInstanceRepository;
import com.homegenius.form.service.FormInstanceService;

@Service
public class FormInstanceServiceImpl implements FormInstanceService {

	/**
	 * Static logger for the class
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FormInstanceRepository formInstanceRepository;

	@Override
	public FormInstance getFormInstanceById(String id) {
		FormInstance formInstance = null;
		if (id != null) {
			final Optional<FormInstance> result = formInstanceRepository.findById(id);
			if (result.isPresent())
				formInstance = result.get();
		} else {
			log.info("FormInstance id is null");
		}

		return formInstance;
	}

	@Override
	public boolean deleteFormInstanceById(String id) {
		log.info("Method deleteFormInstanceById started for id", id);
		FormInstance formInstance = null;
		if (id != null) {
			formInstance = getFormInstanceById(id);
			if (formInstance != null) {
				formInstanceRepository.deleteById(id);
				return true;
			}
		} else {
			log.info("FormInstance is null");
		}
		log.info("Method deleteFormInstanceById completed");
		return false;
	}

	@Override
	public FormInstance createFormInstance(FormInstanceDomain formInstanceDomain) throws InvalidInputException {
		log.info("Method createFormInstance started");
		if (formInstanceDomain == null) {
			throw new InvalidInputException(ErrorCodes.INVALID_INPUT.getValue());
		}

		FormInstance formInstance = new FormInstance();
		formInstance.setId(UUID.randomUUID().toString());
		formInstance.setCreatedBy(formInstanceDomain.getCreatedBy());
		formInstance.setUpdatedBy(formInstanceDomain.getUpdatedBy());
		formInstance.setCreatedOn(new DateTime());
		formInstance.setUpdatedOn(new DateTime());
		formInstance.setDescription(formInstanceDomain.getDescription());
		formInstance.setDueDate(formInstanceDomain.getDueDate());
		formInstance.setFileStorage(formInstanceDomain.getFileStorage());
		formInstance.setFormInstanceDetail(formInstanceDomain.getFormInstanceDetail());
		formInstance.setFormMetadata(formInstanceDomain.getFormMetadata());
		formInstance.setName(formInstanceDomain.getName());
		formInstance.setParentFormId(formInstanceDomain.getParentFormId());
		formInstance.setPreviewLink(formInstanceDomain.getPreviewLink());
		formInstance.setTaskId(formInstanceDomain.getTaskId());
		formInstance.setWorkflowId(formInstanceDomain.getWorkflowId());
		formInstance.setDeleted(formInstanceDomain.isDeleted());
		formInstanceRepository.save(formInstance);

		log.info("Method createFormInstance completed");
		return formInstance;
	}

	@Override
	public FormInstance updateFormInstance(FormInstance formInstanceUpdate)
			throws InvalidInputException, RecordNotFoundException, RecordAlreadyExistsException {
		log.info("Method updateFormInstance started");
		if (formInstanceUpdate == null) {
			throw new InvalidInputException(ErrorCodes.INVALID_INPUT.getValue());
		}

		List<FormInstance> formInstanceList = (List<FormInstance>) formInstanceRepository.findAll();

		FormInstance formInstance = null;
		formInstance = getFormInstanceById(formInstanceUpdate.getId());
		if (formInstance == null) {
			throw new RecordNotFoundException(ErrorCodes.RECORD_NOT_FOUND.getValue());
		}
		formInstance.setUpdatedBy(formInstanceUpdate.getUpdatedBy());
		formInstance.setUpdatedOn(new DateTime());
		formInstance.setDescription(formInstanceUpdate.getDescription());
		formInstance.setDueDate(formInstanceUpdate.getDueDate());
		formInstance.setFileStorage(formInstanceUpdate.getFileStorage());
		formInstance.setFormInstanceDetail(formInstanceUpdate.getFormInstanceDetail());
		formInstance.setFormMetadata(formInstanceUpdate.getFormMetadata());
		formInstance.setName(formInstanceUpdate.getName());
		formInstance.setParentFormId(formInstanceUpdate.getParentFormId());
		formInstance.setPreviewLink(formInstanceUpdate.getPreviewLink());
		formInstance.setTaskId(formInstanceUpdate.getTaskId());
		formInstance.setWorkflowId(formInstanceUpdate.getWorkflowId());
		formInstance.setDeleted(formInstanceUpdate.isDeleted());

		if (formInstanceList != null && !formInstanceList.isEmpty()) {
			for (FormInstance formInstanceIteration : formInstanceList) {
				if (formInstanceIteration.equals(formInstance)) {
					throw new RecordAlreadyExistsException(ErrorCodes.RECORD_ALREADY_EXISTS.getValue());
				}
			}
		}
		formInstanceRepository.save(formInstance);

		log.info("Method updateFormInstance completed");
		return formInstance;
	}

	@Override
	public FormInstanceResponse createFormInstance(FormInstanceCreationRequest formInstanceCreationRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FormInstanceWorkflowIdResponse> getFormInstancesForWorkflowId(String workflowId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public FormInstancePreviewResponse getFormPreview(String formId) throws RecordNotFoundException {
		FormInstance formInstance=null;
		FormInstancePreviewResponse formInstancePreview=new FormInstancePreviewResponse();
//
//		formInstance = getFormInstanceById(formId);
		if (formId != null) {
			final Optional<FormInstance> result = formInstanceRepository.findById(formId);
			if (result.isPresent())
				formInstance = result.get();
		} else {
			log.info("FormInstance id is null");
		}
		if (formInstance == null) {
			throw new RecordNotFoundException(ErrorCodes.RECORD_NOT_FOUND.getValue());
		}
		try {
			BeanUtils.copyProperties(formInstancePreview,formInstance);
		} catch (InvocationTargetException|IllegalAccessException e) {
			e.printStackTrace();
		}
	return formInstancePreview;
		
	}
}
