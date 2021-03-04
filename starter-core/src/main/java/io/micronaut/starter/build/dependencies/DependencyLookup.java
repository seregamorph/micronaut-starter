/*
 * Copyright 2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.starter.build.dependencies;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.core.order.Ordered;

import java.util.Objects;

public class DependencyLookup implements Ordered {

    @NonNull
    private Scope scope;

    @NonNull
    private String artifactId;

    private int order;

    public DependencyLookup(@NonNull Scope scope, @NonNull String artifactId) {
        this(scope, artifactId, 0);
    }

    public DependencyLookup(@NonNull Scope scope, @NonNull String artifactId, int order) {
        this.scope = scope;
        this.artifactId = artifactId;
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @NonNull
    public Scope getScope() {
        return scope;
    }

    public void setScope(@NonNull Scope scope) {
        this.scope = scope;
    }

    @NonNull
    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(@NonNull String artifactId) {
        this.artifactId = artifactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DependencyLookup that = (DependencyLookup) o;
        return scope.equals(that.scope) && artifactId.equals(that.artifactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scope, artifactId);
    }
}