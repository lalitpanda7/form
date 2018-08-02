package com.homegenius.form.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.homegenius.form.bean.FormInstance;

@Repository
public interface FormInstanceRepository extends ElasticsearchRepository<FormInstance, String> {

}