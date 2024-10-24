/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.flowable.cmmn.rest.service.api.history.planitem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.flowable.cmmn.rest.service.api.engine.variable.RestVariable;
import org.flowable.common.rest.util.DateToStringSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Dennis Federico
 * @author Filip Hrisafov
 */
public class HistoricPlanItemInstanceResponse {

    protected String id;
    protected String name;
    protected String state;
    protected String caseDefinitionId;
    protected String derivedCaseDefinitionId;
    protected String caseInstanceId;
    protected String stageInstanceId;
    protected boolean stage;
    protected String elementId;
    protected String planItemDefinitionId;
    protected String planItemDefinitionType;
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    protected Date createTime;
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    protected Date lastAvailableTime;
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    protected Date lastEnabledTime;
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    protected Date lastDisabledTime;
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    protected Date lastStartedTime;
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    protected Date lastSuspendedTime;
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    protected Date completedTime;
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    protected Date occurredTime;
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    protected Date terminatedTime;
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    protected Date exitTime;
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    protected Date endedTime;
    @JsonSerialize(using = DateToStringSerializer.class, as = Date.class)
    protected Date lastUpdatedTime;
    protected String startUserId;
    protected String assignee;
    protected String completedBy;
    protected String referenceId;
    protected String referenceType;
    protected String entryCriterionId;
    protected String exitCriterionId;
    protected String formKey;
    protected String extraValue;
    protected boolean showInOverview;
    protected String tenantId;
    protected String url;
    protected String caseInstanceUrl;
    protected String caseDefinitionUrl;
    protected String derivedCaseDefinitionUrl;
    protected String stageInstanceUrl;
    protected List<RestVariable> localVariables = new ArrayList<>();

