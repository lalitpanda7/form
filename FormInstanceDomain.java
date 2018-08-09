package com.homegenius.form.dto;

import java.io.Serializable;
import java.util.Date;

import com.homegenius.form.bean.FileStorage;
import com.homegenius.form.bean.FormInstanceDetail;
import com.homegenius.form.bean.FormMetadata;


public class FormInstanceDomain implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private String parentFormId;
    private String workflowId;
    private String taskId;
    private Date dueDate;
    private String previewLink;
    private FileStorage fileStorage;
    private FormMetadata formMetadata;
    private FormInstanceDetail formInstanceDetail;
    private boolean isDeleted;
    private String createdBy;
    private String updatedBy;


    public String getName()
    {
        return name;
    }


    public void setName( String name )
    {
        this.name = name;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription( String description )
    {
        this.description = description;
    }


    public String getParentFormId()
    {
        return parentFormId;
    }


    public void setParentFormId( String parentFormId )
    {
        this.parentFormId = parentFormId;
    }


    public String getWorkflowId()
    {
        return workflowId;
    }


    public void setWorkflowId( String workflowId )
    {
        this.workflowId = workflowId;
    }


    public String getTaskId()
    {
        return taskId;
    }


    public void setTaskId( String taskId )
    {
        this.taskId = taskId;
    }


    public Date getDueDate()
    {
        return dueDate;
    }


    public void setDueDate( Date dueDate )
    {
        this.dueDate = dueDate;
    }


    public String getPreviewLink()
    {
        return previewLink;
    }


    public void setPreviewLink( String previewLink )
    {
        this.previewLink = previewLink;
    }


    public FileStorage getFileStorage()
    {
        return fileStorage;
    }


    public void setFileStorage( FileStorage fileStorage )
    {
        this.fileStorage = fileStorage;
    }


    public FormMetadata getFormMetadata()
    {
        return formMetadata;
    }


    public void setFormMetadata( FormMetadata formMetadata )
    {
        this.formMetadata = formMetadata;
    }


    public FormInstanceDetail getFormInstanceDetail()
    {
        return formInstanceDetail;
    }


    public void setFormInstanceDetail( FormInstanceDetail formInstanceDetail )
    {
        this.formInstanceDetail = formInstanceDetail;
    }


    public boolean isDeleted()
    {
        return isDeleted;
    }


    public void setDeleted( boolean isDeleted )
    {
        this.isDeleted = isDeleted;
    }


    public String getCreatedBy()
    {
        return createdBy;
    }


    public void setCreatedBy( String createdBy )
    {
        this.createdBy = createdBy;
    }


    public String getUpdatedBy()
    {
        return updatedBy;
    }


    public void setUpdatedBy( String updatedBy )
    {
        this.updatedBy = updatedBy;
    }


    @Override
    public String toString()
    {
        return "FormInstanceDomain [name=" + name + ", description=" + description + ", parentFormId=" + parentFormId
            + ", workflowId=" + workflowId + ", taskId=" + taskId + ", dueDate=" + dueDate + ", previewLink=" + previewLink
            + ", fileStorage=" + fileStorage + ", formMetadata=" + formMetadata + ", formInstanceDetail=" + formInstanceDetail
            + ", isDeleted=" + isDeleted + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
    }

}
