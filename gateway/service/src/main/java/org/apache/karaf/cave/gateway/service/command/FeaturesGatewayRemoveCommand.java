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
package org.apache.karaf.cave.gateway.service.command;

import org.apache.karaf.cave.gateway.FeaturesGatewayService;
import org.apache.karaf.cave.gateway.service.command.completers.FeaturesRepositoryUrlCompleter;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Completion;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

import java.util.List;

@Service
@Command(scope = "cave", name = "features-gateway-remove", description = "Remove features repository XML URLs from the gateway")
public class FeaturesGatewayRemoveCommand implements Action {

    @Reference
    private FeaturesGatewayService featuresGatewayService;

    @Argument(index = 0, name = "urls", description = "The features repository URLs to remove from the gateway", required = true, multiValued = true)
    @Completion(FeaturesRepositoryUrlCompleter.class)
    List<String> urls;

    @Override
    public Object execute() throws Exception {
        for (String url : urls) {
            featuresGatewayService.remove(url);
        }
        return null;
    }

}
