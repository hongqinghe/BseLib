package middlem.person.basemodule.dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import middlem.person.basemodule.R;

public class DaggerSmapleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_smaple);
    }

    /**
     * 未使用dagger的情况下
     * @param view
     */
    public void noDagger(View view) {
        Person person=new Person();
        person.setName("笑话");
        person.setType("1");
        Dog dog=new Dog(person);
        dog.toSay();
    }

    public void DaggerInject(View view) {

    }
}
