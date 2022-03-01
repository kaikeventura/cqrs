package com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface ReadOnlyRepository {
}
