package middlem.person.baselib.daggerdemo;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private final Person2 view;

    public MainModule(Person2 view){
        this.view = view ;
    }

    @Provides
    Person2 provideILogView(){
        return view ;
    }
}