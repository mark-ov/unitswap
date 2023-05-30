package com.biotstoiq.cryptix;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
            Preference explore = findPreference("explore");
            Preference philosophy = findPreference("philosophy");
            Preference source = findPreference("source");

            explore.setOnPreferenceClickListener(preference -> {
                Intent discoverIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://biotstoiq.org"));
                startActivity(discoverIntent);
                return false;
            });

            philosophy.setOnPreferenceClickListener(preference -> {
                Intent discoverIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://biotstoiq.org/philosophy.html"));
                startActivity(discoverIntent);
                return false;
            });

            source.setOnPreferenceClickListener(preference -> {
                Intent discoverIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://biotstoiq.org/source.html"));
                startActivity(discoverIntent);
                return false;
            });
        }
    }
}