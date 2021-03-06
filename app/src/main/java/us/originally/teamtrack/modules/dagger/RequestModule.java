package us.originally.teamtrack.modules.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import us.originally.teamtrack.controllers.LandingActivity;
import us.originally.teamtrack.controllers.LoginActivity;
import us.originally.teamtrack.controllers.MainActivity;
import us.originally.teamtrack.managers.AudioPlayerManage;
import us.originally.teamtrack.managers.FireBaseManager;
import us.originally.teamtrack.modules.dagger.managers.UserManager;
import us.originally.teamtrack.modules.dagger.managers.impl.UserManagerImpl;
import us.originally.teamtrack.services.AudioService;
import us.originally.teamtrack.services.LocationTrackingService;

/**
 * Created by VietHoa on 03/05/15.
 */

@Module(
        complete = false,
        library = true,
        injects = {
                MainActivity.class,
                LoginActivity.class,
                LandingActivity.class,
                LocationTrackingService.class,
                AudioService.class
        }
)

public class RequestModule {

    @Provides
    @Singleton
    public FireBaseManager provideFireBaseManager(Context applicationContext) {
        return new FireBaseManager(applicationContext);
    }

    @Provides
    @Singleton
    public AudioPlayerManage provideAudioPlayerManage(Context applicationContext) {
        return new AudioPlayerManage(applicationContext);
    }

    @Provides
    @Singleton
    public UserManager providesUserManager(Context applicationContext, FireBaseManager fireBaseManager) {
        return new UserManagerImpl(applicationContext, fireBaseManager);
    }

}
