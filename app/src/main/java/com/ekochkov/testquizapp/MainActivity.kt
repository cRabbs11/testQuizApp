package com.ekochkov.testquizapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.ekochkov.testquizapp.domian.Interactor
import com.ekochkov.testquizapp.view.GameFragment
import com.ekochkov.testquizapp.view.MainMenuFragment
import com.ekochkov.testquizapp.view.ResultsFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var interactor: Interactor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.instance.dagger.inject(this)
        interactor.populateDB()

        openMainMenuFragment()
    }

    fun openMainMenuFragment() {
        val fragment = MainMenuFragment()
        launchFragment(fragment = fragment)
    }

    fun openGameFragment() {
        val fragment = GameFragment()
        launchFragment(fragment = fragment)
    }

    fun openResultsFragment() {
        val fragment = ResultsFragment()
        launchFragment(fragment = fragment)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount<=1) {
            super.onBackPressed()
            finish()
        } else {
        super.onBackPressed()
        }
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}