package com.permissiontest.gavindev

import androidx.fragment.app.FragmentActivity

object PermissionX {
    private const val TAG = "InvisibleFragment"
    fun request(
        activity: FragmentActivity,
        vararg permissions: String,
        callback: PermissionCallBack
    ) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment !=null) {
            existedFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            //一定要使用commitNow，commit方法并不会立即执行添加操作，
            // 因而无法保证下一行代码执行时invisibleFragment已添加到Activity 中
            fragmentManager.beginTransaction().add(invisibleFragment,TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permissions)
    }
}