/*
 * The MIT License
 *
 * Copyright 2018 Intuit Inc.
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
package com.intuit.karate.core;

import com.intuit.karate.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author pthomas3
 */
public class FeatureResult {
    
    private int line;    
    private String uri;
    private String id;
    private String name;
    private String description;
    private String keyword = "Feature";
    private List<ResultElement> elements = new ArrayList();
    private List<TagResult> tags = Collections.EMPTY_LIST;
    
    public FeatureResult(Feature feature) {
        line = feature.getLine();
        uri = feature.getRelativePath();
        name = uri;
        id = StringUtils.toIdString(feature.getName());
        String temp = feature.getName() == null ? "" : feature.getName();
        if (feature.getDescription() != null) {
            temp = temp + "\n" + feature.getDescription();
        }
        description = temp.trim();
        List<Tag> list = feature.getTags();
        if (list != null) {
            tags = new ArrayList(list.size());
            for (Tag tag : list) {
                tags.add(new TagResult(tag));                
            }
        }
    }    

    public List<TagResult> getTags() {
        return tags;
    }

    public void setTags(List<TagResult> tags) {
        this.tags = tags;
    }
    
    public void addResult(ResultElement element) {
        elements.add(element);
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<ResultElement> getElements() {
        return elements;
    }

    public void setElements(List<ResultElement> elements) {
        this.elements = elements;
    }    
    
}
