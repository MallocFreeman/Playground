package de.drauschke.HomeNetworkService.speedtest.cache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Class is only used to use the @EnableCaching annotation to provide Springs caching abstraction.
 */
@Configuration
@EnableCaching
public class EhCacheConfiguration extends CachingConfigurerSupport {}
