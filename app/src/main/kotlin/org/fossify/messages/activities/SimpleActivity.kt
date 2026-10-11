package org.fossify.messages.activities

import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import org.fossify.commons.activities.BaseSimpleActivity
import org.fossify.messages.R

open class SimpleActivity : BaseSimpleActivity() {

    /**
     * Flip-phone softkeys. Subclasses override these and return true when they handled the key.
     * Kyocera flips report the two softkeys as KEYCODE_SOFT_LEFT / KEYCODE_SOFT_RIGHT.
     */
    protected open fun onSoftLeft(): Boolean = false
    protected open fun onSoftRight(): Boolean = false

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.action == KeyEvent.ACTION_DOWN && event.repeatCount == 0) {
            val handled = when (event.keyCode) {
                KeyEvent.KEYCODE_SOFT_LEFT -> onSoftLeft()
                KeyEvent.KEYCODE_SOFT_RIGHT, KeyEvent.KEYCODE_MENU -> onSoftRight()
                else -> false
            }
            if (handled) return true
        }
        return super.dispatchKeyEvent(event)
    }

    /** Fills in the labels of an included view_softkey_bar layout. Pass null to leave a slot empty. */
    protected fun setSoftkeys(bar: View, left: String?, center: String?, right: String?) {
        bar.findViewById<TextView>(R.id.softkey_left)?.text = left.orEmpty()
        bar.findViewById<TextView>(R.id.softkey_center)?.text = center.orEmpty()
        bar.findViewById<TextView>(R.id.softkey_right)?.text = right.orEmpty()
    }

    override fun getAppIconIDs() = arrayListOf(
        R.mipmap.ic_launcher_red,
        R.mipmap.ic_launcher_pink,
        R.mipmap.ic_launcher_purple,
        R.mipmap.ic_launcher_deep_purple,
        R.mipmap.ic_launcher_indigo,
        R.mipmap.ic_launcher_blue,
        R.mipmap.ic_launcher_light_blue,
        R.mipmap.ic_launcher_cyan,
        R.mipmap.ic_launcher_teal,
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher_light_green,
        R.mipmap.ic_launcher_lime,
        R.mipmap.ic_launcher_yellow,
        R.mipmap.ic_launcher_amber,
        R.mipmap.ic_launcher_orange,
        R.mipmap.ic_launcher_deep_orange,
        R.mipmap.ic_launcher_brown,
        R.mipmap.ic_launcher_blue_grey,
        R.mipmap.ic_launcher_grey_black
    )

    override fun getAppLauncherName() = getString(R.string.app_launcher_name)

    override fun getRepositoryName() = "Messages"
}
