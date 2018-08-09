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
import org.springframework.web.bind.annotation.RestController;

import com.homegenius.form.dto.FormInstanceCreationRequest;
import com.homegenius.form.dto.FormInstancePreviewResponse;
import com.homegenius.form.dto.FormInstanceResponse;
import com.homegenius.form.dto.FormInstanceWorkflowIdResponse;
import com.homegenius.form.dto.FormResponse;
import com.homegenius.form.exception.RecordNotFoundException;
import com.homegenius.form.service.FormInstanceService;
import com.homegenius.form.validator.FormInstanceCreationRequestValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping ( "v1")
@Api ( value = "Form Instance APIs", description = "APIs for HomeGenius form Instances")
public class FormInstanceController
{

    @Autowired
    private FormInstanceService formInstanceService;

    @Autowired
    private FormInstanceCreationRequestValidator formInstanceCreationRequestValidator;

    /**
     * Static logger for the class
     */
    private final Logger log = LoggerFactory.getLogger( FormInstanceController.class );


    @InitBinder ( "formInstanceCreationRequest")
    public void formInstanceCreationRequestValidator( WebDataBinder binder )
    {
        binder.setValidator( formInstanceCreationRequestValidator );
    }


    @RequestMapping ( value = "/instance", method = RequestMethod.POST)
    @ApiOperation ( value = "Create a form instance", response = FormInstanceResponse.class)
    @ApiResponses ( value = { @ApiResponse ( code = 200, message = "Successfully created the form instance") })
    public ResponseEntity<?> createFormInstance( @Valid @RequestBody FormInstanceCreationRequest formInstanceCreationRequest )
    {
        log.info( "Creating a form instance" );
        FormInstanceResponse formInstanceResponse = formInstanceService.createFormInstance( formInstanceCreationRequest );
        return new ResponseEntity<>( formInstanceResponse, HttpStatus.OK );

    }


    @RequestMapping ( value = "/instance/{workflowId}/workflow", method = RequestMethod.GET)
    @ApiOperation ( value = "Fetch Form Instances For Workflow ID", response = FormInstanceWorkflowIdResponse.class, responseContainer = "List")
    @ApiResponses ( value = { @ApiResponse ( code = 200, message = "Successfully fetched Form Instance") })
    public ResponseEntity<?> getFormInstancesForWorkflowId( @PathVariable String workflowId )
    {
        log.info( "Fetching form instances for specified workflowId" );
        List<FormInstanceWorkflowIdResponse> formInstanceWorkflowIdResponseList = formInstanceService
            .getFormInstancesForWorkflowId( workflowId );
        return new ResponseEntity<>( formInstanceWorkflowIdResponseList, HttpStatus.OK );

    }


    @RequestMapping ( value = "/instance/{id}/preview", method = RequestMethod.GET)
    public ResponseEntity<?> getFormInstancesPreview( @PathVariable ( "id") String id ) throws RecordNotFoundException
    {
        log.info( "Fetching form instance preview based on formId" );
        FormInstancePreviewResponse formResponse = formInstanceService.getFormPreview( id );
        return new ResponseEntity<>( formResponse, HttpStatus.OK );
    }
}
