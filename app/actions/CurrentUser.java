package actions;

import models.User;
import org.apache.commons.lang3.StringUtils;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;

import javax.xml.transform.Result;

/**
 * Created by Maria on 12/1/15.
 */
public class CurrentUser extends Action.Simple {


    @Override
    public F.Promise<play.mvc.Result> call(Http.Context ctx) throws Throwable{
        accessUser(ctx);
        return delegate.call(ctx);
    }
    private static User accessUser(Http.Context ctx)
    {
        User user = (User)ctx.args.get("user");
        if (user == null)
        {
            String userId = ctx.session().get("user_id");
            if (!StringUtils.isEmpty(userId))
            {
                user = User.find.byId(Long.parseLong(userId));
                if (user != null)
                {
                    ctx.args.put("user", user);
                }
            }
        }

        return user;
    }

    public static User currentUser()
    {
        return currentUser(Http.Context.current());
    }

    public static User currentUser(Http.Context context)
    {
        return accessUser(context);
    }

}
