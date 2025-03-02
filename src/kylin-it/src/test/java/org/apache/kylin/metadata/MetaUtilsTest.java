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
package org.apache.kylin.metadata;

import org.apache.kylin.common.util.NLocalFileMetadataTestCase;
import org.apache.kylin.metadata.filter.function.LikeMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.val;


public class MetaUtilsTest extends NLocalFileMetadataTestCase {

    @Before
    public void setup() throws Exception {
        createTestMetadata();
    }

    @After
    public void cleanup() {
        cleanupTestMetadata();
    }

    @Test
    public void LikeMatchersTest() {
        String likePattern = "abc\\_\\%%";
        String target = "abc_%abc";
        val matcher = new LikeMatchers.DefaultLikeMatcher(likePattern, "\\");
        Assert.assertTrue(matcher.matches(target));
    }
}
