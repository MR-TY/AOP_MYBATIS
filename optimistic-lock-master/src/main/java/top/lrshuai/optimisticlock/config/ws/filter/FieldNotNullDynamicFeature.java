package top.lrshuai.optimisticlock.config.ws.filter;

import top.lrshuai.optimisticlock.common.ApiException;
import top.lrshuai.optimisticlock.common.ApiResultEnum;
import top.lrshuai.optimisticlock.config.annotation.FieldNotNull;
import org.glassfish.jersey.server.model.AnnotatedMethod;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * @author tangyu
 * @date 2020/5/24
 */
@Provider
public class FieldNotNullDynamicFeature implements DynamicFeature {

    @Override
    public void configure(final ResourceInfo resourceInfo,
                          final FeatureContext configuration) {
        AnnotatedMethod am = new AnnotatedMethod(
                resourceInfo.getResourceMethod());
        FieldNotNull ra = am.getAnnotation(FieldNotNull.class);

        if (ra != null) {
            configuration.register(new AuthorityAllowedRequestFilter(ra.message()));
            return;
        }
    }

    @Priority(Priorities.ENTITY_CODER)
    private class AuthorityAllowedRequestFilter implements ContainerRequestFilter {

        private String message;

        public AuthorityAllowedRequestFilter(String message) {
            this.message = message;
        }

        @Override
        public void filter(ContainerRequestContext containerRequestContext) throws IOException {
            if (message != null){
                 throw new ApiException(500,message);
            }
        }
    }
}
