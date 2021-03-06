/*
 * Copyright (C) 2016 - present Instructure, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.instructure.espresso;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static org.hamcrest.Matchers.allOf;

public class RootView implements ViewAction {
    private View rootView;

    @Override
    public Matcher<View> getConstraints() {
        return Matchers.allOf(ViewMatchers.isRoot());
    }

    @Override
    public String getDescription() {
        return "get root view";
    }

    @Override
    public void perform(UiController uiController, View view) {
        rootView = view;
    }

    public View getRootView() {
        return rootView;
    }

    public static View get() {
        RootView getRoot = new RootView();
        onView(allOf(isRoot())).perform(getRoot);
        return getRoot.getRootView();
    }
}
