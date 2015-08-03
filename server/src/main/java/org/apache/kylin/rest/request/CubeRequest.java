/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.apache.kylin.rest.request;

public class CubeRequest {

    private String uuid;
    private String cubeName;
    private String cubeDescData;
    private String modelDescData;
    private boolean successful;
    private String message;
    private String cubeDescName;
    private String project;
    private long retentionRange;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return the cubeDescName
     */
    public String getCubeDescName() {
        return cubeDescName;
    }

    /**
     * @param cubeDescName
     *            the cubeDescName to set
     */
    public void setCubeDescName(String cubeDescName) {
        this.cubeDescName = cubeDescName;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the status
     */
    public boolean getSuccessful() {
        return successful;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setSuccessful(boolean status) {
        this.successful = status;
    }

    public CubeRequest() {
    }

    public CubeRequest(long id, String cubeName, String cubeDescData, String modelDescData) {
        this.cubeName = cubeName;
        this.cubeDescData = cubeDescData;
        this.modelDescData = modelDescData;
    }

    public String getCubeDescData() {
        return cubeDescData;
    }

    public void setCubeDescData(String cubeDescData) {
        this.cubeDescData = cubeDescData;
    }

    public String getModelDescData() {
        return modelDescData;
    }

    public void setModelDescData(String modelDescData) {
        this.modelDescData = modelDescData;
    }

    /**
     * @return the cubeDescName
     */
    public String getCubeName() {
        return cubeName;
    }

    /**
     * @param cubeName
     *            the cubeDescName to set
     */
    public void setCubeName(String cubeName) {
        this.cubeName = cubeName;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public long getRetentionRange() {
        return retentionRange;
    }

    public void setRetentionRange(long retentionRange) {
        this.retentionRange = retentionRange;
    }
}