    @ApiModelProperty(example = "5")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ApiModelProperty(example = "myPlanItemName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(example = "completed")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @ApiModelProperty(example = "myCaseId%3A1%3A4")
    public String getCaseDefinitionId() {
        return caseDefinitionId;
    }

    public void setCaseDefinitionId(String caseDefinitionId) {
        this.caseDefinitionId = caseDefinitionId;
    }

    public String getDerivedCaseDefinitionId() {
        return derivedCaseDefinitionId;
    }

    public void setDerivedCaseDefinitionId(String derivedCaseDefinitionId) {
        this.derivedCaseDefinitionId = derivedCaseDefinitionId;
    }

    @ApiModelProperty(example = "12345")
    public String getCaseInstanceId() {
        return caseInstanceId;
    }

    public void setCaseInstanceId(String caseInstanceId) {
        this.caseInstanceId = caseInstanceId;
    }

    @ApiModelProperty(example = "stageId")
    public String getStageInstanceId() {
        return stageInstanceId;
    }

    public void setStageInstanceId(String stageInstanceId) {
        this.stageInstanceId = stageInstanceId;
    }

    @ApiModelProperty(example = "true")
    public boolean isStage() {
        return stage;
    }

    public void setStage(boolean stage) {
        this.stage = stage;
    }

    @ApiModelProperty(example = "someElementId")
    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    @ApiModelProperty(example = "someId")
    public String getPlanItemDefinitionId() {
        return planItemDefinitionId;
    }

    public void setPlanItemDefinitionId(String planItemDefinitionId) {
        this.planItemDefinitionId = planItemDefinitionId;
    }

    @ApiModelProperty(example = "timerEventListener")
    public String getPlanItemDefinitionType() {
        return planItemDefinitionType;
    }

    public void setPlanItemDefinitionType(String planItemDefinitionType) {
        this.planItemDefinitionType = planItemDefinitionType;
    }

    @ApiModelProperty(example = "2013-04-17T10:17:43.902+0000")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @ApiModelProperty(example = "2013-04-17T10:17:43.902+0000")
    public Date getLastAvailableTime() {
        return lastAvailableTime;
    }

    public void setLastAvailableTime(Date lastAvailableTime) {
        this.lastAvailableTime = lastAvailableTime;
    }

    @ApiModelProperty(example = "2013-04-17T10:17:43.902+0000")
    public Date getLastEnabledTime() {
        return lastEnabledTime;
    }

    public void setLastEnabledTime(Date lastEnabledTime) {
        this.lastEnabledTime = lastEnabledTime;
    }

    @ApiModelProperty(example = "2013-04-17T10:17:43.902+0000")
    public Date getLastDisabledTime() {
        return lastDisabledTime;
    }

    public void setLastDisabledTime(Date lastDisabledTime) {
        this.lastDisabledTime = lastDisabledTime;
    }

    @ApiModelProperty(example = "2013-04-17T10:17:43.902+0000")
    public Date getLastStartedTime() {
        return lastStartedTime;
    }

    public void setLastStartedTime(Date lastStartedTime) {
        this.lastStartedTime = lastStartedTime;
    }

    @ApiModelProperty(example = "2013-04-17T10:17:43.902+0000")
    public Date getLastSuspendedTime() {
        return lastSuspendedTime;
    }

    public void setLastSuspendedTime(Date lastSuspendedTime) {
        this.lastSuspendedTime = lastSuspendedTime;
    }

    @ApiModelProperty(example = "2013-04-17T10:17:43.902+0000")
    public Date getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(Date completedTime) {
        this.completedTime = completedTime;
    }

    @ApiModelProperty(example = "2013-04-17T10:17:43.902+0000")
    public Date getOccurredTime() {
        return occurredTime;
    }

    public void setOccurredTime(Date occurredTime) {
        this.occurredTime = occurredTime;
    }

    @ApiModelProperty(example = "2013-04-17T10:17:43.902+0000")
    public Date getTerminatedTime() {
        return terminatedTime;
    }

    public void setTerminatedTime(Date terminatedTime) {
        this.terminatedTime = terminatedTime;
    }

    @ApiModelProperty(example = "2013-04-17T10:17:43.902+0000")
    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    @ApiModelProperty(example = "2013-04-17T10:17:43.902+0000")
    public Date getEndedTime() {
        return endedTime;
    }

    public void setEndedTime(Date endedTime) {
        this.endedTime = endedTime;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    @ApiModelProperty(example = "kermit")
    public String getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(String completedBy) {
        this.completedBy = completedBy;
    }

    @ApiModelProperty(example = "referenceId")
    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    @ApiModelProperty(example = "referenceType")
    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public String getEntryCriterionId() {
        return entryCriterionId;
    }

    public void setEntryCriterionId(String entryCriterionId) {
        this.entryCriterionId = entryCriterionId;
    }

    public String getExitCriterionId() {
        return exitCriterionId;
    }

    public void setExitCriterionId(String exitCriterionId) {
        this.exitCriterionId = exitCriterionId;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getExtraValue() {
        return extraValue;
    }

    public void setExtraValue(String extraValue) {
        this.extraValue = extraValue;
    }

    public boolean isShowInOverview() {
        return showInOverview;
    }

    public void setShowInOverview(boolean showInOverview) {
        this.showInOverview = showInOverview;
    }

    @ApiModelProperty(example = "null")
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @ApiModelProperty(example = "http://localhost:8182/cmmn-history/historic-planitem-instances/5")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ApiModelProperty(example = "http://localhost:8182/cmmn-history/historic-case-instances/12345")
    public String getCaseInstanceUrl() {
        return caseInstanceUrl;
    }

    public void setCaseInstanceUrl(String caseInstanceUrl) {
        this.caseInstanceUrl = caseInstanceUrl;
    }

    @ApiModelProperty(example = "http://localhost:8182/cmmn-repository/case-definitions/myCaseId%3A1%3A4")
    public String getCaseDefinitionUrl() {
        return caseDefinitionUrl;
    }

    public void setCaseDefinitionUrl(String caseDefinitionUrl) {
        this.caseDefinitionUrl = caseDefinitionUrl;
    }

    public String getDerivedCaseDefinitionUrl() {
        return derivedCaseDefinitionUrl;
    }

    public void setDerivedCaseDefinitionUrl(String derivedCaseDefinitionUrl) {
        this.derivedCaseDefinitionUrl = derivedCaseDefinitionUrl;
    }

    public String getStageInstanceUrl() {
        return stageInstanceUrl;
    }

    public void setStageInstanceUrl(String stageInstanceUrl) {
        this.stageInstanceUrl = stageInstanceUrl;
    }

    public void setLocalVariables(List<RestVariable> localVariables){
        this.localVariables = localVariables;
    }

    public List<RestVariable> getLocalVariables() {
        return localVariables;
    }

    public void addLocalVariable(RestVariable restVariable) {
        localVariables.add(restVariable);
    }
}
