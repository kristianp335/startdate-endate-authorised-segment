package com.liferay.kris.publishing.segment;

import com.liferay.segments.context.Context;

import java.time.ZonedDateTime;

import com.liferay.segments.context.contributor.RequestContextContributor;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author kpatefield
 */
@Component(
		immediate = true,
		property = {
			"request.context.contributor.key=" + EndDateContextContributer.KEY,
			"request.context.contributor.type=date"
		},
		service = RequestContextContributor.class
)
public class EndDateContextContributer implements RequestContextContributor {
	
	public static final String KEY = "enddate";

	@Override
	public void contribute(Context context, HttpServletRequest httpServletRequest) {
		
		ZonedDateTime publishEndDate = ZonedDateTime.now();
		
		context.put(KEY, publishEndDate);
		
	}

}