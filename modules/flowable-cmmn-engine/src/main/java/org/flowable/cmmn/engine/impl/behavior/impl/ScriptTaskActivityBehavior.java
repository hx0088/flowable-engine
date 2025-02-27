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
package org.flowable.cmmn.engine.impl.behavior.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.flowable.cmmn.engine.impl.persistence.entity.PlanItemInstanceEntity;
import org.flowable.cmmn.engine.impl.util.CommandContextUtil;
import org.flowable.cmmn.engine.impl.util.IOParameterUtil;
import org.flowable.cmmn.model.IOParameter;
import org.flowable.cmmn.model.ScriptServiceTask;
import org.flowable.common.engine.api.FlowableException;
import org.flowable.common.engine.api.variable.VariableContainer;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.common.engine.impl.scripting.ScriptEngineRequest;
import org.flowable.common.engine.impl.scripting.ScriptingEngines;
import org.flowable.common.engine.impl.variable.MapDelegateVariableContainer;

/**
 * Implementation of ScriptActivity CMMN 2.0 PlanItem.
 */
public class ScriptTaskActivityBehavior extends TaskActivityBehavior {

    protected ScriptServiceTask scriptTask;

    public ScriptTaskActivityBehavior(ScriptServiceTask scriptTask) {
        super(scriptTask.isBlocking(), scriptTask.getBlockingExpression());
        this.scriptTask = scriptTask;
    }

    @Override
    public void execute(CommandContext commandContext, PlanItemInstanceEntity planItemInstanceEntity) {
        ScriptingEngines scriptingEngines = CommandContextUtil.getCmmnEngineConfiguration().getScriptingEngines();
        if (scriptingEngines == null) {
            throw new FlowableException("Could not execute script task instance: no scripting engines found. For " + planItemInstanceEntity);
        }
        String scriptFormat = scriptTask.getScriptFormat() != null ? scriptTask.getScriptFormat() : ScriptingEngines.DEFAULT_SCRIPTING_LANGUAGE;
        
        try {
            ScriptEngineRequest.Builder request = ScriptEngineRequest.builder()
                    .language(scriptFormat)
                    .script(scriptTask.getScript())
                    .scopeContainer(planItemInstanceEntity)
                    .traceEnhancer(trace -> trace.addTraceTag("type", "scriptTask"));
            if (scriptTask.isAutoStoreVariables()) {
                request.storeScriptVariables();
            }

            List<IOParameter> inParameters = scriptTask.getInParameters();
            if (inParameters != null && !inParameters.isEmpty()) {
                MapDelegateVariableContainer inputVariableContainer = new MapDelegateVariableContainer();
                IOParameterUtil.processInParameters(inParameters, planItemInstanceEntity, inputVariableContainer,
                        CommandContextUtil.getExpressionManager(commandContext));
                request.inputVariableContainer(inputVariableContainer);
            } else if (scriptTask.isDoNotIncludeVariables()) {
                request.inputVariableContainer(VariableContainer.empty());
            }

            Object result = scriptingEngines.evaluate(request.build()).getResult();
            String resultVariableName = scriptTask.getResultVariableName();
            if (StringUtils.isNotBlank(scriptTask.getResultVariableName())) {
                planItemInstanceEntity.setVariable(resultVariableName.trim(), result);
            }
            CommandContextUtil.getAgenda(commandContext).planCompletePlanItemInstanceOperation(planItemInstanceEntity);

        } catch (FlowableException e) {
            Throwable rootCause = ExceptionUtils.getRootCause(e);
            if (rootCause instanceof FlowableException) {
                throw (FlowableException) rootCause;
            } else {
                throw e;
            }
        }
    }
}
