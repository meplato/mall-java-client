/*
 * Copyright (c) 2015-2019 Meplato GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.meplato.mall;

import com.google.gson.JsonParseException;
import com.meplato.mall.catalogs.Service;
import org.apache.http.HttpException;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * ServiceExceptionTest tests exceptions that may happen when talking to the API.
 */
public class ServiceExceptionTest extends BaseTest {
    @Test
    public void testGracefullyHandleHTML() {
        try {
            // Try to parse a response that is invalid JSON, as could happen with a misconfigured LB
            Response response = this.mockResponseFromFile("nginx_html_error");
            ServiceException e = ServiceException.fromResponse(response);
            assertNotNull(e);
            assertEquals("Request failed with status code 404", e.getMessage());
            assertNull(e.getError());
            assertNotNull(e.getCause());
        } catch (ServiceException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        } catch (HttpException e) {
            fail(e.getMessage());
        }
    }
}
