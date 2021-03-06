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

package org.openo.sdno.servicechaindriverservice.inf;

import org.openo.baseservice.remoteservice.exception.ServiceException;
import org.openo.sdno.overlayvpn.model.netmodel.servicechain.NetServiceChainPath;

/**
 * Interface of Service Function Path Service.<br>
 * 
 * @author
 * @version SDNO 0.5 2016-8-29
 */
public interface ServiceFuncPathService {

    /**
     * Create ServiceFunctionPath.<br>
     * 
     * @param path NetServiceChainPath data
     * @return NetServiceChainPath data created
     * @throws ServiceException when create NetServiceChainPath failed
     * @since SDNO 0.5
     */
    NetServiceChainPath create(NetServiceChainPath path) throws ServiceException;

    /**
     * Delete ServiceFunctionPath.<br>
     * 
     * @param uuid NetServiceChainPath UUID
     * @throws ServiceException when delete NetServiceChainPath failed
     * @since SDNO 0.5
     */
    void delete(String uuid) throws ServiceException;

}
