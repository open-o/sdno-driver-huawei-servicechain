/*
 * Copyright 2016 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openo.sdno.servicechaindriverservice.test;

import org.junit.Test;
import org.openo.baseservice.remoteservice.exception.ServiceException;
import org.openo.sdno.exception.HttpCode;
import org.openo.sdno.testframework.checker.IChecker;
import org.openo.sdno.testframework.http.model.HttpModelUtils;
import org.openo.sdno.testframework.http.model.HttpRequest;
import org.openo.sdno.testframework.http.model.HttpResponse;
import org.openo.sdno.testframework.http.model.HttpRquestResponse;
import org.openo.sdno.testframework.replace.PathReplace;
import org.openo.sdno.testframework.testmanager.TestManager;

public class ITDeleteServiceFunctionPathFail extends TestManager {

    private static final String DELETE_SFP_TESTCASE =
            "src/integration-test/resources/testcase/DeleteServiceFunctionPath.json";

    @Test
    public void testSfpNeIdNotExist() throws ServiceException {

        HttpRquestResponse deleteHttpObject = HttpModelUtils.praseHttpRquestResponseFromFile(DELETE_SFP_TESTCASE);
        HttpRequest deleteRequest = deleteHttpObject.getRequest();

        deleteRequest.setUri(PathReplace.replaceUuid("service-function-path-id", deleteRequest.getUri(), "6586876877"));

        execTestCase(deleteRequest, new SuccessChecker());
    }

    @Test
    public void testSfpNeIdFormatWrong() throws ServiceException {
        HttpRquestResponse deleteHttpObject = HttpModelUtils.praseHttpRquestResponseFromFile(DELETE_SFP_TESTCASE);
        HttpRequest deleteRequest = deleteHttpObject.getRequest();

        deleteRequest
                .setUri(PathReplace.replaceUuid("service-function-path-id", deleteRequest.getUri(), "&884847%4*&"));

        execTestCase(deleteRequest, new FailChecker());
    }

    private class FailChecker implements IChecker {

        @Override
        public boolean check(HttpResponse response) {
            if(!HttpCode.isSucess(response.getStatus())) {
                return true;
            }
            return false;
        }

    }

    private class SuccessChecker implements IChecker {

        @Override
        public boolean check(HttpResponse response) {
            if(HttpCode.isSucess(response.getStatus())) {
                return true;
            }
            return false;
        }

    }

}
