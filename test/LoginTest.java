import com.avaje.ebean.Ebean;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;
import play.libs.Yaml;
import play.mvc.Result;
import play.test.WithApplication;

import java.util.List;
import java.util.Map;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static play.test.Helpers.*;

/**
 * Created by Maria on 12/1/15.
 */
public class LoginTest extends WithApplication {
    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase(), fakeGlobal()));
        Ebean.save((List) Yaml.load("test-data.yml"));
    }
/*
    @Test
    public void authenticateSuccess() {
        Result result = callAction(
                //here route should go
                controllers.routes.ref.Application.authenticate(),
                fakeRequest().withFormUrlEncodedBody(ImmutableMap.of(
                        "email", "bob@example.com",
                        "password", "secret"))
        );
        assertEquals(302, status(result));
        assertEquals("bob@example.com", session(result).get("email"));
    }
    */
}