/*
 * The MIT License
 *
 * Copyright 2019 Intuit Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.intuit.karate.job;

import com.intuit.karate.core.Scenario;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pthomas3
 */
public interface JobConfig {

    String getHost();

    int getPort();

    default String getSourcePath() {
        return "";
    }

    default String getReportPath() {
        return null;
    }

    void startExecutors(String jobId, String jobUrl);

    Map<String, String> getEnvironment();

    List<JobCommand> getStartupCommands();

    default List<JobCommand> getShutdownCommands() {
        return Collections.EMPTY_LIST;
    }

    List<JobCommand> getMainCommands(Scenario scenario, JobContext ctx);

    default List<JobCommand> getPreCommands(Scenario scenario, JobContext ctx) {
        return Collections.EMPTY_LIST;
    }

    default List<JobCommand> getPostCommands(Scenario scenario, JobContext ctx) {
        return Collections.EMPTY_LIST;
    }

}
