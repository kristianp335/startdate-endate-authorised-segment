package com.liferay.kris.publishing.segment;

import com.liferay.segments.context.Context;
import com.liferay.segments.context.contributor.RequestContextContributor;

import java.time.ZonedDateTime;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author kpatefield
 */
@Component(
		immediate = true,
		property = {
			"request.context.contributor.key=" + StartDateContextContributer.KEY,
			"request.context.contributor.type=date"
		},
		service = RequestContextContributor.class
)
public class StartDateContextContributer implements RequestContextContributor {
	
	public static final String KEY = "startdate";

	@Override
	public void contribute(Context context, HttpServletRequest httpServletRequest) {		
	
		
		ZonedDateTime publishStartDate = ZonedDateTime.now();
		
		context.put(KEY, publishStartDate);
		
	}

}