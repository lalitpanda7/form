package com.homegenius.form.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homegenius.form.bean.Form;
import com.homegenius.form.dto.FormCreationRequest;
import com.homegenius.form.dto.FormResponse;
import com.homegenius.form.dto.FormSearchResponse;
import com.homegenius.form.dto.FormUpdationRequest;
import com.homegenius.form.exception.RecordNotFoundException;
import com.homegenius.form.service.FormService;
import com.homegenius.form.validator.FormCreationRequestValidator;
import com.homegenius.form.validator.FormUpdationRequestValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping ( "v1")
@Api ( value = "Form APIs", description = "APIs for HomeGenius forms")
public class FormController
{

    @Autowired
    private FormService formService;

    @Autowired
    private FormCreationRequestValidator formCreationRequestValidator;

    @Autowired
    private FormUpdationRequestValidator formUpdationRequestValidator;

    /**
     * Static logger for the class
     */
    private final Logger log = LoggerFactory.getLogger( FormController.class );


    @InitBinder ( "formCreationRequest")
    public void formCreationRequestValidator( WebDataBinder binder )
    {
        binder.setValidator( formCreationRequestValidator );
    }


    @InitBinder ( "formUpdationRequest")
    public void formUpdationRequestValidator( WebDataBinder binder )
    {
        binder.setValidator( formUpdationRequestValidator );
    }


    @RequestMapping ( value = "/form", method = RequestMethod.GET)
    @ApiOperation ( value = "Get paginated forms list", response = FormResponse.class, responseContainer = "List")
    @ApiResponses ( value = { @ApiResponse ( code = 200, message = "Successfully fetched the list of forms") })
    public ResponseEntity<?> getPaginatedFormsList( @RequestParam int offset, @RequestParam int size )
    {
        log.info( "Fetching the list of forms" );
        List<FormResponse> formResponseList = formService.getPaginatedFormsList( offset, size );
        return new ResponseEntity<>( formResponseList, HttpStatus.OK );
    }


    @RequestMapping ( value = "/form/{formId}", method = RequestMethod.GET)
    @ApiOperation ( value = "Get a form based on formId", response = FormResponse.class)
    @ApiResponses ( value = { @ApiResponse ( code = 200, message = "Successfully fetched the required form") })
    public ResponseEntity<?> getFormByFormId( @PathVariable String formId )
    {
        log.info( "Fetching the form based on formId" );
        FormResponse formResponse = formService.getFormByFormId( formId );
        return new ResponseEntity<>( formResponse, HttpStatus.OK );

    }


    @RequestMapping ( value = "/form", method = RequestMethod.POST)
    @ApiOperation ( value = "Create a form", response = FormResponse.class)
    @ApiResponses ( value = { @ApiResponse ( code = 200, message = "Successfully created a form") })
    public ResponseEntity<?> createForm( @Valid @RequestBody FormCreationRequest formCreationRequest )
    {
        log.info( "Creating a form" );
        FormResponse formResponse = formService.createForm( formCreationRequest );
        return new ResponseEntity<>( formResponse, HttpStatus.OK );

    }


    @RequestMapping ( value = "/mapping", method = RequestMethod.POST)
    @ApiOperation ( value = "Upadate a form", response = FormResponse.class)
    @ApiResponses ( value = { @ApiResponse ( code = 200, message = "Successfully updated the form") })
    public ResponseEntity<?> updateFormMapping( @Valid @RequestBody FormUpdationRequest formUpdationRequest )
    {
        log.info( "Updating a form" );
        FormResponse formResponse = formService.updateFormMapping( formUpdationRequest );
        return new ResponseEntity<>( formResponse, HttpStatus.OK );

    }


    @RequestMapping ( value = "/form/search", method = RequestMethod.GET)
    @ApiResponses ( value = { @ApiResponse ( code = 200, message = "Successfully search result form") })
    public ResponseEntity<?> searchForm( @RequestParam ( value = "searchText", required = false) String searchText,
        @RequestParam ( value = "category", required = false) String category,
        @RequestParam ( value = "mls", required = false) String mls )
    {
        log.info( "Search a form" );
        List<FormSearchResponse> formResponse = formService.SearchForm( searchText, category, mls );
        return new ResponseEntity<>( formResponse, HttpStatus.OK );
    }

}
