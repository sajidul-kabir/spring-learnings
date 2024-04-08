//package sajid.cachetest.config;
//
//import javax.cache.CacheManager;
//import javax.cache.Caching;
//import javax.cache.spi.CachingProvider;
//
//import org.ehcache.config.CacheConfiguration;
//import org.ehcache.config.builders.CacheConfigurationBuilder;
//import org.ehcache.config.builders.ExpiryPolicyBuilder;
//import org.ehcache.config.builders.ResourcePoolsBuilder;
//import org.ehcache.config.units.MemoryUnit;
//import org.ehcache.jsr107.Eh107Configuration;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import sajid.cachetest.entities.Employee;
//
//import java.time.Duration;
//import java.util.ArrayList;
//
//@Configuration
//public class EHConfiguration {
//
//    @Bean
//    public CacheManager ehCacheManager() {
//        CachingProvider provider = Caching.getCachingProvider();
//        CacheManager cacheManager = provider.getCacheManager();
//
//        CacheConfiguration<ArrayList, Employee> configuration = CacheConfigurationBuilder.newCacheConfigurationBuilder(ArrayList.class, Employee.class, ResourcePoolsBuilder
//                        .heap(100)
//                        .offheap(10, MemoryUnit.MB))
//                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMinutes(10)))
//                .build();
//
//        javax.cache.configuration.Configuration<ArrayList, Employee> cacheConfiguration = Eh107Configuration
//                .fromEhcacheCacheConfiguration(configuration);
//
//        cacheManager.createCache("employee", cacheConfiguration);
//
//        return cacheManager;
//    }
//}