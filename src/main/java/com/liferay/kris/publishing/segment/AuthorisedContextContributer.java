package com.liferay.kris.publishing.segment;

import com.liferay.segments.context.Context;
import com.liferay.segments.context.contributor.RequestContextContributor;
import javax.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Component;

/**
 * @author kpatefield
 */
@Component(
		immediate = true,
		property = {
			"request.context.contributor.key=" + AuthorisedContextContributer.KEY,
			"request.context.contributor.type=boolean"
		},
		service = RequestContextContributor.class
)
public class AuthorisedContextContributer implements RequestContextContributor {
	
	public static final String KEY = "authorisedboolean";

	@Override
	public void contribute(Context context, HttpServletRequest httpServletRequest) {
		
		Boolean authorised = true;
		
		context.put(KEY, authorised);
		
	}

}