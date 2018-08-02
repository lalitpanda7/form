package com.homegenius.form.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.homegenius.form.bean.Form;

@Repository
public interface FormRepository extends ElasticsearchRepository<Form, String> {

	public List<Form> getFormByMlsList(String mlsList);

	public List<Form> getFormByFormCategoryList(String formCategoryList);
}