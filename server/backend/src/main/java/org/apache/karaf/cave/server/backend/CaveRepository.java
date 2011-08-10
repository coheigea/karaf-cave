/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.cave.server.backend;

import java.io.InputStream;
import java.net.URL;

/**
 * Cave repository is a storage area where to upload artifacts.
 * It's already the basement of the OBR repository.xml metadata.
 */
public interface CaveRepository {

    /**
     * Get the name of the repository.
     *
     * @return the name of the repository
     */
    String getName();

    /**
     * Get the location (path) of this repository.
     *
     * @return the location of this repository.
     */
    String getLocation();

    /**
     * Upload an artifact from the given URL into the repository.
     * TODO use a Artifact object in place of raw artifact
     *
     * @param location  location of the artifact to upload in the repository.
     * @throws Exception in case of upload failure.
     */
    void upload(String location) throws Exception;

    /**
     * Upload an artifact from the given URL into the repository.
     * TODO use a Artifact object in place of raw artifact
     *
     * @param url the URL of the artifact.
     * @throws Exception in case of upload failure.
     */
    void upload(URL url) throws Exception;

    /**
     * Upload an artifact from a given stream into the repository.
     * TODO use a Artifact object in place of raw artifact
     *
     * @param stream the input stream of the artifact.
     * @throws Exception in case of upload failure.
     */
    void upload(InputStream stream) throws Exception;

    /**
     * Scan the whole repository, reading bundle MANIFEST, etc to update
     * or generate the OBR repository.xml.
     *
     * @throws Exception in case of scan failure.
     */
    void scan() throws Exception;

    /**
     * Register the repository into the OBR, giving all repository artifacts visible
     * for the OBR client.
     *
     * @throws Exception in case of register failure.
     */
    void register() throws Exception;

    /**
     * Destroy this repository, removing the contents of the repository and OBR metadata.
     *
     * @throws Exception in case of destroy failure.
     */
    void destroy() throws Exception;

}
