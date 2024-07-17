/*
 *  Copyright 1999-2021 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.order.business;

import com.alibaba.nacos.common.utils.UuidUtils;
import com.order.client.StockClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBizService {

    @Autowired StockClient stockClient;

    @GlobalTransactional(rollbackFor = Exception.class, timeoutMills = 6000000)
    public void testGlobalTransaction() {
        String code = UuidUtils.generateUuid().replace("-", "");
        stockClient.insert(code);
        stockClient.update(code);
    }
}
