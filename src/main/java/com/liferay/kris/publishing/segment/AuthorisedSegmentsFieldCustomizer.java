/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.kris.publishing.segment;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.segments.field.customizer.SegmentsFieldCustomizer;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kris
 */
@Component(
	immediate = true,
	property = {
		"segments.field.customizer.entity.name=Context",
		"segments.field.customizer.key=" + AuthorisedSegmentsFieldCustomizer.KEY,
		"segments.field.customizer.priority:Integer=103"
	},
	service = SegmentsFieldCustomizer.class
)
public class AuthorisedSegmentsFieldCustomizer implements SegmentsFieldCustomizer {

	public static final String KEY = "authorisedboolean";

	@Override
	public List<String> getFieldNames() {
		return _fieldNames;
	}

	@Override
	public String getKey() {
		return KEY;
	}

	@Override
	public String getLabel(String fieldName, Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "authrised-field-label");
	}

	private static final List<String> _fieldNames = ListUtil.fromArray(
		new String[] {"authorisedboolean"});

}