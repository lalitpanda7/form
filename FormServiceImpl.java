package com.homegenius.form.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homegenius.form.bean.Form;
import com.homegenius.form.controller.ErrorCodes;
import com.homegenius.form.dto.FormCreationRequest;
import com.homegenius.form.dto.FormDomain;
import com.homegenius.form.dto.FormResponse;
import com.homegenius.form.dto.FormUpdationRequest;
import com.homegenius.form.dto.User;
import com.homegenius.form.exception.InvalidInputException;
import com.homegenius.form.exception.RecordAlreadyExistsException;
import com.homegenius.form.exception.RecordNotFoundException;
import com.homegenius.form.repository.FormRepository;
import com.homegenius.form.service.FormService;

@Service
public class FormServiceImpl implements FormService {

	/**
	 * Static logger for the class
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FormRepository formRepository;

	@Override
	public Form getFormById(String id) {
		Form form = null;
		if (id != null) {
			final Optional<Form> result = formRepository.findById(id);
			if (result.isPresent())
				form = result.get();
		} else {
			log.info("form id is null");
		}
		return form;
	}

	@Override
	public boolean deleteFormById(String id) {
		log.info("Method deleteFormById started for id", id);
		Form form = null;
		if (id != null) {
			form = getFormById(id);
			if (form != null) {
				formRepository.deleteById(id);
				return true;
			}
		} else {
			log.info("Form is null");
		}
		log.info("Method deleteFormById completed");
		return false;
	}

	@Override
	public Form createForm(FormDomain formDomain, User user)
			throws InvalidInputException, RecordAlreadyExistsException {
		log.info("Method createForm started");
		if (formDomain == null) {
			throw new InvalidInputException(ErrorCodes.INVALID_INPUT, "Invalid input parameters");
		}

		Form form = new Form();
		form.setId(UUID.randomUUID().toString());
		form.setCreatedBy(user.getFullName());
		form.setCreatedOn(new DateTime());
		form.setUpdatedBy(user.getFullName());
		form.setUpdatedOn(new DateTime());
		form.setDeleted(formDomain.isDeleted());
		form.setDescription(formDomain.getDescription());
		form.setFileStorage(formDomain.getFileStorage());
		form.setFormCategoryList(formDomain.getFormCategoryList());
		form.setFormMetadata(formDomain.getFormMetadata());
		form.setFormStatus(formDomain.getFormStatus());
		form.setMlsList(formDomain.getMlsList());
		form.setName(formDomain.getName());
		form.setReadOnly(formDomain.isReadOnly());

		List<Form> formList = (List<Form>) formRepository.findAll();
		if (formList != null && !formList.isEmpty()) {
			for (Form formIteration : formList) {
				if (formIteration.equals(form)) {
					throw new RecordAlreadyExistsException(ErrorCodes.RECORD_ALREADY_EXISTS,
							"This Record already exists");
				}
			}
		}
		formRepository.save(form);

		log.info("Method createForm completed");
		return form;
	}

	@Override
	public Form updateForm(Form formUpdate, User user)
			throws InvalidInputException, RecordNotFoundException, RecordAlreadyExistsException {
		log.info("Method updateForm started");
		if (formUpdate == null) {
			throw new InvalidInputException(ErrorCodes.INVALID_INPUT, "Invalid input parameters");
		}

		Form form = null;
		form = getFormById(formUpdate.getId());
		if (form == null) {
			throw new RecordNotFoundException(ErrorCodes.RECORD_NOT_FOUND, "Specified record is not found");
		}
		form.setUpdatedBy(user.getFullName());
		form.setUpdatedOn(new DateTime());
		form.setDeleted(formUpdate.isDeleted());
		form.setDescription(formUpdate.getDescription());
		form.setFileStorage(formUpdate.getFileStorage());
		form.setFormCategoryList(formUpdate.getFormCategoryList());
		form.setFormMetadata(formUpdate.getFormMetadata());
		form.setFormStatus(formUpdate.getFormStatus());
		form.setMlsList(formUpdate.getMlsList());
		form.setName(formUpdate.getName());
		form.setReadOnly(formUpdate.isReadOnly());

		List<Form> formList = (List<Form>) formRepository.findAll();
		if (formList != null && !formList.isEmpty()) {
			for (Form formIteration : formList) {
				if (formIteration.equals(form)) {
					throw new RecordAlreadyExistsException(ErrorCodes.RECORD_ALREADY_EXISTS,
							"This Record already exists");
				}
			}
		}
		formRepository.save(form);

		log.info("Method updateForm completed");
		return form;
	}

	@Override
	public List<FormResponse> getPaginatedFormsList(int offset, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormResponse getFormByFormId(String formId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormResponse createForm(FormCreationRequest formCreationRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormResponse updateFormMapping(FormUpdationRequest formUpdationRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Form> SearchAllForm() {
		// TODO Auto-generated method stub
		List<Form> form= new ArrayList<Form>();
		formRepository.findAll().forEach(form::add);
		return form;
	}

	@Override
	public List<Form> SearchFormByMlsList(String mls) {
		List<Form> form= new ArrayList<Form>();
		form=formRepository.getFormByMlsList(mls);
		return form;
	}

	@Override
	public List<Form> SearchFormByCategoryList(String category) {
		List<Form> form= new ArrayList<Form>();
		form=formRepository.getFormByFormCategoryList(category);
		return form;
		}
	

}
