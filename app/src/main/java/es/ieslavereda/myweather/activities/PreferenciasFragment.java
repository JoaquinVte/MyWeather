package es.ieslavereda.myweather.activities;


import android.os.Bundle;

import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

import java.util.Arrays;
import java.util.List;

import es.ieslavereda.myweather.R;

public class PreferenciasFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setPreferencesFromResource(R.xml.preferencias, rootKey);



        // Modificacion de la vista de preferencias por codigo
        final ListPreference idioma = findPreference("idioma");
        final List<String> idioma_entries = Arrays.asList(getResources().getStringArray(R.array.idioma_entries));
        final List<String> idioma_values = Arrays.asList(getResources().getStringArray(R.array.idioma_values));

        int pos  = idioma_values.indexOf(GestionPreferencias.getInstance().getIdioma(getContext()));
        idioma.setSummary("Idioma en " + idioma_entries.get(pos));

        idioma.setOnPreferenceChangeListener((preference, newValue) -> {

            int pos1 = idioma_values.indexOf(newValue);
            idioma.setSummary("Idioma en " + idioma_entries.get(pos1));

            return true;
        });


        // ListPreference
        final ListPreference unidades = findPreference("unidades");
        final List<String> unidades_entries = Arrays.asList(getResources().getStringArray(R.array.unidades_entries));
        final List<String> unidades_values = Arrays.asList(getResources().getStringArray(R.array.unidades_values));

        pos  = unidades_values.indexOf(GestionPreferencias.getInstance().getUnidades(getContext()));

        unidades.setSummary("Unidades en " + unidades_entries.get(pos));
        unidades.setOnPreferenceChangeListener((preference, newValue) -> {

            int pos1 = unidades_values.indexOf(newValue);
            unidades.setSummary("Unidades en " + unidades_entries.get(pos1));

            return true;
        });



        // Theme preferences with ListPreference
        ListPreference themePreference = getPreferenceManager().findPreference(getString(R.string.settings_theme_key));
        if (themePreference.getValue() == null) {
            themePreference.setValue(ThemeSetup.Mode.DEFAULT.name());
        }
        themePreference.setSummary(GestionPreferencias.getInstance().getTheme(getContext()));
        themePreference.setOnPreferenceChangeListener((preference, newValue) -> {
            ThemeSetup.applyTheme(ThemeSetup.Mode.valueOf((String) newValue));
            themePreference.setSummary(GestionPreferencias.getInstance().getTheme(getContext()));
            return true;
        });
    }
}