package si.fri.rso.skupina3.rv_catalog.v1;

import com.kumuluz.ee.discovery.annotations.RegisterService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/v1")
@RegisterService("rv-catalog-service")
public class RvCatalogApplication extends Application {
}
