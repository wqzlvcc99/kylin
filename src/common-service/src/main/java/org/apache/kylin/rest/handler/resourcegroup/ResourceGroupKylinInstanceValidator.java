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

package org.apache.kylin.rest.handler.resourcegroup;

import static org.apache.kylin.common.exception.code.ErrorCodeServer.REPEATED_INSTANCE;
import static org.apache.kylin.common.exception.code.ErrorCodeServer.REQUEST_PARAMETER_EMPTY_OR_VALUE_EMPTY;
import static org.apache.kylin.common.exception.code.ErrorCodeServer.RESOURCE_GROUP_ID_NOT_FOUND_IN_INSTANCE;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.kylin.common.exception.KylinException;
import org.apache.kylin.metadata.resourcegroup.KylinInstance;
import org.apache.kylin.metadata.resourcegroup.ResourceGroupEntity;
import org.apache.kylin.rest.request.resourecegroup.ResourceGroupRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import org.apache.kylin.guava30.shaded.common.collect.Sets;

import lombok.val;

@Order(400)
@Component
public class ResourceGroupKylinInstanceValidator implements IResourceGroupRequestValidator {
    @Override
    public void validate(ResourceGroupRequest request) {
        if (!request.isResourceGroupEnabled()) {
            return;
        }
        List<String> resourceGroups = request.getResourceGroupEntities().stream().map(ResourceGroupEntity::getId)
                .collect(Collectors.toList());
        List<KylinInstance> instances = request.getKylinInstances();
        for (KylinInstance instance : instances) {
            if (StringUtils.isBlank(instance.getInstance())) {
                throw new KylinException(REQUEST_PARAMETER_EMPTY_OR_VALUE_EMPTY, "instance");
            }
            if (StringUtils.isBlank(instance.getResourceGroupId())) {
                throw new KylinException(REQUEST_PARAMETER_EMPTY_OR_VALUE_EMPTY, "resource_group_id");
            }
            if (!resourceGroups.contains(instance.getResourceGroupId())) {
                throw new KylinException(RESOURCE_GROUP_ID_NOT_FOUND_IN_INSTANCE, instance.getResourceGroupId());
            }
        }
        val identities = instances.stream().map(KylinInstance::getInstance).collect(Collectors.toList());
        if (identities.size() != Sets.newHashSet(identities).size()) {
            throw new KylinException(REPEATED_INSTANCE);
        }
    }
}
