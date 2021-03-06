//
// JODConverter - Java OpenDocument Converter
// Copyright 2004-2012 Mirko Nasato and contributors
//
// JODConverter is Open Source software, you can redistribute it and/or
// modify it under either (at your option) of the following licenses
//
// 1. The GNU Lesser General Public License v3 (or later)
// -> http://www.gnu.org/licenses/lgpl-3.0.txt
// 2. The Apache License, Version 2.0
// -> http://www.apache.org/licenses/LICENSE-2.0.txt
//
package org.artofsolving.jodconverter.document;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains the required information used to deal with a specific document format .
 */
public class DocumentFormat {

    private String name;
    private String extension;
    private String mediaType;
    private DocumentFamily inputFamily;
    private Map<String, ?> loadProperties;
    private Map<DocumentFamily, Map<String, ?>> storePropertiesByFamily;

    /**
     * Creates a new document format with the specified name, extension and mime-type
     * 
     * @param name
     *            the name of the format.
     * @param extension
     *            the extension of the format.
     * @param mediaType
     *            the media type (mime type) of the format.
     */
    public DocumentFormat(String name, String extension, String mediaType) {

        this.name = name;
        this.extension = extension;
        this.mediaType = mediaType;
    }

    /**
     * Gets the extension associated with the format.
     * 
     * @return a string that represents an extension.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Gets the DocumentFamily of the document
     * 
     * @return the DocumentFamily of the document
     */
    public DocumentFamily getInputFamily() {
        return inputFamily;
    }

    /**
     * Gets the properties required to load(open) a document of this format.
     */
    public Map<String, ?> getLoadProperties() {
        return loadProperties;
    }

    /**
     * Gets the media (mime) type of the format.
     * 
     * @return a string that represents the media type.
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * Gets the name of the format.
     * 
     * @return a string that represents the name of the format.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the properties required to store(save) a document of this format to a document of the
     * specified family.
     */
    public Map<String, ?> getStoreProperties(DocumentFamily family) {
        if (storePropertiesByFamily == null) {
            return null;
        }
        return storePropertiesByFamily.get(family);
    }

    /**
     * Gets the properties required to store(save) a document of this format to a document of
     * supported families.
     */
    public Map<DocumentFamily, Map<String, ?>> getStorePropertiesByFamily() {
        return storePropertiesByFamily;
    }

    /**
     * Sets the DocumentFamily of the document
     * 
     * @return documentFamily the DocumentFamily of the document
     */
    public void setInputFamily(DocumentFamily documentFamily) {
        this.inputFamily = documentFamily;
    }

    /**
     * Sets the properties required to load(open) a document of this format.
     */
    public void setLoadProperties(Map<String, ?> loadProperties) {
        this.loadProperties = loadProperties;
    }

    /**
     * Sets the properties required to store(save) a document of this format to a document of
     * another family.
     */
    public void setStoreProperties(DocumentFamily family, Map<String, ?> storeProperties) {

        if (storePropertiesByFamily == null) {
            storePropertiesByFamily = new HashMap<DocumentFamily, Map<String, ?>>();
        }
        storePropertiesByFamily.put(family, storeProperties);
    }

    /**
     * Sets the properties required to store(save) a document of this format to a document of
     * supported families.
     */
    public void setStorePropertiesByFamily(Map<DocumentFamily, Map<String, ?>> storePropertiesByFamily) {

        this.storePropertiesByFamily = storePropertiesByFamily;
    }
}
