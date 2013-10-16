/*
 * Copyright 2013 Lars Werkman
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
package com.larswerkman.licenseview;

import java.io.IOException;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class LicenseView extends ScrollView {

	LinearLayout mContainer;

	public LicenseView(Context context) {
		super(context);
		init();
	}

	public LicenseView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public LicenseView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		mContainer = new LinearLayout(getContext());
		mContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		mContainer.setOrientation(LinearLayout.VERTICAL);
		addView(mContainer);
	}

	public void setLicenses(int id) throws NotFoundException,
			XmlPullParserException, IOException {
		List<License> licenses = ParseLicenseXml.Parse(getResources()
				.getXml(id));
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View child;
		TextView title;
		TextView name;
		TextView license;

		for (License l : licenses) {
			child = inflater.inflate(R.layout.license_layout, null);
			title = (TextView) child.findViewById(R.id.license_title);
			name = (TextView) child.findViewById(R.id.license_name);
			license = (TextView) child.findViewById(R.id.license_license);

			title.setText(getContext().getResources().getString(
					l.getType() == License.TYPE_FILE ? R.string.file
							: R.string.software));
			name.setText(getContext().getResources().getString(R.string.bullet)
					+ l.getName());
			license.setText(l.getLicense());
			mContainer.addView(child);
		}

	}

}
