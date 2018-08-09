package com.homegenius.form.dto;

import java.io.Serializable;

import com.homegenius.form.enums.StorageType;

public class FileStorageDomain implements Serializable{

	private static final long serialVersionUID = 1L;
	private String storageKey;
	private StorageType storageType;
	private String link;

	public String getStorageKey() {
		return storageKey;
	}

	public void setStorageKey(String storageKey) {
		this.storageKey = storageKey;
	}

	public StorageType getStorageType() {
		return storageType;
	}

	public void setStorageType(StorageType storageType) {
		this.storageType = storageType;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "FileStorageDomain [storageKey=" + storageKey + ", storageType=" + storageType + ", link=" + link + "]";
	}

}
