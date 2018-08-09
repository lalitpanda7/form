package com.homegenius.form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.homegenius.form.bean.Form;
import com.homegenius.form.dto.FormSearchResponse;
import com.homegenius.form.exception.InvalidInputException;
import com.homegenius.form.exception.RecordNotFoundException;
import com.homegenius.form.repository.FormRepository;
import com.homegenius.form.service.FormService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FormRepositorySearchTests {
	
	/**
	 * Static logger for the class
	 */
	private final Logger log = LoggerFactory.getLogger(FormRepositorySearchTests.class);
	
	@Autowired
	private FormRepository formRepository;
	@Autowired
	private FormService formService;
	@Test
	public void testFormCreation() throws RecordNotFoundException, InvalidInputException {
		log.info("Inside testFormSearch ");

		Form form0=new Form();
		Form form1=new Form();
		
		//form.add(new Form());
		//form.add(new Form());
		List<String> mlsList=new ArrayList<String>(Arrays.asList("1212112"));
		List<String> Category=new ArrayList<String>(Arrays.asList("ffffffff"));
		List<String> mlsList1=new ArrayList<String>(Arrays.asList("1212112"));
		List<String> Category1=new ArrayList<String>(Arrays.asList("ffffffff"));
		form0.setId(UUID.randomUUID().toString());
//		form.setDeleted(false);
		form0.setDescription("TREC No. 52-1");
		form0.setName("Terminate Due to Lender's Appraisal123");
//		form.setReadOnly(false);
		form0.setMlsList(mlsList1);
		form0.setFormCategoryList(Category1);
		form0.setPreviewLink("https://slack.com/your-workspaces");
		this.formRepository.save(form0);
		log.info("Saved form with id:" +form0.getId());
		
		//Optional<Form> testForm = this.formRepository.findById(form.getId());
		form1.setId(UUID.randomUUID().toString());
//		form.setDeleted(false);
		form1.setDescription("TREC No. 52-165");
		form1.setName("Terminate Due to Lender's Appraisal12365");
//		form.setReadOnly(false);
		form1.setMlsList(mlsList);
		form1.setFormCategoryList(Category);
		form1.setPreviewLink("https://slack.com/your-workspaces");
		this.formRepository.save(form1);
		log.info("Saved form with id:" +form1.getId());
		
		
		List<FormSearchResponse> testForm = new ArrayList<FormSearchResponse>();
		testForm=formService.SearchForm(form0.getDescription(),form0.getFormCategoryList().get(0),form0.getMlsList().get(0));
		this.formRepository.deleteById(form0.getId());
		this.formRepository.deleteById(form1.getId());
		System.out.println(testForm.size());
		//Assert.assertNotNull(testForm.get());
		Assert.assertEquals(testForm.get(0).getName(), "Terminate Due to Lender's Appraisal123");
		Assert.assertEquals(testForm.get(0).getDescription(), "TREC No. 52-1");
		Assert.assertEquals(testForm.get(0).getId(),form0.getId());
		Assert.assertEquals(testForm.get(0).getPreviewLink(), "https://slack.com/your-workspaces");
//		this.formRepository.deleteById(form0.getId());
//		this.formRepository.deleteById(form1.getId());
		System.out.println(testForm.size());
		log.info("Removed form with id:" +form0.getId());
		
		log.info("Inside testFormSearch() End");
	}

}