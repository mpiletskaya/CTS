import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.junit.Assert.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertEquals(2, a);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertEquals("text/html", contentType(html));
        assertTrue(contentAsString(html).contains("Your new application is ready."));
    }

/*
    @Test
    public void badRoute() {
        Result result = routeAndCall(fakeRequest(GET, "/xx/hh"));
        assertThat(result).isNull();
    }
/*
    @Test
    public void testUserIsFoundAndPassedToView() {
        Response response = POST("/user/find?name=mark&dob=18011977")
        assertThat(renderArgs("user"), is(notNullValue());
        User user = (User) renderArgs("user");
        assertThat(user.name, is("mark"));
    }
*/
}
